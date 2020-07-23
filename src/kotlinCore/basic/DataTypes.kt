package kotlinCore.basic

/**
 * @author Ross Khapilov
 * @version 1.0 11.07.2020
 */

//Варианты объявления переменных
val question = "string"
val answer = 42

//при желании можно указать тип переменной
val ans: Double = 30.0

fun m() {
    //если при объявлении нет инициализации,
    //то тип следует указать явно
    val a: Byte
}

//val = final переменной из java
//var обычная переменная, хоть ссылку и можно переприсвоить, но тип ОБЯЗАН сопадать

var number = 32