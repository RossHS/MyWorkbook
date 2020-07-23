package designPatterns.structural.flyweight;

import java.awt.*;

/**
 * @author Ross Khapilov
 * @version 1.0 26.06.2019
 */
public class Tree {
    private int x;
    private int y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw(Graphics g) {
        type.draw(g, x, y);
    }
}
