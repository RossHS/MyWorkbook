package javaCore.lambda_method_references;

import java.util.function.IntUnaryOperator;

/**
 * Одно из важных ограничений лямбда выражений, что в них нельзя менять состояние локальных нефинальных переменных
 * объявленных за границами лямбда-выражения. Так образом область действия переменных в лямбда выражениях схожа
 * с анонимными внутренними классами.
 *
 * @author Ross Khapilov
 * @version 1.0 created on 09.01.2018
 */
public class RangeOfVariablesLambda {
    static int statInt = 10;
    int objInt = 15;

    public static void main(String[] args) {
        int num = 10;

        StringBuilder strB = new StringBuilder();
        strB.append("abc");

        RangeOfVariablesLambda outLambda = new RangeOfVariablesLambda();
        outLambda.objInt = 20;

        IntUnaryOperator intUnaryOperator = n -> {
            //      num++; //не работает так как мы присваиваем локальной переменной другое значение
            int numLambda = num; //исходная ссылка не меняется, так что будет работать, но теперь переменную num нельзя изменить
            numLambda++;

            strB.append("d"); //сработает, т.к. объект изменяемый (mutable)

            statInt++; //для статического поля все работает

            RangeOfVariablesLambda inLambda = new RangeOfVariablesLambda();
            inLambda.objInt++;

            outLambda.objInt++;//так же работает для объектов объявленных как в лямбда выражении, так и в не его

            return ++n;
        };
        //num++; появится ошибка в лямбда выражении
        System.out.println(intUnaryOperator.applyAsInt(0));

    }
}
