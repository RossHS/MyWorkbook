package thinkingInJava.ch1_objects;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 18.12.2017
 */
public class StaticDoesntDependOn {
    static int sum = 0;
    private int b;
    private int a;

    private StaticDoesntDependOn(int a) {
        this.a = a;
    }

    private void showStatic(StaticDoesntDependOn s){
        sum += a + s.a;
        b += a + s.a;
    }



    public static void main(String[] args) {
        StaticDoesntDependOn s1 = new StaticDoesntDependOn(12);
        StaticDoesntDependOn s2 = new StaticDoesntDependOn(2);
        StaticDoesntDependOn s3 = new StaticDoesntDependOn(10);
        System.out.println(sum);
        s1.showStatic(s2);
        s2.showStatic(s3);
        //так как сум статична, т.е. ее состояние не зависит от объекта
        //мы получим одно и тоже значение, в отличии от переменной б, которая зависит от объекта
        System.out.println("sum :" + sum);
        System.out.println("b для s1 :" + s1.b);
        System.out.println("b для s2 :" + s2.b);
    }
}
