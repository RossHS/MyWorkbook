package javaCore.GUI.swing.calculator;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 23.04.2018
 */
public class Calculator {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame jFrame = new JFrame();
            CalculatorPanel panel = new CalculatorPanel();
            jFrame.add(panel);
            jFrame.pack();
            jFrame.setLocationByPlatform(true);
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setVisible(true);
        });
    }
}
