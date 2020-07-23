package designPatterns.structural.flyweight;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ross Khapilov
 * @version 1.0 26.06.2019
 */
public class TreeFactory {
    static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, Color color, String otherTreeData) {
        TreeType result = treeTypes.get(name);
        if (result == null) {
            result = new TreeType(name, color, otherTreeData);
            treeTypes.put(name, result);
        }
        return result;
    }
}
