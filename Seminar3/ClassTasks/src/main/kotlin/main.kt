open class Point(val x: Double, val y: Double) {

    open val area: Double = 0.0

    open fun display() {

    }
}

class Circle(x: Double, y: Double, r: Double) : Point(x, y) {
    private val xCoordinate: Double
    init {
        xCoordinate = x
    }

    private val yCoordinate: Double
    init {
        yCoordinate = y
    }

    private val radius: Double
    init {
        radius = r
    }

    override val area: Double
        get() = Math.PI * radius * radius

    override fun display() {
        val generalInfo = "S = $area, X = $xCoordinate, Y = $yCoordinate"
        println(generalInfo)
    }
}

class Square(x: Double, y: Double, a: Double) : Point(x, y) {
    private val xCoordinate: Double
    init {
        xCoordinate = x
    }

    private val yCoordinate: Double
    init {
        yCoordinate = y
    }

    private val side: Double
    init {
        side = a
    }

    override val area: Double
        get() = side * side

    override fun display() {
        val generalInfo = "S = $area, X = $xCoordinate, Y = $yCoordinate"
        println(generalInfo)
    }
}


fun main() {
    val p = Point(34.0, 56.0)
    val c = Circle(46.0, 34.0, 7.0)
    val s = Square(46.0, 34.0, 8.0)
    p.display()
    c.display()
    s.display()
}