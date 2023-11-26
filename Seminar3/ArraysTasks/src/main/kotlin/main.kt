import java.lang.NumberFormatException

fun testSortArrayDesc() {
    val testCases: List<Pair<Array<Int>, Array<Int>>> = listOf(
        Pair(arrayOf(5, 2, 3, 4, 1), arrayOf(5, 4, 3, 2, 1)),
        Pair(arrayOf(1, 0, 0, 1, 1, 0, 0, 0, 0), arrayOf(1, 1, 1, 0, 0, 0, 0, 0, 0)),
        Pair(arrayOf(-3, -2, -1, 0, 1, 2, 3), arrayOf(3, 2, 1, 0, -1, -2, -3)),
        Pair(arrayOf(-125, 73, 124, 84, 46, 64, 75, -124, 57, 0, 1), arrayOf(124, 84, 75, 73, 64, 57, 46, 1, 0, -124, -125)),
        Pair(arrayOf(111, 555, 222, 444, 888, 999, 444, 0, 333, 777), arrayOf(999, 888, 777, 666, 555, 444, 333, 222, 111, 0)),
    )

    var i = 1
    for (testCase in testCases) {
        print("Test №$i: ")
        println()
        print("case answer: ")
        for (num in testCase.second) {
            print("$num ")
        }
        sortArrayDesc(testCase.first)
        println()
        print("your answer: ")
        for (num in testCase.first) {
            print("$num ")
        }
        println()
        println()
        i += 1
    }
}

fun readAndCheckInput(): Int {
    var number: Int
    while (true) {
        try {
            number = readln().toInt()
            break
        } catch (exc: NumberFormatException) {
            println("You have entered the incorrect number! Try again!")
        }
    }
    return number
}

fun makeArray(): Array<Int> {
    val inputSizeText = "Input the size of the array: "
    print(inputSizeText)
    val arraySize: Int = readAndCheckInput()

    val array: Array<Int> = Array(arraySize) { 0 }
    var n = arraySize
    while (n > 0) {
        val index = arraySize - n
        val numberMask = "$index number = "
        print(numberMask)
        val number = readAndCheckInput()
        array[index] = number
        n -= 1
    }

    return array
}

fun sortArrayDesc(arr: Array<Int>) { // Insertion Sort
    for (i in 1..<arr.size) {
        var k = i
        while (k > 0 && arr[k - 1] < arr[k]) {
            val temp = arr[k - 1]
            arr[k - 1] = arr[k]
            arr[k] = temp
            --k
        }
    }
}

fun main() {
    println("testSortArrayDesc: ")
    testSortArrayDesc()
    println()
    println("Your custom array:")
    val array = makeArray()
    sortArrayDesc(array)
    for (num in array) {
        print("$num ")
    }
}