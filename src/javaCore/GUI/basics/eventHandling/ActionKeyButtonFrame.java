package javaCore.GUI.basics.eventHandling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Пример обработки событий связанных с нажатие комбинаций клавиш, кнопок и т.п.Итак, чтобы одно и то же действие
 * выполнялось в ответ на щелчок на экранной кнопке, выбор пункта меню или нажатие клавиши, следует предпринять
 * описанные ниже шаги.
 * 1. Реализовать класс, расширяющий класс AbstractAction. Один класс можно будет использовать для
 * программирования разных взаимосвязанных действий.
 * 2. Создать объект класса действия.
 * 3. Сконструировать экранную кнопку или пункт меню из объекта действия. Конструктор прочтет текст метки и
 * пиктограмму из объекта действия.
 * 4. Для действий, которые выполняются в ответ на нажатие клавиш, нужно предпринять дополнительные шаги.
 * • Сначала следует обнаружить в окне компонент верхнего уровня, например, панель, содержащую все остальные компоненты.
 * • Затем проверить условие привязки ввода WHEN__ANCESTOR_OF_FOCUSED_COMPONENT компонента верхнего уровня.
 * • Создать объект типа Keystroke для нужного нажатия клавиш.
 * • Создать объект, соответствующий нажатию клавиш, например, символьную строку, описывающую нужное действие.
 * • Добавить пару (нажатие клавиш, ответное действие) к привязке ввода.
 * • И наконец, получить привязку действия для компонента верхнего уровня, а затем добавить пару
 * (ответное действие, объект действия) к привязке действия.
 *
 * @author Ross Khapilov
 * @version 1.0 created on 05.02.2018
 */
public class ActionKeyButtonFrame extends JFrame {
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public ActionKeyButtonFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        buttonPanel = new JPanel();

        //Определяем действия
        Action yellowAction = new ColorAction("Yellow", null, Color.YELLOW);
        Action blueAction = new ColorAction("Blue", null, Color.BLUE);
        Action redAction = new ColorAction("Red", null, Color.RED);

        //добавляем кнопки на панель
        buttonPanel.add(new JButton(yellowAction));
        buttonPanel.add(new JButton(blueAction));
        buttonPanel.add(new JButton(redAction));

        //вводим панель во фрейм
        add(buttonPanel);

        //Привязываем клавиши к надписям на кнопках
        InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
        imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
        imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");
        imap.put(KeyStroke.getKeyStroke("ctrl Q"), "panel.exit");

        //привязка надписи на кнопках панели к действиям
        ActionMap actionMap = buttonPanel.getActionMap();
        actionMap.put("panel.yellow", yellowAction);
        actionMap.put("panel.blue", blueAction);
        actionMap.put("panel.red", redAction);
        actionMap.put("panel.exit", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    public class ColorAction extends AbstractAction {
        /**
         * Конструктор действие по изменению цвета
         *
         * @param name Надпись на экранной кнопке
         * @param icon Пиктограмма на экранной кнопке
         * @param c    Цвет фона
         */
        public ColorAction(String name, Icon icon, Color c) {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, "Set panel color to " + name.toLowerCase());
            putValue("color", c);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color c = (Color) getValue("color");
            buttonPanel.setBackground(c);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ActionKeyButtonFrame frame = new ActionKeyButtonFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
