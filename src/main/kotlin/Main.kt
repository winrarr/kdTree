import kotlin.random.Random

fun main(args: Array<String>) {
    val kdt = KdTree<Point>(2)
    for (i in 0..100) {
        kdt.insert(Point(Random.nextInt(100), Random.nextInt(100)))
    }
    kdt.print()
}

data class Point(val x: Int, val y: Int) : KdTreeElement<Point> {
    override fun compareTo(other: Point, level: Int) = when (level) {
        0 -> x.compareTo(other.x)
        1 -> y.compareTo(other.y)
        else -> throw Exception()
    }
}