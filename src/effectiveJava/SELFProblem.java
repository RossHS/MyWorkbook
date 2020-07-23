package effectiveJava;

/**
 * Пример SELF проблемы, о которой пишет Джошуа Блох. Один из немногих недостатков композиции перед наследованием.
 * Проблема заключается в том, что при использовании композиции wrapped объект не знает о своей оболочке и передаст
 * ссылку на самого себя, тем самым проигнорировав обратный вызов оболочки
 *
 * @author Ross Khapilov
 * @version 1.0 15.07.2020
 */

/**
 * Интерфейс обратного вызова
 */
interface Callback {
    void doSomething();

    void call();
}

/**
 * Главный класс реализующий данный интерфейс
 */
class TopLevelClass implements Callback {

    private final Service service;

    public TopLevelClass(Service service) {
        this.service = service;
    }

    @Override
    public void doSomething() {
        service.action(this);
    }

    @Override
    public void call() {
        System.out.println("TopLevelClass - Call");
    }
}

/**
 * оболочка которая делегирует выполнение классу TopLevelClass. В данном случае не будет вызван метод call.
 * Так как по ссылке this будет вызван метод call из класса TopLevelClass.
 */
class Wrapper implements Callback {
    private final TopLevelClass topLevelClass;

    public Wrapper(TopLevelClass topLevelClass) {
        this.topLevelClass = topLevelClass;
    }

    @Override
    public void doSomething() {
        topLevelClass.doSomething();
    }

    @Override
    public void call() {
        System.out.println("Wrapper - Call");
    }
}

/**
 * При наследовании таких проблем не будет и при динамическом связывании произойдет вызов переопределенной версии метода call()
 */
class SubClass extends TopLevelClass {
    public SubClass(Service service) {
        super(service);
    }

    @Override
    public void call() {
        System.out.println("SubClass - Call");
    }
}

class Service {
    public void action(Callback callback) {
        new Thread(() -> {
            System.out.println("Start service");
            callback.call();
        }).start();
    }
}

public class SELFProblem {
    public static void main(String[] args) {
        Service service = new Service();
        //"оборачиваем" TopLevelClass в обертку и делегируем вызов метода doSomething()
        Wrapper wrapper = new Wrapper(new TopLevelClass(service));
        wrapper.doSomething();

        //Используем наследование для решения такой же задачи
        SubClass subClass = new SubClass(service);
        subClass.doSomething();
    }
}

