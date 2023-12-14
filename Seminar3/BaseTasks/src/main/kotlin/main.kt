import java.lang.NumberFormatException
import java.util.Vector
import kotlin.math.sqrt
import kotlin.system.exitProcess

fun test() {
    val testCases: List<Pair<List<Double>, Pair<Double, Double>>> = listOf(
        Pair(listOf(1.0, 1.0, 1.0), Pair(Double.NaN, Double.NaN)), // No roots
        Pair(listOf(1.0, 6.0, 10.0), Pair(Double.NaN, Double.NaN)), // No roots
        Pair(listOf(-1235.0, 3.124, -5.0), Pair(Double.NaN, Double.NaN)), // No roots
        Pair(listOf(-42154.0, -31.25124,-5.0), Pair(Double.NaN, Double.NaN)), // No roots
        Pair(listOf(0.0, 0.0, 0.0), Pair(Double.NaN, Double.NaN)), // No roots
        Pair(listOf(0.0, 0.0, 5.0), Pair(Double.NaN, Double.NaN)), // No roots
        Pair(listOf(0.0, 0.0, -34.0), Pair(Double.NaN, Double.NaN)), // No roots
        Pair(listOf(1.0, 6.0, 9.0), Pair(-3.0, Double.NaN)), // 1 root
        Pair(listOf(-9.0, -30.0, -25.0), Pair(-1.6667, Double.NaN)), // 1 root
        Pair(listOf(-2.25, -9.75, -10.5625), Pair(-2.1667, Double.NaN)), // 1 root
        Pair(listOf(0.0, 3.0, 1.0), Pair(-0.33333, Double.NaN)), // 1 root
        Pair(listOf(0.0, -235.0, 352.0), Pair(1.498, Double.NaN)), // 1 root
        Pair(listOf(0.0, 3.0, -5.0), Pair(1.6667, Double.NaN)), // 1 root
        Pair(listOf(0.0, -34.3567, 11245.0), Pair(327.302, Double.NaN)), // 1 root
        Pair(listOf(1.0, -15.0, 36.0), Pair(3.0, 12.0)), // 2 root
        Pair(listOf(1.0, 20.0, 36.0), Pair(-18.0, -2.0)), // 2 root
        Pair(listOf(1.0, 3.0, 4.0), Pair(-4.0, 1.0)), // 2 root
        Pair(listOf(1.0, 11.0, -12.0), Pair(-12.0, 1.0)), // 2 root
        Pair(listOf(2.0, -9.0, 7.0), Pair(1.0, 3.5)), // 2 root
    )

    var i = 1
    for (testCase in testCases) {
        val answer: Pair<Double, Double> = quadraticRoots(
            testCase.first[0], testCase.first[1], testCase.first[2]
        )
        print("Test №$i: ")
        print("case answer:  ")
        print("<${testCase.second.first}, ${testCase.second.second}>")
        print("\tyour answer: ")
        print("<${answer.first}, ${answer.second}>")

        println()
        i += 1
    }
}

fun askForInput() {
    println("Hello! Please, enter your Name, Surname and Father's name")
    println()
    print("Name: ")
    val name: String = readln()
    print("Surname: ")
    val surname: String = readln()
    print("Father's name: ")
    val fatherName: String = readln()

    val generalMask = "Surname: $surname\nName: $name\nFather's name: $fatherName"
    println()
    println(generalMask)
}

fun quadraticRoots(a: Double, b: Double, c: Double): Pair<Double, Double> {
    if (a == 0.0) {
        if (b == 0.0) {
            return Pair(Double.NaN, Double.NaN) // No roots
        }
        return Pair(-c / b, Double.NaN) // 1 root
    }

    val discriminant = b * b - 4 * a * c
    return if (discriminant < 0) {
        Pair(Double.NaN, Double.NaN) // No roots
    } else if (discriminant == 0.0) {
        val root = -b / (2 * a)
        Pair(root, Double.NaN)
    } else {
        val firstRoot = (-b + sqrt(discriminant)) / (2 * a)
        val secondRoot = (-b - sqrt(discriminant)) / (2 * a)
        Pair(firstRoot, secondRoot) // 2 roots
    }
}

fun printSameDigitNumbers() {
    println()
    for (num in 1..9) {
        println("$num$num$num")
    }
}

fun getQuadraticParameters(): Vector<Double> {
    var a = 0.0
    var b = 0.0
    var c = 0.0

    while (true) {
        try {
            print("a parameter: ")
            a = readln().toDouble()
            print("b parameter: ")
            b = readln().toDouble()
            print("c parameter: ")
            c = readln().toDouble()
        } catch (exc: NumberFormatException) {
            println("Incorrect input!")
        }
        break
    }

    val resultVector: Vector<Double> = Vector()
    resultVector.add(a)
    resultVector.add(b)
    resultVector.add(c)
    return resultVector
}

fun main() {
    test()
    val choiceText = "Your option: "
    val optionsText = "1) askForInput()\n2) quadraticRoots()\n3) printSameDigitNumbers()\n4) Exit"

    while (true) {
        try {
            println()
            println(optionsText)
            println()
            print(choiceText)
            val userChoice = readln().toInt()
            if (userChoice in 1..4) {
                when (userChoice) {
                    1 -> askForInput()
                    2 -> {
                        val noRoots = "This equation doesn't have any roots!"
                        val firstRoot = "x1 = "
                        val secondRoot = "x2 = "
                        val parameters: Vector<Double> = getQuadraticParameters()
                        val roots: Pair<Double, Double> = quadraticRoots(parameters[0], parameters[1], parameters[2])
                        println()
                        if (roots.first.isNaN() && roots.second.isNaN()) {
                            println(noRoots)
                        } else if (roots.second.isNaN()) {
                            print(firstRoot)
                            print(roots.first)
                            println()
                        } else {
                            print(firstRoot)
                            print(roots.first)
                            println()
                            print(secondRoot)
                            print(roots.second)
                            println()
                        }
                    }
                    3 -> printSameDigitNumbers()
                    4 -> exitProcess(0)
                }
            } else {
                println("You have entered wrong number! Try again")
            }
        } catch (exception: NumberFormatException) {
            println("You haven't entered the number!")
        }
    }
}