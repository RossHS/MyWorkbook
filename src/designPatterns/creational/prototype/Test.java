package designPatterns.creational.prototype;

/**
 * Назначение
 * Задает виды создаваемых объектов с помощью экземплярапрототипа и создает
 * новые объекты путем копирования этого прототипа.
 * <p>
 * Применимость
 * Используйте паттерн прототип, когда система не должна зависеть от того, как
 * в ней создаются, компонуются и представляются продукты:
 * ❑ инстанцируемые классы определяются во время выполнения, например
 * с помощью динамической загрузки;
 * ❑ для того чтобы избежать построения иерархий классов или фабрик, парал
 * лельных иерархии классов продуктов;
 * ❑ экземпляры класса могут находиться в одном из не очень большого числа
 * различных состояний. Может оказаться удобнее установить соответствую
 * щее число прототипов и клонировать их, а не инстанцировать каждый раз
 * класс вручную в подходящем состоянии.
 *
 * @author Ross Khapilov
 * @version 1.0 22.06.2019
 */
public class Test {
    public static void main(String[] args) {
        AccessControl userAccessControl = AccessControlProvider.getAccessControlObject("USER");
        User user = new User("User A", "USER level", userAccessControl);
        System.out.println("********************");
        System.out.println(user);

        userAccessControl = AccessControlProvider.getAccessControlObject("USER");
        user = new User("User B", "USER Level", userAccessControl);
        System.out.println("Changing access control of: " + user.getUserName());
        user.getAccessControl().setAccess("READ REPORTS");
        System.out.println(user);
        System.out.println("************************************");

        AccessControl managerAccessControl = AccessControlProvider.getAccessControlObject("MANAGER");
        user = new User("User C", "MANAGER Level", managerAccessControl);
        System.out.println(user);

        /*
        все хуйня, проше пользоваться готовым методом clone() (который является реализацией данного паттерна), а не городить такие костыли
         */
        Persona p1 = new Persona("Tony", 50);
        Persona p2 = p1.clone();

        p1.setAge(31);
        System.out.println(p1);
        System.out.println(p2);
    }
}

class Persona implements Cloneable {
    private String name;
    private int age;

    public Persona(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public Persona clone() {
        try {
            return (Persona) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}