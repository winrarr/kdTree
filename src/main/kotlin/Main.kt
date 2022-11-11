import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    val kdt = KdTree<Point>(2)
    val random = Random(0)
    println(measureTimeMillis {
        for (i in 0..10000000) {
            kdt.insert(Point(random.nextInt(100), random.nextInt(100)))
        }
    })
}

data class Point(val x: Int, val y: Int) : KdTreeElement<Point> {
    override fun compareTo(other: Point, level: Int) = when (level) {
        0 -> x.compareTo(other.x)
        1 -> y.compareTo(other.y)
        else -> throw Exception()
    }
}