package javaCore.regular_expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Регулярные выражения (англ. regular expressions) — формальный язык поиска и осуществления манипуляций с подстроками
 * в тексте, основанный на использовании метасимволов (символов-джокеров, англ. wildcard characters). По сути это
 * строка-образец (англ. pattern, по-русски её часто называют «шаблоном», «маской»), состоящая из символов и
 * метасимволов и задающая правило поиска.
 * Пакет для работы с регулярными выражениями java.util.regex содержит два класса Matcher и Pattern
 * <p>
 * Основой синтаксиса регулярных выражений является тот факт, что некоторые символы встречающиеся в строке
 * рассматриваются не как обычные символы, а как имеющие специальное значение (т.н. метасимволы).
 * Именно это решение позволяет работать всему механизму регулярных выражений. Каждый метасимвол имеет
 * свою собственную роль.
 * <p>
 * Вот примеры основных метасимволов:
 * ^     - (крышка, цирркумфлекс) начало проверяемой строки
 * $     - (доллар) конец проверяемой строки
 * .     - (точка) представляет собой сокращенную форму записи для символьного класса, совпадающего с любым символом
 * |     -  означает «или». Подвыражения, объединенные этим способом, называются альтернативами (alternatives)
 * ?     - (знак вопроса) означает, что предшествующий ему символ является необязательным
 * +     -  обозначает «один или несколько экземпляров непосредственно предшествующего элемента
 * *     –  любое количество экземпляров элемента (в том числе и нулевое)
 * \\d   –  цифровой символ
 * \\D   –  не цифровой символ
 * \\s   –  пробельный символ
 * \\S   –  не пробельный символ
 * \\w   –  буквенный или цифровой символ или знак подчёркивания
 * \\W   –  любой символ, кроме буквенного или цифрового символа или знака подчёркивания
 *
 * @author Ross Khapilov
 * @version 1.0 created on 26.12.2017
 */
public class RegEx {
    public static boolean test1(String testString) {
        Pattern p = Pattern.compile("^Bac\\wn$");
        Matcher m = p.matcher(testString);
        return m.matches();
    }

    public static boolean test2(String testString) {
        // .+ означает что может идти любое количество символов
        //\\. визуализация точки
        //(com|ua|ru) либо com/ua/ru
        Pattern p = Pattern.compile(".+\\.(com|ua|ru)");
        Matcher m = p.matcher(testString);
        return m.matches();
    }

    //[;:] означает, что нам подойдет любой одиночный символ из этого перечня
    //(;|:) тоже подойдет, но для более длинных выражений он не удобен
    public static boolean test3(String testString) {
        Pattern p = Pattern.compile("[;:][-~]?[)D]");
        Matcher m = p.matcher(testString);
        return m.matches();
    }

    public static String test4(String testString) {
        return testString.replaceAll("[Рр]о(сс|с)ия", "Россия");
    }

    //не A B C
    public static boolean test5(String testString) {
        Pattern p = Pattern.compile("[^ABC]");
        Matcher m = p.matcher(testString);
        return m.matches();
    }

    //все слова с заглавными буквами
    public static boolean test6(String testString) {
        Pattern p = Pattern.compile("[A-Z]+");
        Matcher m = p.matcher(testString);
        return m.matches();
    }

    public static void main(String[] args) {
        System.out.println(test1("Bacon"));
        System.out.println(test2(".ru") + " " + test2("abc abc.com"));
        System.out.println(test3(";-D"));
        System.out.println(test4("росия - хорошая страна. россия"));
        System.out.println(test5("A"));
        System.out.println(test6("DEEP"));
    }
}
