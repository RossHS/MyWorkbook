package javaCore.GUI.swing.circleLayout;

import javax.swing.*;
import java.awt.*;

/**
 * Фрейм, в котором демонстрируется расположение кнопок по кругу
 *
 * @author Ross Khapilov
 * @version 1.0 created on 01.05.2018
 */
public class CircleLayoutFrame extends JFrame {
    public CircleLayoutFrame() {
        setLayout(new CircleLayout());
        add(new JButton("Yellow"));
        add(new JButton("Blue"));
        add(new JButton("Red"));
        add(new JButton("Green"));
        add(new JButton("Orange"));
        pack();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new CircleLayoutFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
