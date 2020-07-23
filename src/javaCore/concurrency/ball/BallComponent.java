package javaCore.concurrency.ball;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * КОмпонентн рисующий скачущий мяч
 *
 * @author Ross Khapilov
 * @version 1.0 created on 18.07.2018
 */
public class BallComponent extends JPanel {
    private static int DEFAULT_WIDTH = 450;
    private static int DEFAULT_HEIGHT = 350;

    private List<Ball> balls = new ArrayList<>();

    /**
     * Вводит мяч в компонент
     *
     * @param b Вводимый мяч
     */
    public void add(Ball b) {
        balls.add(b);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //очистить фон
        Graphics2D g2 = (Graphics2D) g;
        for (Ball b : balls)
            g2.fill(b.getShape());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
