package kotlinCore.basic

import java.util.*

/**
 * @author Ross Khapilov
 * @version 1.0 12.07.2020
 */
fun main() {
    for (i in 1..100)
        print(fizzBuzz(i))
    println("\n")
    for (i in 100 downTo 1 step 2)
        print(fizzBuzz(i))

    println()
    val binaryReps = TreeMap<Char, String>()
    for (i in 'A'..'D') {
        binaryReps[i] = Integer.toBinaryString(i.toInt())
    }
    println(binaryReps)
    for ((chars, binary) in binaryReps) {
        println("$chars = $binary")
    }
    
    for (i in 0..100) {
        println(i)
    }

    val array = arrayListOf("1", "10", "11")
    for ((i, value) in array.withIndex())
        println("$i : $value")
}

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'
fun recog(c: Char) = when (c) {
    in '0'..'9' -> "Digit"
    in 'a'..'z', in 'A'..'Z' -> "Letter"
    else -> "AUF"
}