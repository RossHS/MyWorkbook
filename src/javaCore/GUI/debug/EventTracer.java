package javaCore.GUI.debug;

import java.awt.*;
import java.beans.BeanInfo;
import java.beans.EventSetDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Если требуется получить запись о каждом событии AWT, инициируемом в ГПИ вашей прикладной программы, установите в
 * каждом компоненте приемник этих событий. Эту процедуру нетрудно автоматизировать с помощью механизма рефлексии.
 * В качестве примера приведен исходный код класса EventTracer, отслеживающего события. Для отслеживания событий в
 * проверяемом компоненте введите в него объект класса EventTracer следующим образом:
 * EventTracer tracer = new EventTracer();
 * tracer.add(frame);
 *
 * @author Ross Khapilov
 * @version 1.0 created on 02.05.2018
 */
public class EventTracer {
    private InvocationHandler handler;

    public EventTracer() {
        //обработчик всех событий в виде прокси-объектов
        handler = (proxy, method, args) -> {
            System.out.println(method + ":" + args[0]);
            return null;
        };
    }

    /**
     * Добавляет объект для отслеживания всех событий, которые может принимать данный компонент и производные от него
     * компоненты
     *
     * @param c Компонент
     */
    public void add(Component c) {
        try {
            // получить все события, которые может принимать данный компонент
            BeanInfo info = Introspector.getBeanInfo(c.getClass());

            EventSetDescriptor[] eventSets = info.getEventSetDescriptors();
            for (EventSetDescriptor eventSet : eventSets)
                addListener(c, eventSet);
        } catch (IntrospectionException e) {
            //если генерируется исключение, приемники событий не вводятся
            e.printStackTrace();
        }
        if (c instanceof Container) {
            // получить все производные объекты и организовать рекурсивный вызов метода add()
            for (Component comp : ((Container) c).getComponents())
                add(comp);
        }
    }

    /**
     * Добавляет приемник заданного множества событий
     *
     * @param c        Компонент
     * @param eventSet Описатель интерфейса приемника событий
     */
    public void addListener(Component c, EventSetDescriptor eventSet) {
        // создать прокси-объект для заданного типа приемника событий и направить все вызовы этому обработчику
        Object proxy = Proxy.newProxyInstance(null, new Class[]{eventSet.getListenerType()}, handler);

        // добавляет прокси-объект как приемник событий в компонент
        Method addListenerMethod = eventSet.getAddListenerMethod();
        try {
            addListenerMethod.invoke(c, proxy);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }
}
