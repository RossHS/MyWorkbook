package thinkingInJava.ch1_objects;

/**
 * Проверка инициализации по умолчанию
 *
 * @author Ross Khapilov
 * @version 1.0 created on 18.12.2017
 */
public class Init {
    private int i;
    private char c;

    public static void main(String[] args) {
        Init e = new Init();
        System.out.println(e.i);
        System.out.println(e.c);
    }
}
