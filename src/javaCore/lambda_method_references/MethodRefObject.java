package javaCore.lambda_method_references;

/**
 * Пример ссылки на метод экземпляра класса
 *
 * @author Ross Khapilov
 * @version 1.0 created on 09.01.2018
 */
public class MethodRefObject {
    String strReverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}

class ObjDemo {
    static String strinOp(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Java";
        MethodRefObject str = new MethodRefObject();
        String outStr = strinOp(str::strReverse, inStr);

        System.out.println(inStr);
        System.out.println(outStr);
    }
}

@FunctionalInterface
interface StringFunc {
    String func(String n);
}
