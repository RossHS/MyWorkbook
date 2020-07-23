package kotlinCore.basic

/**
 * @author Ross Khapilov
 * @version 1.0 11.07.2020
 */
//when это аналог switch из Java, но с большим функционалом
fun getMnemonic(color: EnumK): String {
    return when (color) {
        EnumK.RED -> "красный"
        EnumK.GREEN -> "зеленый"
        EnumK.BLUE -> "синий"
        EnumK.BLACK -> "черный"
    }
}

// удобный, но малоэффективный код, т.к создаем много раз лишние коллекции
fun mix(color1: EnumK, color2: EnumK) = when (setOf(color1, color2)) {
    setOf(EnumK.RED, EnumK.GREEN) -> EnumJ.BLUE
    else -> EnumJ.BLACK
}

// оператор when без аргумента. Улучшенная версия функции выше, т.к. не создаем лишние объекты
fun mixOptimized(c1: EnumK, c2: EnumK) = when {
    (c1 == EnumK.RED && c2 == EnumK.GREEN) || (c1 == EnumK.GREEN && c2 == EnumK.RED) -> EnumK.BLUE
    else -> EnumK.BLACK
}

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun main() {
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(minus(Sum(Sum(Num(1), Num(2)), Num(5))))
}

fun eval(e: Expr): Int {
    if (e is Num) {
        val n = e as Num // as - приведение типов
        return n.value
    }
    if (e is Sum) {
        return eval(e.right) + eval(e.left) //рекурсия
    }
    throw IllegalArgumentException("Unknown Expression")
}

fun minus(e: Expr): Int {
    return when (e) {
        is Num -> {
            println("num ${e.value}")
            e.value
        }
        is Sum -> {
            val l = minus(e.left)
            val r = minus(e.right)
            println("Min $l - $r")
            l - r
        }
        else -> throw IllegalArgumentException("Unknown expression")
    }
}