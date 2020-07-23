package javaCore.GUI.basics.graphics;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 27.01.2018
 */
public class NotHelloWorld {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new NotHelloWorldFrame();
            frame.setTitle("NotHelloWorld");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class NotHelloWorldFrame extends JFrame {
    public NotHelloWorldFrame() {
        add(new NotHelloWorldComponent());
        pack();
    }
}

class NotHelloWorldComponent extends JComponent {
    @Override
    public void paintComponent(Graphics g) {
        g.drawString("Not a Hello, World program", 75, 100);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 200);
    }
}
