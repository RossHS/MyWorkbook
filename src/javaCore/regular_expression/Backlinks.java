package javaCore.regular_expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Круглые скобки помимо логического отделения выражений играют ещё одну роль, а именно создают т.н. группы.
 * Они полезны когда Ваше регулярное выражение состоит из нескольких одинаковых частей. Тогда достаточно описать
 * один раз однотипную часть шаблона, а потом ссылаться на неё.
 * @author Ross Khapilov
 * @version 1.0 created on 26.12.2017
 */
public class Backlinks {
    public static void main(String[] args){
        Pattern p = Pattern.compile("(якороль).+(\\1)");
        Matcher m = p.matcher("регулярные выражения это круто регулярные выражения это круто регулярные " +
                "выражения это круто якороль Я СЕГОДНЯ ЕЛ БАНАНЫ якороль регулярные выражения якороль это круто" );
        if(m.find()){
            System.out.println(m.group());
        }
    }
}
