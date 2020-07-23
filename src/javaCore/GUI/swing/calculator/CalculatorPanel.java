package javaCore.GUI.swing.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Панель с кнопками и областью отображения результата калькуляции
 *
 * @author Ross Khapilov
 * @version 1.0 created on 23.04.2018
 */
public class CalculatorPanel extends JPanel {
    private JButton display; //экраном является неизменяемая кнопка
    private JPanel panel; //панель с клавишами
    private double result;
    private String lastCommandl;
    private boolean start;

    public CalculatorPanel() {
        setLayout(new BorderLayout());
        result = 0;
        lastCommandl = "=";
        start = true;
        //ввести область отображения результатов калькуляций
        display = new JButton("0");
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);

        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();

        //ввести кнопку сеткой 4 х 4
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton("/", command);

        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton("*", command);

        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("-", command);

        addButton("0", insert);
        addButton(".", insert);
        addButton("=", command);
        addButton("+", command);

        add(panel, BorderLayout.CENTER);
    }

    /**
     * ВВодит кнопку на центральной панели
     *
     * @param label    Метка кнопки
     * @param listener Слушатель событий
     */
    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel.add(button);
    }

    /**
     * Выполняет калькуляцию
     *
     * @param x Значение, накапливаемое с учетом предыдущего результата
     */
    public void calculate(double x) {
        if (lastCommandl.equals("+")) result += x;
        else if (lastCommandl.equals("-")) result -= x;
        else if (lastCommandl.equals("*")) result *= x;
        else if (lastCommandl.equals("/")) result /= x;
        else if (lastCommandl.equals("=")) result = x;
        display.setText("" + result);
    }

    /**
     * При обработке событий строка действия кнопки вводится в конце отображаемого текста
     */
    private class InsertAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = e.getActionCommand();
            if (start) {
                display.setText("");
                start = false;
            }
            display.setText(display.getText() + input);
        }
    }

    /**
     * При обработке событий выполняется команда, указанная в строке действия кнопки
     */
    private class CommandAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (start) {
                if (command.equals("-")) {
                    display.setText(command);
                    start = false;
                } else lastCommandl = command;
            } else {
                calculate(Double.parseDouble(display.getText()));
                lastCommandl = command;
                start = true;
            }
        }
    }
}
