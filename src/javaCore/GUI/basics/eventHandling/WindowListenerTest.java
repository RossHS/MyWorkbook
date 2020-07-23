package javaCore.GUI.basics.eventHandling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Пример работы с событиями связанными с закрытием окна, свертыванием и т.п. Для такого рода событий
 * используется интерфейс WindowListener который имеет 7 методом. Если нас интересует лишь один метод и нам не нужны
 * 6 остальных (т.е. не придется переопределять 6 пустых методом), существует специальный класс WindowAdapter,
 * который уже имеет 7 пустых реализаций методом из интерфейса
 *
 * @author Ross Khapilov
 * @version 1.0 created on 04.02.2018
 */
public class WindowListenerTest extends JFrame {
    public WindowListenerTest() {
        WindowListener listener = new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("WindowListenerTest.windowClosed");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("WindowListenerTest.windowDeactivated");
            }

            @Override
            public void windowGainedFocus(WindowEvent e) {
                System.out.println("WindowListenerTest.windowGainedFocus");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("WindowListenerTest.windowActivated");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("WindowListenerTest.windowClosing");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("WindowListenerTest.windowDeiconified");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("WindowListenerTest.windowIconified");
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                System.out.println("WindowListenerTest.windowLostFocus");
            }

            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("WindowListenerTest.windowOpened");
            }

            @Override
            public void windowStateChanged(WindowEvent e) {
                System.out.println("WindowListenerTest.windowStateChanged");
            }
        };
        this.addWindowListener(listener);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            WindowListenerTest frame = new WindowListenerTest();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300,300);
            frame.setVisible(true);
        });
    }
}
