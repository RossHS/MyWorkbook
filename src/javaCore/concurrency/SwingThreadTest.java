package javaCore.concurrency;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * В этой программе демонстрируется, что поток, исполняемый параллельно с потоком диспетчеризации событий, может вызвать
 * ошибки в работе компонентов Swing.
 *
 * @author Ross Khapilov
 * @version 1.0 17.09.2018
 */
public class SwingThreadTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new SwingThreadFrame();
            frame.setTitle("SwingThreadTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * В этом фрейме имеются две кнопки для заполнения комбинированного
 * списка из отдельного потока. Кнопка Good обновляет этот список
 * через очередь событий, а кнопка Bad - непосредственно
 */
class SwingThreadFrame extends JFrame {
    public SwingThreadFrame() {
        final JComboBox<Integer> combo = new JComboBox<>();
        combo.insertItemAt(Integer.MAX_VALUE, 0);
        combo.setPrototypeDisplayValue(combo.getItemAt(0));
        combo.setSelectedIndex(0);

        JPanel panel = new JPanel();

        JButton goodButton = new JButton("Good");
        goodButton.addActionListener(e -> new Thread(new GoodWorkerRunnable(combo)).start());
        panel.add(goodButton);

        JButton badButton = new JButton("Bad");
        badButton.addActionListener(e -> new Thread(new BadWorkerRunnable(combo)).start());
        panel.add(badButton);

        panel.add(combo);
        add(panel);
        pack();
    }

}

/**
 * В этом исполняемом потоке комбинированный список видоизменяется
 * путем произвольного ввода и удаления чисел. Это может привести
 * к ошибкам, так как методы видоизменения комбинированного списка
 * не синхронизированы, и поэтому этот список доступен как из
 * рабочего потока, так и из потока диспетчеризации событий
 */
class BadWorkerRunnable implements Runnable {
    private JComboBox<Integer> combo;
    private Random generator;

    public BadWorkerRunnable(JComboBox<Integer> aCombo) {
        combo = aCombo;
        generator = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                int i = Math.abs(generator.nextInt());
                if (i % 2 == 0)
                    combo.insertItemAt(i, 0);
                else if (combo.getItemCount() > 0)
                    combo.removeItemAt(i % combo.getItemCount());
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
        }
    }
}

/**
 * Этот исполняемый поток видоизменяет комбинированный список,
 * произвольно вводя и удаляя числа. Чтобы исключить нарушение
 * содержимого этого списка, редактирующие операции направляются
 * в поток диспетчеризации событий
 */
class GoodWorkerRunnable implements Runnable {
    private JComboBox<Integer> combo;
    private Random generator;

    public GoodWorkerRunnable(JComboBox<Integer> aCombo) {
        combo = aCombo;
        generator = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                EventQueue.invokeLater(() -> {
                    int i = Math.abs(generator.nextInt());
                    if (i % 2 == 0)
                        combo.insertItemAt(i, 0);
                    else if (combo.getItemCount() > 0)
                        combo.removeItemAt(i % combo.getItemCount());
                });
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
        }
    }
}