package javaCore.GUI.basics.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 27.01.2018
 */
public class DrawTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new DrawFrame();
            frame.setTitle("DrawTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * Фрейм, содержащий панель с нарисованными двумерными формами
 */
class DrawFrame extends JFrame {
    public DrawFrame() {
        DrawComponent drawComponent = new DrawComponent();
        drawComponent.setForeground(Color.orange);
        add(drawComponent);
        pack();
    }
}

/**
 * Компонент, отображающий прямоугольники и эллипсы
 */
class DrawComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        //прямоугольник
        double leftX = 100;
        double topY = 100;
        double width = 200;
        double height = 150;
        Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
        g2.draw(rect);

        //вписанный эллипс
        Ellipse2D ellipse = new Ellipse2D.Double();
        ellipse.setFrame(rect);
        g2.draw(ellipse);

        //нарисовать диагональную линию
        g2.draw(new Line2D.Double(leftX, topY, leftX + width, topY + height));

        //окружность с тем же центром
        double centerX = rect.getCenterX();
        double centerY = rect.getCenterY();
        double radius = 150;

        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerX,centerY,centerX+radius,centerY+radius);
        g2.draw(circle);
        g2.setPaint(Color.MAGENTA);
        g2.drawString("WARNING",100,100);
        g2.setPaint(new Color(5,180,200));
        g2.fill(ellipse);
    }

    /**
     * Этот метод переопределяется для возврата предпочтительных размеров данного компонента.
     * @return the value of the <code>preferredSize</code> property
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}