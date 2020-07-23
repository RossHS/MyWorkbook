package javaCore.GUI.debug;

import javaCore.GUI.basics.eventHandling.ButtonFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 02.05.2018
 */
public class RobotTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            // создать фрейм с панелью кнопок

            ButtonFrame frame = new ButtonFrame();
            frame.setTitle("ButtonTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });

        // присоединить робот к устройству вывода на экран

        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice screen = environment.getDefaultScreenDevice();

        try {
            final Robot robot = new Robot(screen);
            robot.waitForIdle();
            new Thread(() -> runTest(robot)).start();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    /**
     * Выполняет простую тестовую процедуру
     *
     * @param robot Робот, присоединяемый к устройству вывода на экран
     */
    public static void runTest(Robot robot) {
        // сымитировать нажатие клавиши пробела
        robot.keyPress(' ');
        robot.keyRelease(' ');

        // сымитировать нажатие клавиш табуляции и пробела
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(' ');
        robot.keyRelease(' ');

        // сымитировать щелчок кнопкой мыши на крайней справа кнопке
        robot.delay(2000);
        robot.mouseMove(220, 40);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        // захватить экран и показать полученное в итоге изображение
        robot.delay(2000);
        BufferedImage image = robot.createScreenCapture(new Rectangle(0, 0, 400, 300));
        ImageFrame frame = new ImageFrame(image);
        frame.setVisible(true);
    }
}

/**
 * Фрейм для показа захваченного изображения экрана
 */
class ImageFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 450;
    private static final int DEFAULT_HEIGHT = 350;

    public ImageFrame(Image image) {
        setTitle("Capture");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        JLabel label = new JLabel(new ImageIcon(image));
        add(label);
    }
}
