package javaCore.GUI.basics.graphics;

import javax.swing.*;
import java.awt.*;

/**
 * Окно верхнего уровня (т.е. такое окно, которое не содержится внутри другого окна) в Java называется фреймом.
 * В библиотеке AWT для такого окна предусмотрен класс Frame. А в библиотеке swing его аналогом является класс JFrame.
 * Класс JFrame расширяет класс Frame и представляет собой один из немногих компонентов библиотеки swing, которые не
 * воспроизводятся на холсте. Экранные кнопки, строка заголовков, пиктограммы и другие элементы оформления окон
 * реализуются с помощью пользовательской оконной системы, а не библиотеки swing.
 *
 * @author Ross Khapilov
 * @version 1.0 created on 27.01.2018
 */
public class SimpleFrame extends JFrame {
    public SimpleFrame() {
        //Получить размеры экрана
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        //ОС сама выберет куда расположить фрейм
        setLocationByPlatform(true);

        //пиктограмма для фрейма
        Image image = new ImageIcon("src\\javaCore\\GUI\\basics\\graphics\\356.jpg").getImage();
        setIconImage(image);
    }
}

class FrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame simpleFrame = new SimpleFrame();
            simpleFrame.setTitle("Test");
            simpleFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            simpleFrame.setVisible(true);
        });
    }
}
