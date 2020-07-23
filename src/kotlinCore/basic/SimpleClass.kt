package kotlinCore.basic

import kotlin.random.Random

/**
 * @author Ross Khapilov
 * @version 1.0 11.07.2020
 */
/* Java */
//public class Person {
//    private final String name ;
//    public Person(String name) {
//        this.name = name;
//    }
//    public String getName () {
//        return name;
//    }
//}

//тоже самое, но на котлине. Это подходит, только лишь для классов-значений,
// т.е. у которые только сохраняют данные
//нет необходимости указывать модификатор доступа public, тк он принят по умолчанию
class SimpleClass(val name: String, var age: Int)

class Rectangle(val height: Int, val width: Int) {
    //собственный метод доступа
    val isSquare: Boolean
        get() {
            return height == width
        }
}

fun createRandRectangle(): Rectangle {
    return Rectangle(Random.nextInt(0, 10), Random.nextInt(0, 10))
}

fun main() {
    val sc = SimpleClass("Peter", 29)
    sc.age = 30
    println("${sc.name} is ${sc.age} age")

    val rec = Rectangle(12, 12);
    println("${rec.isSquare}")

    val recta = createRandRectangle()
    println("w = ${recta.width} h = ${recta.height}")
}
