package javaCore.GUI.basics.eventHandling;

import javax.swing.*;
import java.awt.*;

/**
 * Пример смены стилей
 *
 * @author Ross Khapilov
 * @version 1.0 created on 04.02.2018
 */
public class LookAndFeelTest extends JFrame {
    private JPanel buttonPanel;

    public LookAndFeelTest() {
        buttonPanel = new JPanel();
        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : infos) {
            System.out.println(info.getClassName());
            makeButton(info.getName(), info.getClassName());
        }
        add(buttonPanel);
        setSize(600, 400);
    }

    /**
     * Изменяет стиль после шелчка по кнопке
     *
     * @param name      Имя кнопки
     * @param className имя класса стиля
     */
    private void makeButton(String name, String className) {
        JButton jButton = new JButton(name);
        buttonPanel.add(jButton);

        //слушатель кнопок
        jButton.addActionListener(e -> {
            try {
                UIManager.setLookAndFeel(className);
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            LookAndFeelTest frame = new LookAndFeelTest();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
