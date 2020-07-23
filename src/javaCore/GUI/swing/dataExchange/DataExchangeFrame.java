package javaCore.GUI.swing.dataExchange;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Фрейм со строкой меню, при выборе команды File-Connect из которого появляется диалоговое окно для ввода пароля
 *
 * @author Ross Khapilov
 * @version 1.0 created on 02.05.2018
 */
public class DataExchangeFrame extends JFrame {
    public static final int TEXT_ROWS = 20;
    public static final int TEXT_COLUMNS = 40;
    private PasswordChooser dialog = null;
    private JTextArea textArea;

    public DataExchangeFrame() {
        // сконструировать меню File

        JMenuBar mbar = new JMenuBar();
        setJMenuBar(mbar);
        JMenu fileMenu = new JMenu("File");
        mbar.add(fileMenu);

        // добавить в меню пункты Connect и Exit

        JMenuItem connectItem = new JMenuItem("Connect");
        connectItem.addActionListener(new ConnectAction());
        fileMenu.add(connectItem);

        // при выборе меню Exit программа закрывается

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(event -> System.exit(0));
        fileMenu.add(exitItem);

        textArea = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        pack();
    }

    /**
     * При выполнении команды Connect появляется диалоговое окно для ввода пароля
     */
    private class ConnectAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            // при первом обращении конструируется диалоговое окно

            if (dialog == null) dialog = new PasswordChooser();

            // установить значения по умолчанию
            dialog.setUser(new User("yourname", null));

            // показать диалоговое окно
            if (dialog.showDialog(DataExchangeFrame.this, "Connect")) {
                // если пользователь подтвердил введенные данные, извлечь их для последующей обработки
                User u = dialog.getUser();
                textArea.append("user name = " + u.getName() + ", password = "
                        + (new String(u.getPassword())) + "\n");
            }
        }
    }
}
