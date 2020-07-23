package javaCore.GUI.swing.colorChooser;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 02.05.2018
 */
public class ColorChooserTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ColorChooserFrame();
            frame.setTitle("ColorChooserTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
