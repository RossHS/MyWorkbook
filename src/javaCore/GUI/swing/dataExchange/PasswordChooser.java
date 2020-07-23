package javaCore.GUI.swing.dataExchange;

import javax.swing.*;
import java.awt.*;

/**
 * Окно для ввода пароля
 *
 * @author Ross Khapilov
 * @version 1.0 created on 02.05.2018
 */
public class PasswordChooser extends JPanel {
    private JTextField username;
    private JPasswordField password;
    private JButton okButton;
    private boolean ok;
    private JDialog dialog;

    public PasswordChooser() {
        setLayout(new BorderLayout());

        // сконструировать панель с полями для ввода имени и пароля

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        panel.add(new JLabel("User name:"));
        panel.add(username = new JTextField(""));
        panel.add(new JLabel("Password:"));
        panel.add(password = new JPasswordField(""));
        add(panel, BorderLayout.CENTER);

        // создать кнопки OK и Cancel для закрытия диалогового окна

        okButton = new JButton("Ok");
        okButton.addActionListener(event -> {
            ok = true;
            dialog.setVisible(false);
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(event -> dialog.setVisible(false));

        // ввести панель на южную границу

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Устанавливает диалоговое окно в исходное состояние
     *
     * @param u Данные о пользователе по умолчанию
     */
    public void setUser(User u) {
        username.setText(u.getName());
    }

    /**
     * Получает данные, введенные в диалоговом окне
     *
     * @return Объект типа User, состояние которого отражает введенные пользователем данные
     */
    public User getUser() {
        return new User(username.getText(), password.getPassword());
    }

    /**
     * Отображает панель для ввода пароля в диалоговом окне
     *
     * @param parent Компонент из фрейма-владельца или пустое значение null
     * @param title  Заголовок диалогового окна
     */
    public boolean showDialog(Component parent, String title) {
        ok = false;

        // обнаружить фрейм-владелец

        Frame owner;
        if (parent instanceof Frame) owner = (Frame) parent;
        else owner = (Frame) SwingUtilities.getAncestorOfClass(Frame.class, parent);

        // создать новое диалоговое окно при первом обращении или изменении фрейма-владельца

        if (dialog == null || dialog.getOwner() != owner) {
            dialog = new JDialog(owner, true);
            dialog.add(this);
            dialog.getRootPane().setDefaultButton(okButton);
            dialog.pack();
        }

        // установить заголовок и отобразить диалоговое окно

        dialog.setTitle(title);
        dialog.setVisible(true);
        return ok;
    }
}
