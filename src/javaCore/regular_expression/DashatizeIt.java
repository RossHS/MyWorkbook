package javaCore.regular_expression;

/**
 * Given a number, return a string with dash'-'marks before and after each odd integer, but do not begin or end the string with a dash mark.
 * <p>
 * Ex:
 * <p>
 * dashatize(274) -> '2-7-4'
 * dashatize(6815) -> '68-1-5'
 *
 * @author Ross Khapilov
 * @version 1.0 created on 19.04.2018
 */
public class DashatizeIt {
    public static String dashatize(int num) {
        return String.valueOf(num)
                .replaceAll("([13579])", "-$1-") //к нечетным числам добавляем -(само число)-
                .replaceAll("--", "-") //если идут две подряд --, заменяем одной -
                .replaceAll("(^-|-$)", ""); //если строка начинается ИЛИ заканчивается - -, то убираем
    }

    public static void main(String[] args) {
        System.out.println(dashatize(974302));
    }
}
