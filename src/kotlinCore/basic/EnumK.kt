package kotlinCore.basic

/**
 * Теперь тоже перечисление, но на котлине
 * @author Ross Khapilov
 * @version 1.0 11.07.2020
 */
enum class EnumK(val red: Int, val green: Int, val blue: Int) {
    GREEN(0, 255, 0),
    RED(255, 0, 0),
    BLUE(0, 0, 255),
    BLACK(0, 0, 0);

    fun rnb() = (red * 256 + green) * 256 + blue
}