package thinkingInJava.ch3_operators;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 19.12.2017
 */
public class Assignment {
    float fl;

    public static void main(String[] args) {
        Assignment obj1 = new Assignment();
        Assignment obj2 = new Assignment();
        obj1.fl = 10f;
        obj2.fl = 13f;
        System.out.println(obj1.fl + " " + obj2.fl);
        //теперь переменные ссылаются на один объект obj2, а obj1 удаляется из кучи сборщиком мусора
        obj1 = obj2;
        System.out.println(obj1.fl + " " + obj2.fl);
        obj1.fl = 16.9f;
        System.out.println(obj1.fl + " " + obj2.fl);
    }
}
