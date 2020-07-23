package javaCore.GUI.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 23.04.2018
 */
public class CheckBoxRadioButton extends JFrame {
    private JLabel label;
    private JCheckBox bold;
    private JCheckBox italic;
    private JPanel buttonPanel;
    private ButtonGroup group;

    private static int FONTSIZE = 24;
    private static final int DEFAULT_SIZE = 36;
    private static int mode; //модификация шрифта

    public CheckBoxRadioButton() {
        label = new JLabel("The quick brown fox jumps over the lazy dog.");
        label.setFont(new Font("Serif", Font.BOLD, DEFAULT_SIZE));
        add(label, BorderLayout.CENTER);

        //реакция на флажки
        ActionListener listener = e -> {
            mode = 0;
            if (bold.isSelected()) mode += Font.BOLD;
            if (italic.isSelected()) mode += Font.ITALIC;
            label.setFont(new Font("Serif", mode, FONTSIZE));
        };

        //ввести флажки
        buttonPanel = new JPanel();

        bold = new JCheckBox("Bold");
        bold.addActionListener(listener);
        bold.setSelected(true);
        buttonPanel.add(bold);

        italic = new JCheckBox("Italic");
        italic.addActionListener(listener);
        buttonPanel.add(italic);

        group = new ButtonGroup();
        addRadioButton("Small", 8);
        addRadioButton("Medium", 12);
        addRadioButton("Large", 18);
        addRadioButton("Extra large", 36);


        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    /**
     * Ввести кнопку-переключатель, устанавливающую размер шрифта для выделения образцового текста
     *
     * @param name Строка надписи на кнопке
     * @param size Размер шрифта, устанавливаемый данной кнопкой
     */
    public void addRadioButton(String name, int size) {
        boolean selected = size == DEFAULT_SIZE;
        JRadioButton button = new JRadioButton(name, selected);
        group.add(button);
        buttonPanel.add(button);

        ActionListener listener = e ->{
            FONTSIZE = size;
            label.setFont(new Font("Serif", mode, size));
        };
        button.addActionListener(listener);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new CheckBoxRadioButton();
            frame.setLocationByPlatform(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
