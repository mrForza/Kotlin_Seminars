abstract class Person(name: String, lastName: String) {
    abstract override fun toString(): String
}

interface Employee {
    var salary: Double
    fun fire()
    fun increaseSalary()
}

class Student(name: String, lastName: String, grades: MutableList<Int>) : Comparable<Student>, Person(name, lastName) {
    private var grades: MutableList<Int>
    init {
        this.grades = grades;
    }

    private val name: String
    init {
        this.name = name
    }

    private val lastName: String
    init {
        this.lastName = lastName
    }

    fun expell() {
        println("The ${toString()} have been expelled!")
    }

    fun addGrade(grade: Int) {
        this.grades.add(grade)
    }

    fun getSumOfGrades(): Int {
        var sum = 0
        for (grade in this.grades) {
            sum += grade
        }
        return sum
    }

    override fun toString(): String {
        return "Student ${this.name} ${this.lastName}"
    }

    override fun compareTo(other: Student): Int {
        if (this.getSumOfGrades() > other.getSumOfGrades()) {
            return 1
        }
        return 0
    }
}

class Boss(name: String, lastName: String, phoneNumber: String) : Employee, Person(name, lastName) {
    override var salary: Double = (0..10).random().toDouble()

    private val phoneNumber: String
    init {
        this.phoneNumber = phoneNumber;
    }

    override fun fire() {
        println("You are fired!")
    }

    override fun increaseSalary() {
        this.salary += (0..2).random()
    }

    override fun toString(): String {
        return "Boss phone number: ${this.phoneNumber}"
    }

}

class Professor(name: String, lastName: String, boss: Boss, salary: Double) : Employee, Person(name, lastName) {
    override var salary: Double = (0..10).random().toDouble()

    private val name: String
    init {
        this.name = name
    }

    private val lastName: String
    init {
        this.lastName = lastName
    }

    override fun increaseSalary() {
        this.salary += (0..2).random()
    }

    override fun fire() {
        println("You are fired!")
    }

    override fun toString(): String {
        return "Professor ${this.name} ${this.lastName}"
    }
}

fun sortStudents(students: MutableList<Student>) {
    for (i in 1..<students.size) {
        var k = i
        val firstSum = students[k - 1].getSumOfGrades()
        val secondSum = students[k].getSumOfGrades()
        while (k > 0 && firstSum < secondSum) {
            val tempStudent = students[k - 1]
            students[k - 1] = students[k]
            students[k] = tempStudent
            --k;
        }
    }
}

fun main() {
    val fcsBoss = Boss("Ivan", "Arzhanchev", "+88005553535")
    val people: List<Person> = listOf(
        Student("Roman", "Gromov", mutableListOf(6, 4, 8)),
        Professor("Alexandr", "Legalov", fcsBoss, 5000.0),
        fcsBoss
    )

    for (person in people) {
        println(person.toString())
    }

    var students: MutableList<Student> = mutableListOf(
        Student("Ivan", "Kirillov", mutableListOf(1, 8, 3, 8, 3)),
        Student("Gromov", "Roman", mutableListOf(7, 6, 4, 6, 6)),
        Student("Alena", "Drozdova", mutableListOf(5, 9, 9, 3, 7)),
        Student("Ivan", "Pesnya", mutableListOf(10, 10, 2, 8, 9)),
        Student("Kirill", "Ivanov", mutableListOf(6, 8, 3, 0, 0))
    )

    // students.sortedWith(compareBy { it.getSumOfGrades() })
    sortStudents(students)

    for (student in students) {
        println("${student.toString()}; ${student.getSumOfGrades()}")
    }
}