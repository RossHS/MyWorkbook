package javaCore.generics;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 12.04.2018
 */
public class GenericTest {
    public static void main(String[] args) {
        Manager ceo = new Manager("Gus", 36_000, 2003, 12, 15);
        Manager cfo = new Manager("Sid", 41_000, 2003, 12, 15);
        Pair<Manager> managerPair = new Pair<>(ceo, cfo);

        ceo.setBonus(5_000);
        cfo.setBonus(3_000);
        Manager[] managers = {ceo, cfo};

        Pair<Employee> result = new Pair<>();
        minmaxBonus(managers, result);

        System.out.println("first: " + result.getMin().getName() + ", second: " + result.getMax().getName());
        maxminBonus(managers, result);
        System.out.println("first: " + result.getMin().getName() + ", second: " + result.getMax().getName());
    }

    public static void printBuddies(Pair<? extends Employee> p) {
        Employee first = p.getMin();
        Employee second = p.getMax();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies!");

    }

    public static void minmaxBonus(Manager[] managers, Pair<? super Manager> result) {
        if (managers == null || managers.length == 0) return;
        Manager min = managers[0];
        Manager max = managers[0];
        for (int i = 1; i < managers.length; i++) {
            if (min.getSalary() > managers[i].getSalary()) min = managers[i];
            if (max.getSalary() < managers[i].getSalary()) max = managers[i];
        }
        result.setMin(min);
        result.setMax(max);
    }

    public static void maxminBonus(Manager[] managers, Pair<? super Manager> result) {
        minmaxBonus(managers, result);
        PairAlg.swapHelper(result); //в свапхелпере захватывается подстановочный тип
    }

    static class PairAlg {
        public static boolean hasNulls(Pair<?> pair) {
            return pair.getMin() == null || pair.getMax() == null;
        }

        public static void swap(Pair<?> pair) {
            swapHelper(pair);
        }

        public static <T> void swapHelper(Pair<T> pair) {
            T t = pair.getMin();
            pair.setMin(pair.getMax());
            pair.setMax(t);
        }
    }
}

class Manager extends Employee {
    public Manager(String name, int salary, int yearOfEmp, int monthOfEmp, int dayOfEmp) {
        super(name, salary, yearOfEmp, monthOfEmp, dayOfEmp);
    }
}

class Employee {
    private String name;
    private int salary;
    private final int yearOfEmp;
    private final int monthOfEmp;
    private final int dayOfEmp;

    public Employee(String name, int salary, int yearOfEmp, int monthOfEmp, int dayOfEmp) {
        this.name = name;
        this.salary = salary;
        this.yearOfEmp = yearOfEmp;
        this.monthOfEmp = monthOfEmp;
        this.dayOfEmp = dayOfEmp;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void setBonus(int bonus) {
        salary += bonus;
    }
}