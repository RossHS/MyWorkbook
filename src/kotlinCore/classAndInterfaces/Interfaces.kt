package kotlinCore.classAndInterfaces

/**
 * @author Ross Khapilov
 * @version 1.0 13.07.2020
 */

interface Clickable {
    fun click()

    //также как и в java можно определить дефолтную реализацию функции
    fun showOff() = println("I am clicked")
}

interface Focusable {
    fun setFocus(value: Boolean) = println("I ${if (value) "got" else "lost"} focus")
    fun showOff() = println("I am focusable")
}

class Button : Clickable, Focusable {
    //для переопределение функции обязательно надо писать override. Схоже с аннотацией из Java
    override fun click() = println("I was clicked")

    override fun showOff() {
        super<Focusable>.showOff()
        super<Clickable>.showOff()
    }
}


fun main() {
    val button = Button()
    button.click()
    button.setFocus(true)
    button.showOff()
}