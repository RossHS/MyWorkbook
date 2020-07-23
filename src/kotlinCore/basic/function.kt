package kotlinCore.basic

/**
 * Основные способы создания функций (как я понял, такой способ является аналогом статических методов из Java)
 * @author Ross Khapilov
 * @version 1.0 11.07.2020
 */

fun main() {
    println(max(10.0, 12.1))
}

fun max(a: Long, b: Long): Long {
    return if (a > b) a else b
}

fun max(a: Int, b: Int): Int = if (a > b) a else b

fun max(a: Double, b: Double) = if (a > b) a else b