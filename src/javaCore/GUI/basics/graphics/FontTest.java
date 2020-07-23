package javaCore.GUI.basics.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * Пример работы со шрифтами
 *
 * @author Ross Khapilov
 * @version 1.0 created on 27.01.2018
 */
public class FontTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = setFrame();
        });
    }

    private static JFrame setFrame() {
        JFrame frame = new JFrame();
        frame.add(new FontComponent());
        frame.pack();
        frame.setTitle("FontTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        return frame;
    }

    private static class FontComponent extends JComponent {
        private static final int DEFAULT_WIDTH = 300;
        private static final int DEFAULT_HEIGHT = 200;

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            String message = "Hello, World!";
            Font f = new Font("Serif", Font.BOLD, 36);
            g2.setFont(f);

            //размер текстового сообщения
            FontRenderContext context = g2.getFontRenderContext();
            Rectangle2D bounds = f.getStringBounds(message, context);

            //Определить координаты верхнего левого угла текста
            double x = (getWidth() - bounds.getWidth()) / 2;
            double y = (getHeight() - bounds.getHeight()) / 2;

            //сложить подъем с координатой у, чтобы достичь базовой линии
            double ascent = -bounds.getY();
            double baseY = y + ascent;

            //воспроизвести сообщение
            g2.drawString(message, (int) x, (int) baseY);
            g2.setPaint(Color.GREEN);
            // нарисовать базовую линию

            g2.draw(new Line2D.Double(x, baseY, x + bounds.getWidth(), baseY));

            // нарисовать ограничивающий прямоугольник

            Rectangle2D rect = new Rectangle2D.Double(x, y, bounds.getWidth(), bounds.getHeight());
            g2.draw(rect);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        }
    }
}
