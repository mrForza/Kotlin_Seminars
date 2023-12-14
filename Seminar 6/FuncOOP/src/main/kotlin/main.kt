fun <T> Collection<T>.join(separator: String, beforePrint: (T) -> String): String {
    return this.joinToString(separator) { beforePrint(it) }
}

fun main() {
    val predicate = "ABC"
    val stupidFilter = {str: String -> str.filter{!predicate.contains(it)}}
    println(stupidFilter("asABUUUCCC"))
    println()
    val collection: List<String> = listOf("1223", "wgekweg", "IHEGIHOEG")
    val result = collection.join("<-->") { it.toString() }
    println(result)
}