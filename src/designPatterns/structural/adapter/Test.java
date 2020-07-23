package designPatterns.structural.adapter;

import java.util.EnumSet;

/**
 * Адаптер — это структурный паттерн проектирования, который позволяет объектам с несовместимыми интерфейсами работать вместе.
 * Назначение
 * Преобразует интерфейс одного класса в интерфейс другого, который ожидают клиенты.
 * Адаптер обеспечивает совместную работу классов с несовместимыми интерфейсами, которая без него была бы невозможна.
 * <p>
 * Применимость
 * Применяйте паттерн адаптер, когда:
 * ❑ хотите использовать существующий класс, но его интерфейс не соответству
 * ет вашим потребностям;
 * ❑ собираетесь создать повторно используемый класс, который должен взаимо
 * действовать с заранее неизвестными или не связанными с ним классами,
 * имеющими несовместимые интерфейсы;
 * ❑ (только для адаптера объектов!) нужно использовать несколько существу
 * ющих подклассов, но непрактично адаптировать их интерфейсы путем по
 * рождения новых подклассов от каждого. В этом случае адаптер объектов
 * может приспосабливать интерфейс их общего родительского класса.
 *
 * @author Ross Khapilov
 * @version 1.0 22.06.2019
 */
public class Test {

    public static void main(String[] args) {
        Xpay xpay = new XpayImp();
        xpay.setCreditCardNo("4789565874102365");
        xpay.setCustomerName("Max Warner");
        xpay.setCardExpMonth("09");
        xpay.setCardExpYear("25");
        xpay.setCardCVVNo((short) 235);
        xpay.setAmount(2565.23);

        PayD payD = new XpayToPayDAdapter(xpay);
        testPayD(payD);
    }

    private static void testPayD(PayD payD) {
        System.out.println(payD.getCardOwnerName());
        System.out.println(payD.getCustCardNo());
        System.out.println(payD.getCardExpMonthDate());
        System.out.println(payD.getCVVNo());
        System.out.println(payD.getTotalAmount());
    }
}
