package kotlinCore.classAndInterfaces;

/**
 * Пример SELF проблемы, о которой пишет Джошуа Блох. Один из немногих недостатков композиции перед наследованием.
 * Проблема заключается в том, что при использовании композиции wrapped объект не знает о своей оболочке и передаст
 * ссылку на самого себя, тем самым проигнорировав обратный вызов оболочки
 *
 * @author Ross Khapilov
 * @version 1.0 15.07.2020
 */
interface SomethingWithCallback {

    void doSomething();

    void call();

}


class WrappedObject implements SomethingWithCallback {

    private final SomeService service;

    WrappedObject(SomeService service) {
        this.service = service;
    }

    @Override
    public void doSomething() {
        service.performAsync(this);
    }

    @Override
    public void call() {
        System.out.println("WrappedObject callback!");
    }
}


class Wrapper implements SomethingWithCallback {

    private final WrappedObject wrappedObject;

    Wrapper(WrappedObject wrappedObject) {
        this.wrappedObject = wrappedObject;
    }

    @Override
    public void doSomething() {
        wrappedObject.doSomething();
    }

    void doSomethingElse() {
        System.out.println("We can do everything the wrapped object can, and more!");
    }

    @Override
    public void call() {
        System.out.println("Wrapper callback!");
    }
}

class SubClass extends WrappedObject {

    SubClass(SomeService service) {
        super(service);
    }

    @Override
    public void doSomething() {
        super.doSomething();
    }

    @Override
    public void call() {
        System.out.println("SubClass callback!");
    }
}

final class SomeService {

    void performAsync(SomethingWithCallback callback) {
        new Thread(() -> {
            perform();
            callback.call();
        }).start();
    }

    void perform() {
        System.out.println("Service is being performed.");
    }
}

class T {
    public static void main(String[] args) {
        SomeService service = new SomeService();
        WrappedObject wrappedObject = new WrappedObject(service);
        Wrapper wrapper = new Wrapper(wrappedObject);
        wrapper.doSomething();

        SomeService someService = new SomeService();
        SubClass subClass = new SubClass(someService);
        subClass.doSomething();
    }
}