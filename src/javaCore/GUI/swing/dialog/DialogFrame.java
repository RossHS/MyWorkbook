package javaCore.GUI.swing.dialog;

import javax.swing.*;

/**
 * Фрейм со строкой меню, при выборе команд File About из которого появляется диалоговое окно About
 * @author Ross Khapilov
 * @version 1.0 created on 02.05.2018
 */
public class DialogFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private AboutDialog dialog;

    public DialogFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // Построить меню File

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        // добавить About и Exit пункты меню

        // при выборе пункта меню About открывается одноименное диалоговое окно

        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(event -> {
            if (dialog == null) // первый раз
                dialog = new AboutDialog(DialogFrame.this);
            dialog.setVisible(true); // показать диалоговое окно
        });
        fileMenu.add(aboutItem);

        // при выборе меню Exit происходит выход из программы

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(event -> System.exit(0));
        fileMenu.add(exitItem);
    }
}