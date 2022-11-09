fun main(args: Array<String>) {

}

fun kdTreeTest() {
    val kdt = KdTree<Int>()
    kdt.insert(listOf(283, 219))
    kdt.insert(listOf(369, 138))
    kdt.insert(listOf(92, 91))
    kdt.insert(listOf(123, 206))
    kdt.insert(listOf(260, 126))
    kdt.insert(listOf(193, 156))
    kdt.insert(listOf(104, 78))
    kdt.insert(listOf(394, 254))
    kdt.insert(listOf(224, 322))
    kdt.insert(listOf(208, 411))
    kdt.print()
}

fun multiTypeKdTreeTest() {
    val kdt = KdTreeMultiType<MultiTypePoint>()
    kdt.insert(MultiTypePoint(283, 219))
    kdt.insert(MultiTypePoint(369, 138))
    kdt.insert(MultiTypePoint(92, 91))
    kdt.insert(MultiTypePoint(123, 206))
    kdt.insert(MultiTypePoint(260, 126))
    kdt.insert(MultiTypePoint(193, 156))
    kdt.insert(MultiTypePoint(104, 78))
    kdt.insert(MultiTypePoint(394, 254))
    kdt.insert(MultiTypePoint(224, 322))
    kdt.insert(MultiTypePoint(208, 411))
    kdt.print()
}

fun bstTest() {
    val bst = BST<Point>()
    bst.insert(Point(10, 10))
    bst.insert(Point(5, 20))
    bst.insert(Point(15, 15))
    bst.print()
}

data class Point(val x: Int, val y: Int) : Comparable<Point> {
    override fun compareTo(other: Point) = when {
        x > other.x && y > other.y -> 1
        x == other.x && y == other.y -> 0
        else -> -1
    }
}

data class MultiTypePoint(val x: Int, val y: Int) : KdTreeElement<MultiTypePoint> {
    override fun compareTo(other: MultiTypePoint) = listOf(x.compareTo(other.x), y.compareTo(other.y))
}