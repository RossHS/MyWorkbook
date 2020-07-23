package javaCore.GUI.basics.eventHandling;

import javaCore.GUI.debug.EventTracer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Работа с обработкой событий происходит след образом
 * 1) Слушатель событий - это экземпляр класса, реализующий интерфейс ActionListener
 * 2) Источник событий - это объект, способный регистрировать слушателей и посылать им события(нажатие на кнопку и т.п.)
 * 3) При наступлении события (клик по кнопке) источник посылает объект событий всем зарегистрированным слушателям
 * 4) Слушатель использует данные, инкапсулированные в объекте события, чтобы решить, как реагировать на это событие.
 * <p>
 * Проанализируем исходный код метода actionPerformed () более подробно. Оказывается, что поле buttonPanel во
 * внутреннем классе ColorAction отсутствует, но оно имеется во внешнем классе ButtonFrame. Такая ситуация встречается
 * довольно часто. Объекты приемников событий должны выполнять определенные действия, оказывающие влияние на другие
 * объекты. И зачастую бывает очень удобно заранее включить класс приемника событий в состав другого класса, состояние
 * которого должен видоизменить этот приемник.
 * <p>
 * Фрейм с панелью экранных кнопок
 *
 * @author Ross Khapilov
 * @version 1.0 created on 04.02.2018
 */
public class ButtonFrame extends JFrame {
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public ButtonFrame() {

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        //создаем экранные кнопки
        JButton yellowButton = new JButton("Yellow");
        JButton blueButton = new JButton("Blue");
        JButton redButton = new JButton("Red");
        buttonPanel = new JPanel();

        //вводим кнопки на панель
        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);

        //вводим панель во фрейм
        add(buttonPanel);

        //Слушатель для экранных кнопок
        ColorAction yellowAction = new ColorAction(Color.YELLOW);
        ColorAction blueAction = new ColorAction(Color.BLUE);
        ColorAction redAction = new ColorAction(Color.RED);

        //связываем действия с кнопками
        yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);

        //кнопка выхода
        JButton exit = new JButton("Exit");
        ButtonModel bm = exit.getModel();
        System.out.println(bm.getClass().getName());
        exit.addActionListener(e -> System.exit(0));
        buttonPanel.add(exit);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ButtonFrame frame = new ButtonFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    class ColorAction implements ActionListener {
        private Color backgroundColor;

        public ColorAction(Color c) {
            backgroundColor = c;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            buttonPanel.setBackground(backgroundColor);
        }
    }
}