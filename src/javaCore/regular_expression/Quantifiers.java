package javaCore.regular_expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Регулярные выражения предоставляют инструменты позволяющие указать сколько раз может повторятся один или несколько
 * символов.
 * <p>
 * +     - Одно или более
 * *     - Ноль или более
 * ?     - Ноль или одно
 * {n}   - Ровно n раз
 * {m,n} - От m до n включительно
 * {m,}  - Не менее m
 * {,n}  - Не более n
 *
 * @author Ross Khapilov
 * @version 1.0 created on 26.12.2017
 */
public class Quantifiers {
    //подходят любые маленькие буквы, цифры и подчеркивание.
    //количество повторений от 3 до 15 раз
    public static boolean testQuan(String str){
        Pattern p = Pattern.compile("^[a-z0-9_-]{3,15}$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static void main(String[] args) {
        System.out.println(testQuan("vovan"));
    }
}
