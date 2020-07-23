package kotlinCore.classAndInterfaces

/**
 * ПО дефолту все классы и функции максимально закрыты (на язык Java final).
 * Для разрешения наследования, следует написать open в объявлении класса или методы
 * @author Ross Khapilov
 * @version 1.0 13.07.2020
 */
open class RichButton: Clickable{
    fun disable(){} //переопределение не разрешено
    open fun animate(){} //можно переопределить
    override fun click() {} //переопределенный метод по умолчанию можно переопределить в дочернем классе
    final override fun showOff() {} //для запрета переопределения достаточно написать модификатор final
}