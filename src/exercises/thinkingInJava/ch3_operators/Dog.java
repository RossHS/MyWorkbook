package thinkingInJava.ch3_operators;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 19.12.2017
 */
public class Dog {
    private final String name;
    private final String says;

    Dog(String name, String says) {
        this.name = name;
        this.says = says;
    }

    public String getName() {
        return name;
    }

    public String getSays() {
        return says;
    }

    @Override
    public String toString() {
        return super.toString() + " Имя собаки " + name + "\nОна говорит " + says + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Dog dog = (Dog) obj;
        return name.equals(dog.name) && says.equals(dog.says);
    }
}

class DogTest {
    public static void main(String[] args) {
        Dog dog1 = new Dog("spot", "HOO");
        Dog dog2 = new Dog("scruffy", "boo-boo");
        Dog dog3 = new Dog("scruffy", "boo-boo");
        System.out.println(dog1);
        System.out.println(dog2);

        System.out.println(dog2.equals(dog3));
    }
}
