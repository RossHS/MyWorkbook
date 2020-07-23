package kotlinCore.classAndInterfaces

import javax.naming.Context

/**
 * @author Ross Khapilov
 * @version 1.0 13.07.2020
 */
class User(val nickName: String) //Указан основной конструктор

//основной конструктор со значение по умолчанию
class ExpertUser(val nickname: String,
                 val isSubscriber: Boolean = true)

//Вторичный конструктор
open class View{
    constructor(ctx: Context) {}
    constructor(ctx: Context, attr: ArrayList<Int>) {}
}

class MyButton : View {
    constructor(ctx: Context) : this(ctx, arrayListOf(1, 2)) {}
    constructor(ctx: Context, attr: ArrayList<Int>) : super(ctx, attr) {}
}

fun main() {
    val ex = ExpertUser("Name")
    println(ex.isSubscriber)
    val ex2 = ExpertUser("User", false)
    println(ex2.isSubscriber)
}