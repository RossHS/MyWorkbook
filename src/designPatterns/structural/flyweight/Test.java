package designPatterns.structural.flyweight;

import java.awt.*;

/**
 * Легковес — это структурный паттерн проектирования, который позволяет вместить бóльшее количество объектов
 * в отведённую оперативную память. Легковес экономит память, разделяя
 * общее состояние объектов между собой, вместо хранения одинаковых
 * данных в каждом объекте.
 * <p>
 * когда не хватает оперативной памяти для поддержки всех нужных объектов.
 * <p>
 * Эффективность паттерна Легковес во многом зависит от того, как и где он используется.
 * Применяйте этот паттерн, когда выполнены все перечисленные условия:
 * <p>
 * в приложении используется большое число объектов;
 * из-за этого высоки расходы оперативной памяти;
 * большую часть состояния объектов можно вынести за пределы их классов;
 * большие группы объектов можно заменить относительно небольшим количеством разделяемых
 * объектов, поскольку внешнее состояние вынесено.
 *
 * @author Ross Khapilov
 * @version 1.0 26.06.2019
 */
public class Test {
    //мое мнение, что паттерн не очень эффективен (от него больше проблем, чем пользы)
    static int CANVAS_SIZE = 500;
    static int TREES_TO_DRAW = 1000000;
    static int TREE_TYPES = 2;

    public static void main(String[] args) {
        Forest forest = new Forest();
        for (int i = 0; i < Math.floor(TREES_TO_DRAW / TREE_TYPES); i++) {
            forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
                    "Summer Oak", Color.GREEN, "Oak texture stub");
            forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
                    "Autumn Oak", Color.ORANGE, "Autumn Oak texture stub");
        }
        forest.setSize(CANVAS_SIZE, CANVAS_SIZE);
        forest.setVisible(true);

        System.out.println(TREES_TO_DRAW + " trees drawn");
        System.out.println("---------------------");
        System.out.println("Memory usage:");
        System.out.println("Tree size (8 bytes) * " + TREES_TO_DRAW);
        System.out.println("+ TreeTypes size (~30 bytes) * " + TREE_TYPES + "");
        System.out.println("---------------------");
        System.out.println("Total: " + ((TREES_TO_DRAW * 8 + TREE_TYPES * 30) / 1024 / 1024) +
                "MB (instead of " + ((TREES_TO_DRAW * 38) / 1024 / 1024) + "MB)");
    }

    private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

}
