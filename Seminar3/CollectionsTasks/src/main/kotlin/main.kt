fun testReplaceElements() {
    val testCases: List<Pair<MutableList<String>, MutableList<String>>> = listOf(
        Pair(mutableListOf("qwe", "qwe", "gr3", "123", "gr3"), mutableListOf("qwe", "blahblah", "gr3", "123", "blahblah")),
        Pair(mutableListOf("a", "a", "a", "a", "a"), mutableListOf("a", "blahblah", "blahblah", "blahblah", "blahblah")),
        Pair(mutableListOf("a", "b", "c", "d", "e"), mutableListOf("a", "b", "c", "d", "e")),
        Pair(mutableListOf("abc", "qwe", "abv", "abc", "qwe"), mutableListOf("abc", "qwe", "abv", "blahblah", "blahblah")),
        Pair(mutableListOf("1", "11", "1", "11", "111"), mutableListOf("1", "11", "blahblah", "blahblah", "111")),
        Pair(mutableListOf("Lorem ipsum", "doler", "sit", "amet"), mutableListOf("Lorem ipsum", "doler", "sit", "amet")),
    )

    var i = 1
    for (testCase in testCases) {
        val answer: MutableList<String> = replaceElements(testCase.first)
        print("Test №$i: ")
        println()
        print("case answer: ")
        for (item in testCase.second) {
            print("$item ")
        }
        println()
        print("your answer: ")
        for (item in answer) {
            print("$item ")
        }
        println()
        println()
        i += 1
    }
}

fun testUniqueWords() {
    val testCases: List<Pair<String, Int>> = listOf(
        Pair("1 1 1 1 1 1 1 1 1", 1),
        Pair("Lorem ipsum doler sit amet", 5),
        Pair("Hello, my name is George Giorgio", 6),
        Pair("qwe qwe abc 1 4", 4),
        Pair("volt amper 1.5 volt volt quicksort nvidea quicksort 3 3 3 0x10123", 7),
        Pair("vVv VvV 0o0 o0o AaoA AaoA", 5),
    )

    var i = 1
    for (testCase in testCases) {
        val answer: Int = uniqueWords(testCase.first)
        print("Test №$i")
        println()
        print("case answer: ${testCase.second}")
        println()
        print("your answer: $answer")
        println()
        println()
        i += 1
    }
}

fun replaceElements(array: MutableList<String>): MutableList<String> {
    val frequencyMap: MutableMap<String, Int> = mutableMapOf()

    for (i in array.indices) {
        if (frequencyMap.getOrDefault(array[i], -1) == -1) {
            frequencyMap += Pair(array[i], 1)
        } else {
            array[i] = "blahblah"
        }
    }

    return array
}

fun uniqueWords(text: String): Int {
    val frequencyMap: MutableMap<String, Int> = mutableMapOf()
    val words: List<String> = text.split(" ")

    var counter = 0
    for (word in words) {
        if (frequencyMap.getOrDefault(word, -1) == -1) {
            frequencyMap += Pair(word, 1)
        } else {
            counter += 1
        }
    }

    return words.size - counter
}

fun main() {
    println("testReplaceElements")
    println()
    testReplaceElements()
    println()
    println()
    println("testUniqueWords")
    println()
    testUniqueWords()
}