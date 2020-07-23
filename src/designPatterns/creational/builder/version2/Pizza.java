package designPatterns.creational.builder.version2;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * Пример иерархии со "строителем"
 *
 * @author Ross Khapilov
 * @version 1.0 01.08.2019
 */
public class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        //Подклассы должны переопределять этот метод, возвращая "себя"
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}
