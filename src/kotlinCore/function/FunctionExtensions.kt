package kotlinCore.function

/**
 * Одна из главных особенностей Kotlin - простота интеграции с уже существующим кодом.
 * Этого можно добиться используя "расширения"
 * @author Ross Khapilov
 * @version 1.0 13.07.2020
 */
//Если хотим добавить новый метод в стринг
fun String.lastChar(): Char = get(length - 1)

//Свойства расширения
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value) = setCharAt(length - 1, value)


//переделаем функцию joinToString из предыдущего примера в функцию расширение
fun <T> Collection<T>.joinToString(
        separator: String = ", ",
        prefix: String = " ",
        postfix: String = " "
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun main() {
    val arrays = arrayOf(1, 2, 4)
    arrays.max()
}