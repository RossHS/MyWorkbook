package javaCore.deployingJavaApp.properties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Properties;

/**
 * В этой программе проверяется свойства. В ней запоминаются положение, размер и заголовок фрейма
 *
 * @author Ross Khapilov
 * @version 1.0 created on 16.05.2018
 */
public class PropertiesTest {
    public static void main(String... args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new PropertiesFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class PropertiesFrame extends JFrame {
    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

    private File propertiesFile;
    private Properties settings;

    public PropertiesFrame() {
        // получить положение, размеры и заголовок фрейма из свойств

        String userDir = System.getProperty("user.home");
        File propertiesDir = new File(userDir, ".Learning");

        //если указанной папки не существует, то создаем эту папку
        if (!propertiesDir.exists()) propertiesDir.mkdir();

        propertiesFile = new File(propertiesDir, "program.properties");

        //задаем стандартные характеристики для окна
        Properties defaultSettings = new Properties();
        defaultSettings.setProperty("left", "0");
        defaultSettings.setProperty("top", "0");
        defaultSettings.setProperty("width", "" + DEFAULT_WIDTH);
        defaultSettings.setProperty("height", "" + DEFAULT_HEIGHT);
        defaultSettings.setProperty("title", "");

        settings = new Properties(defaultSettings);

        //если файл с настройками существует, что загружаем данные из него
        if (propertiesFile.exists())
            try (InputStream in = new FileInputStream(propertiesFile)) {
                settings.load(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
        int left = Integer.parseInt(settings.getProperty("left"));
        int top = Integer.parseInt(settings.getProperty("top"));
        int width = Integer.parseInt(settings.getProperty("width"));
        int height = Integer.parseInt(settings.getProperty("height"));
        setBounds(left, top, width, height);

        // если заголовок не задан, запросить его у пользователя
        String title = settings.getProperty("title");
        if (title.equals(""))
            title = JOptionPane.showInputDialog("Please supply a frame title:");
        if (title == null) title = "";
        setTitle(title);

        //при закрытии окна сохраняем его настройки
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                settings.setProperty("left", "" + getX());
                settings.setProperty("top", "" + getY());
                settings.setProperty("width", "" + getWidth());
                settings.setProperty("height", "" + getHeight());
                settings.setProperty("title", getTitle());
                try (OutputStream out = new FileOutputStream(propertiesFile)) {
                    settings.store(out, "Program Properties");
                } catch (IOException exc) {
                    exc.printStackTrace();
                }
                System.exit(0);
            }
        });
    }
}

