package kotlinCore.basic

import java.io.BufferedReader

/**
 * В Kotlin и Java схожий механизм работы с исключениями, за тем лишь исключением,
 * что нет разделения на checked и unchecked exception
 * @author Ross Khapilov
 * @version 1.0 12.07.2020
 */

//Пример простейшего исключения
fun checkPercentage(percentage: Int) =
        if (percentage in 0..100) percentage
        else throw IllegalArgumentException("must be between 0 and 100: $percentage")

fun readNumber(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        return null
    } finally {
        reader.close()
    }
}

//Так же в котлин try можно использовать как выражение
fun readNumber2(reader: BufferedReader) {
    val num = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        return
    }
    println(num)
}