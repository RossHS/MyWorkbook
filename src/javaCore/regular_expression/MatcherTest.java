package javaCore.regular_expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Объект Matcher анализирует строку, начиная с 0, и ищет соответствие шаблону.
 * После завершения этого процесса Matcher содержит много информации о найденных (или не найденных) соответствиях в
 * нашей входной строке. Мы можем получить эту информацию, вызывая различные методы нашего объекта Matcher:
 *
 * @author Ross Khapilov
 * @version 1.0 created on 26.12.2017
 */
public class MatcherTest {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[1-9]");
        Matcher matcher = pattern.matcher("abc2a3");

        //основной метод, просто указывает соответствует ли вся входная последовательность шаблону.
        System.out.println(matcher.matches());
        //true, если шаблон совпадает с любой часть текста
        System.out.println(matcher.find());
        //m.lookingAt() возвращает true, если шаблон соответствует началу строки, и false в противном случае.
        System.out.println(matcher.lookingAt());
        //start() вернет индекс первого символа, совпавшего
        // и end() вернет индекс последнего совпавшего символа, плюс один, следует использовать с методом find()
        Pattern pattern1 = Pattern.compile("is");
        Matcher matcher1 = pattern1.matcher("This is the text which is to be searched " +
                "for occurrences of the word 'is'.");
        int count = 0;
        while (matcher1.find()) {
            count++;
            System.out.println("found: " + count + " : "
                    + matcher1.start() + " - " + matcher1.end());
        }

        String pattern2 = "[a-z]+";
        String text = "code 2 learn java tutorial";
        Pattern p = Pattern.compile(pattern2);
        Matcher m = p.matcher(text);
        while (m.find()) {
            System.out.print(text.substring(m.start(), m.end()) + "*");
        }
    }

}
