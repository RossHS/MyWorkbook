package kotlinCore.classAndInterfaces

import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JButton

/** ключевое слово object объявляет класс и сразу создает его объект
 * @author Ross Khapilov
 * @version 1.0 13.07.2020
 */
//Синглтон
object Payroll {
    val allEmployees = arrayListOf<Pair<Int, String>>()

    fun calculateSalary() {
        for (person in allEmployees) {
        }
    }
}

//объекты-компаньоны аналог статических членов и методов из Java. В общем, их не рекомендуется использовать
//но если необходим доступ к private полям или методам, то можно ими и воспользоваться
class A {
    companion object {
        fun bar() {
            println("Companion obj called")
        }
    }
}

//использование объекта компаньона для реализации фабричного метода

class UserB private constructor(val nick: String) {
    companion object {
        fun newSubscr(email: String) = UserB(email.substringBefore('@'))
        fun newFaceBookUser(accountId: Int) = UserB(Int.toString())
    }
}

//также объекты компаньоны могут реализовать интерфейсы
interface Factory<T> {
    fun create(text: String): T
}

class Per(val str: String) {
    companion object : Factory<Per> {
        override fun create(text: String): Per = Per(text) //примитивный фабричный метод
    }
}

//анонимные внутренние классы. В отличии от java может реализовать несколько интерфейсов
fun main() {
    val mouseAdapter = object : MouseAdapter(), ActionListener {
        override fun mouseReleased(e: MouseEvent?) {}

        override fun mouseMoved(e: MouseEvent?) {}

        override fun actionPerformed(e: ActionEvent?) {}
    }

    val button = JButton()
    button.addActionListener(object : ActionListener {
        override fun actionPerformed(e: ActionEvent?) {}
    })
}