package javaCore.regular_expression;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class Pattern - Регулярное выражение, которое Вы записываете в строке, должно сначала быть скомпилированным
 * в объект данного класса. После компиляции объект этого класса может быть использован для создания объекта Matcher.
 * <p>
 * В классе Pattern объявлены следующие методы:
 * <p>
 * Pattern compile(String regex) – возвращает Pattern, который соответствует regex.
 * <p>
 * Matcher matcher(CharSequence input) – возвращает Matcher,
 * с помощью которого можно находить соответствия в строке input.
 *
 * @author Ross Khapilov
 * @version 1.0 created on 26.12.2017
 */
public class PatternTest {
    public static void main(String[] args) {
        //статические методы
        Pattern pattern = Pattern.compile("[Тт].+"); //создает объект "регулярного выражения"
        //выделяет строку как конечный литерал
        System.out.println("foo".matches(".*")); //тру так на подходят вообще все символы
        System.out.println("foo".matches(Pattern.quote(".*"))); //false, так как нам нужна именно такая комбинация
        //для быстрой проверки регулярного выражения в строке
        Boolean matches = Pattern.matches("^#?([a-f0-9]{6}|[a-f0-9]{3})$", "#8b2323");

        //создает объект матчер со строкой для анализа
        Matcher matcher = pattern.matcher("123");
        //возвращает регулярное выражение как строку
        System.out.println(pattern.pattern());
    }
}
