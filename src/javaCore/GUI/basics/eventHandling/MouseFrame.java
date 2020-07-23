package javaCore.GUI.basics.eventHandling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Фрейм, содержащий панель для проверки операций, выполняемых мышью
 *
 * @author Ross Khapilov
 * @version 1.0 created on 05.02.2018
 */
public class MouseFrame extends JFrame {
    public MouseFrame() {
        add(new MouseComponent());
        pack();
    }
}


/**
 * Компонент для операций с мышью по добавлению и удалению квадратов
 */
class MouseComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 400;

    private static final int SIDELENGTH = 40; //длина сторон квадратов
    private ArrayList<Rectangle2D> squares; //Коллекция содержащая квадраты
    private Rectangle2D current; //квадрат содержащий курсор мыши

    public MouseComponent() {
        squares = new ArrayList<>();
        current = null;
        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        //Нарисовать квадраты
        for (Rectangle2D r : squares)
            g2.draw(r);
    }

    /**
     * Обнаруживает первый квадрат, содержащий заданную точку
     *
     * @param p Точка
     * @return Первый квадрат содержащий точку p
     */
    public Rectangle2D find(Point2D p) {
        for (Rectangle2D r : squares) {
            if (r.contains(p)) return r;
        }
        return null;
    }

    /**
     * Вводит квадрат в коллекцию
     *
     * @param p Центр квадрата
     */
    public void add(Point2D p) {
        double x = p.getX();
        double y = p.getY();

        current = new Rectangle2D.Double(x - SIDELENGTH / 2, y - SIDELENGTH / 2,
                SIDELENGTH, SIDELENGTH);
        squares.add(current);
        repaint();
    }

    /**
     * Удаляет квадрат из коллекции
     *
     * @param s Удаляемый квадрат
     */
    public void remove(Rectangle2D s) {
        if (s == null) return;
        if (s == current) current = null;
        squares.remove(s);
        repaint();
    }

    private class MouseHandler extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            //добавляет новый квадрат, если курсор
            //находится за пределами квадрата
            current = find(e.getPoint()); //выполняем поиск
            if (current == null) add(e.getPoint()); //если в это точки пусто, добавляем новый квадрат в эту точку
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            //Удалить квадрат, если по нему два раза кликнули
            current = find(e.getPoint());
            if (current != null && e.getClickCount() >= 2)
                remove(current);
        }
    }

    private class MouseMotionHandler implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {
            if (current != null) {
                int x = e.getX();
                int y = e.getY();
                //перетащить текущий квадрат, чтобы отцентрировать его в точке с координатами (x,y)
                current.setFrame(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
                repaint();
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            //задать курсор в виде перекрестья, если он находится внутри квадрата
            if (find(e.getPoint()) == null)
                setCursor(Cursor.getDefaultCursor());
            else setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }
    }

}

class MouseTestDrive {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MouseFrame frame = new MouseFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}