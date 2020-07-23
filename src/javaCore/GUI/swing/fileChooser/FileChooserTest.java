package javaCore.GUI.swing.fileChooser;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 02.05.2018
 */
public class FileChooserTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ImageViewerFrame();
            frame.setTitle("FileChooserTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
