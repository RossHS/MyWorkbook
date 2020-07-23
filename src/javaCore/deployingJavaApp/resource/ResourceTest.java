package javaCore.deployingJavaApp.resource;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 16.05.2018
 */
public class ResourceTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ResourceTestFrame();
            frame.setTitle("ResourceTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * Фрейм, в котором загружаются ресурсы изображений и текста
 */
class ResourceTestFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;

    public ResourceTestFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        URL aboutURL = getClass().getResource("about.jpg");
        Image img = new ImageIcon(aboutURL).getImage();
        setIconImage(img);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        InputStream stream = getClass().getResourceAsStream("about.txt");
        try (Scanner scanner = new Scanner(stream)) {
            while (scanner.hasNext()) {
                textArea.append(scanner.nextLine() + "\n");
            }
        }
        add(textArea);
    }
}
