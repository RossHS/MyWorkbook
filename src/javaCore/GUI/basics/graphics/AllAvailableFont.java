package javaCore.GUI.basics.graphics;

import java.awt.*;

/**
 * Класс для вывода в консоль всех доступных шрифтов
 *
 * @author Ross Khapilov
 * @version 1.0 created on 27.01.2018
 */
public class AllAvailableFont {
    public static void main(String[] args) {
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String s : fontNames) {
            System.out.println(s);
        }
    }

}
