package javaCore.GUI.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Фрейм с образцовым текстом метки и комбинированным списком для выбора начертаний шрифта
 *
 * @author Ross Khapilov
 * @version 1.0 created on 24.04.2018
 */
public class ComboBoxFrame extends JFrame {
    private JComboBox<String> faceCombo;
    private JLabel label;
    private static final int DEFAULT_SIZE = 24;

    public ComboBoxFrame() {
        label = new JLabel("The quick brown fox jumps over the lazy dog");
        label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
        add(label, BorderLayout.CENTER);

        //Составить комбинированный список и ввести в него название начертаний шрифта

        faceCombo = new JComboBox<>();
        faceCombo.addItem("Serif");
        faceCombo.addItem("SansSerif");
        faceCombo.addItem("Monospaced");
        faceCombo.addItem("Dialog");
        faceCombo.addItem("DialogInput");

        //приемник событий от комбинированного списка изменяет на выбранное начертание шрифта,
        // которым набран текст метки

        faceCombo.addActionListener(e ->
                label.setFont(
                        new Font(faceCombo.getItemAt(faceCombo.getSelectedIndex()),
                                Font.PLAIN,
                                DEFAULT_SIZE)));

        //ввести комбинированный список на панели у южной границы фрейма

        JPanel combopanel = new JPanel();
        combopanel.add(faceCombo);
        add(combopanel, BorderLayout.SOUTH);
        pack();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ComboBoxFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
