package javaCore.GUI.basics.eventHandling;

import javax.swing.*;
import java.awt.*;

/**
 * Все тоже самое, только другим способом
 *
 * @author Ross Khapilov
 * @version 1.0 created on 04.02.2018
 */
public class ButtonFrameBetter extends JFrame {
    private JPanel buttonPanel;
    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

    public ButtonFrameBetter() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        //вводим панель во фрейм
        buttonPanel = new JPanel();
        add(buttonPanel);
        makeButton("Red", Color.RED);
        makeButton("Blue", Color.BLUE);
        makeButton("Orange", Color.ORANGE);
        //кнопка выхода
        JButton exit = new JButton("Exit");
        exit.addActionListener(e -> System.exit(0));
        buttonPanel.add(exit);
    }

    public void makeButton(String name, Color backgroundColor) {
        JButton button = new JButton(name);
        buttonPanel.add(button);
        button.addActionListener(e -> buttonPanel.setBackground(backgroundColor));
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ButtonFrameBetter frame = new ButtonFrameBetter();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

