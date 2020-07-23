package javaCore.GUI.swing;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Фрейм с кнопками-переключателями для выбора стиля границы
 *
 * @author Ross Khapilov
 * @version 1.0 created on 24.04.2018
 */
public class BorderFrame extends JFrame {
    private JPanel demoPanel;
    private JPanel buttonPanel;
    private ButtonGroup group;

    public BorderFrame() {
        demoPanel = new JPanel();
        buttonPanel = new JPanel();
        group = new ButtonGroup();

        addRadioButton("Lower bevel", BorderFactory.createLoweredBevelBorder());
        addRadioButton("Raised bevel", BorderFactory.createRaisedBevelBorder());
        addRadioButton("Etched", BorderFactory.createEtchedBorder());
        addRadioButton("Line", BorderFactory.createLineBorder(Color.MAGENTA));
        addRadioButton("Matte", BorderFactory.createMatteBorder(10, 10, 10, 10, Color.GREEN));
        addRadioButton("Empty", BorderFactory.createEmptyBorder());

        Border etched = BorderFactory.createEtchedBorder();
        Border titled = BorderFactory.createTitledBorder(etched, "Border types");
        buttonPanel.setBorder(titled);

        setLayout(new GridLayout(2, 1));
        add(buttonPanel);
        add(demoPanel);
        pack();
    }

    public void addRadioButton(String buttonName, Border b) {
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(e -> demoPanel.setBorder(b));
        group.add(button);
        buttonPanel.add(button);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame frame = new BorderFrame();
            frame.setTitle("Border Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
