package kotlinCore.basic;

import java.util.Collections;

/**
 * @author Ross Khapilov
 * @version 1.0 11.07.2020
 */
public enum EnumJ {
    GREEN(0, 255, 0),
    RED(255, 0, 0),
    BLUE(0, 0, 255),
    BLACK(0, 0, 0);

    private final int red;
    private final int green;
    private final int blue;

    EnumJ(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public int rgb() {
        return (red * 256 + green) * 256 + blue;
    }
}