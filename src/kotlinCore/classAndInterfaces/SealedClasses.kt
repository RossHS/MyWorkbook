package kotlinCore.classAndInterfaces

/**
 * Ограничение создания подклассов. Если объявить класс как Sealed, то его подклассы обязаны находится внутри его.
 * Т.е. мы можем создать ограниченный набор подклассов и закрыть класс для дальнейшего наследования
 * @author Ross Khapilov
 * @version 1.0 13.07.2020
 */

sealed class Expr {
    class Num(val value: Int) : Expr()
    class Sum(val left: Int, val right: Int) : Expr()
}