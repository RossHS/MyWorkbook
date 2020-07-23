package kotlinCore.classAndInterfaces

/** ключевое слово data перед class автоматически реализует методы equals(), hashCode(), toString() и copy()
 * @author Ross Khapilov
 * @version 1.0 13.07.2020
 */

data class Man(val name: String, val age: Int)

fun main() {
    val ross = Man("Ross", 12)
    val ross2 = Man("Ross", 12)
    println(ross == ross2) // тут оператор перегружен, на самом деле вызывается equals()
    println(ross === ross2) //классический оператор сравнений ссылок == из java
    println(ross)
    println(ross.copy(age = 30))
}