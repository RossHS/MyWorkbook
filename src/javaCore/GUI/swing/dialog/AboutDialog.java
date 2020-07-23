package javaCore.GUI.swing.dialog;

import javax.swing.*;
import java.awt.*;

/**
 * Образец модального диалогового окна, в котором выводится сообщение и ожидается до тех пор,
 * пока пользователь не нажмет кнопку OK
 *
 * @author Ross Khapilov
 * @version 1.0 created on 02.05.2018
 */
public class AboutDialog extends JDialog {
    public AboutDialog(JFrame owner) {
        super(owner, "About DialogTest", true);

        // ввести HTML-метку по центру окна

        add(new JLabel("<html><hl><i>Core Java</ix/hl><hr>By Cay Horstmann</html>"), BorderLayout.CENTER);

        // при выборе кнопка OK диалоговое окно закрывается

        JButton ok = new JButton("OK");
        ok.addActionListener(e -> setVisible(false));

        // ввести кнопку OK в нижней части окна у южной его границы

        JPanel panel = new JPanel();
        panel.add(ok);
        add(panel, BorderLayout.SOUTH);

        pack();

    }
}
