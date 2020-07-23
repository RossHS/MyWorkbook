package kotlinCore.function

/**
 * @author Ross Khapilov
 * @version 1.0 12.07.2020
 */
//чтобы не плодить много одинаковых перегруженных методов. В Kotlin можно указывать значение по умолчанию для аргументов

//аннотация для создания компилятором перегруженных методов,
//чтобы можно было использовать значения по умолчанию из Java
@JvmOverloads
fun <T> joinToString(
        collection: Collection<T>,
        separator: String = ", ", //указываем значение по умолчанию
        prefix: String = "",
        postfix: String = ""): String {
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

//Тоже, но на Java
//public static <T> String joinToString(Collection<T> collection, String separator, String prefix, String postfix) {
//    StringBuilder result = new StringBuilder(prefix);
//    Iterator<T> iter = collection.iterator();
//    for (int i = 0; iter.hasNext(); i++) {
//        if (i > 0) result.append(separator);
//        result.append(iter.next());
//    }
//    result.append(postfix);
//    return result.toString();
//}
//
//public static <T> String joinToString(Collection<T> collection) {
//    return joinToString(collection, ", ");
//}
//
//public static <T> String joinToString(Collection<T> collection, String separator) {
//    return joinToString(collection, separator, "");
//}
//
//public static <T> String joinToString(Collection<T> collection, String separator, String prefix) {
//    return joinToString(collection, separator, prefix, "");
//}