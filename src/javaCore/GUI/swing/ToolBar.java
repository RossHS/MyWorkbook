package javaCore.GUI.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 28.04.2018
 */
public class ToolBar extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private JPanel panel;

    public ToolBar() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        //ввести панель инструментов для выбора цвета

        panel = new JPanel();
        add(panel, BorderLayout.CENTER);

        //задать действия

        Action blueAction = new ColorAction("Blue", new ImageIcon(""), Color.BLUE);
        Action yellowAction = new ColorAction("Yellow", new ImageIcon(""), Color.YELLOW);
        Action redAction = new ColorAction("Red", new ImageIcon(""), Color.RED);

        Action exitAction = new AbstractAction("Exit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };

        exitAction.putValue(Action.SHORT_DESCRIPTION, "Exit");

        //заполнить панель инструментов

        JToolBar bar = new JToolBar();
        bar.add(blueAction);
        bar.add(yellowAction);
        bar.add(redAction);
        bar.addSeparator();
        bar.add(exitAction);
        add(bar, BorderLayout.NORTH);

        //заполнить меню

        JMenu menu = new JMenu("Color");
        menu.add(yellowAction);
        menu.add(blueAction);
        menu.add(redAction);
        menu.add(exitAction);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    /**
     * Действие изменения цвета, задающее выбранный цвет фона фрейма
     */
    class ColorAction extends AbstractAction {
        public ColorAction(String name, Icon icon, Color c) {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, name + " background");
            putValue("Color", c);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color c = (Color) getValue("Color");
            panel.setBackground(c);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ToolBar();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

}
