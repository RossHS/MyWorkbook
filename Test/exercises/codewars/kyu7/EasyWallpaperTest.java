package exercises.codewars.kyu7;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 11.05.2018
 */
class EasyWallpaperTest {
    private EasyWallpaper easyWallpaper = new EasyWallpaper();
    @Test
    public void test1() {

        assertEquals("ten", easyWallpaper.wallpaper(4, 3.5, 3));
    }

    @Test
    public void test2() {
        assertEquals("sixteen", easyWallpaper.wallpaper(6.3, 4.5, 3.29));
    }

    @Test
    public void test3() {
        assertEquals("seventeen", easyWallpaper.wallpaper(6.3, 5.8, 3.13));
    }
}