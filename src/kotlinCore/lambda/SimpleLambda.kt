package kotlinCore.lambda

import javax.swing.JButton

/**
 * Лямбда-выражения - это небольшие фрагменты кода, которые можно передавать другим функциям.
 * @author Ross Khapilov
 * @version 1.0 18.07.2020
 */

fun main() {
    val button = JButton()
    //Самый простой вариант лямбда выражения
    button.addActionListener { e -> println("CLICK") }

    val list = arrayListOf(6, 2, 3, 4)
    println(list)
    list.sortBy { e -> -e }
    println(list)
}