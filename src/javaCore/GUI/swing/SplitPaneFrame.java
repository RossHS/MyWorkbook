package javaCore.GUI.swing;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ross Khapilov
 * @version 1.0 16.07.2018
 */
public class SplitPaneFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;

    private String[] strings = {"A", "B", "C"};

    public SplitPaneFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        final JList<String> stringJList = new JList<>(strings);
        final JLabel planetImag = new JLabel();
        final JTextArea descr = new JTextArea();

        JSplitPane innerPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, stringJList, planetImag);
        innerPane.setContinuousLayout(true);
        innerPane.setOneTouchExpandable(true);

        JSplitPane outerPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, innerPane, descr);
        add(outerPane, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SplitPaneFrame s = new SplitPaneFrame();
            s.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            s.setVisible(true);
        });
    }
}
