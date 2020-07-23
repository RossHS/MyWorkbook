package kotlinCore.classAndInterfaces

/**
 * ключевое слово by помогает реализовать делегирование, таким образом избавляя от шаблонного кода
 * @author Ross Khapilov
 * @version 1.0 13.07.2020
 */

//делегирование
class CountingSet<T>(
        val innerSet: MutableCollection<T> = HashSet<T>()
) : MutableCollection<T> by innerSet {
    var objectAdded = 0

    override fun add(element: T): Boolean {
        objectAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectAdded += elements.size
        return innerSet.addAll(elements)
    }
}

fun main() {
    val countingCollection = CountingSet<Int>();
    countingCollection.add(12)
    countingCollection.addAll(listOf(1,1,3))
    println("object - ${countingCollection.objectAdded}; ${countingCollection.size}")
}