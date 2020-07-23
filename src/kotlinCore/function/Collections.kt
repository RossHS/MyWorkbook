package kotlinCore.function

import java.util.*

/** Все коллекции Kotlin те же, что и в Java.
 * @author Ross Khapilov
 * @version 1.0 12.07.2020
 */

//создание коллекции
fun createCollection() {
    //создание множества
    val hashSet = hashSetOf(1, 23, 1, 6, -4) //самый оптимальный вариант, сортировки нет
    val treeSet = sortedSetOf(1, -3, 4) // есть сортировка
    val linkedSet = linkedSetOf(1, -3, 4) //сохраняется последовательность элементов
    println("HashSet $hashSet; TreeSet $treeSet; LinkedSet $linkedSet")

    val arrayList = arrayListOf(3, 5)
    val linkedList: LinkedList<Int> = LinkedList()
    linkedList.add(123)
    println(arrayList.javaClass)

    //to это инфиксная форма вызова функции с одним параметром. Т.е. 1 to "one" тоже самое, что 1.to("one")
    val hashMap = hashMapOf(1 to "one", 2.to("two"), Pair(3, "three"))
    println(hashMap)

    println(joinToString(hashSet, ", ", "(", ")"))
    println(joinToString(arrayList, separator = " ", prefix = " ", postfix = " "))

    //используем функцию со значением по умолчанию
    println(joinToString(hashSet, ": "))
    //чтобы опустить част параметров (те, что не по порядку) явно указываем используемый параметр
    println(joinToString(hashSet, prefix = "{", postfix = "}"))
}

fun main() {
    createCollection()
}