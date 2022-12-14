class KdTree<T : KdTreeElement<T>>(private val maxLevel: Int) {
    data class Node<T>(
        val data: T,
        var left: Node<T>? = null,
        var right: Node<T>? = null,
    )

    private var root: Node<T>? = null

    fun insert(t: T) {
        if (root == null) {
            root = Node(t)
            return
        }

        var x = root
        var level = 0
        while (x != null) {
            val comparison = t.compareTo(x.data, level)
            x = when {
                comparison < 0 && x.left == null  -> { x.left = Node(t); return }
                comparison < 0                    -> x.left
                comparison > 0 && x.right == null -> { x.right = Node(t); return }
                comparison > 0                    -> x.right
                else                              -> return
            }
            level = (level + 1) % maxLevel
        }
    }

//    Shorter but slower implementation of insert
//
//    fun insert(t: T) {
//        fun trav(x: Node<T>?, level: Int): Node<T> = when {
//            x == null -> Node(t)
//            t.compareTo(x.data, level % maxLevel) < 0 -> Node(x.data, trav(x.left, level + 1), x.right)
//            t.compareTo(x.data, level % maxLevel) > 0 -> Node(x.data, x.left, trav(x.right, level + 1))
//            else -> x
//        }
//        root = trav(root, 0)
//    }

    private fun foreach(f: (Node<T>) -> Unit, x: Node<T>?) {
        if (x == null) return
        foreach(f, x.left)
        f(x)
        foreach(f, x.right)
    }

    fun print() {
        foreach({ println(it.data) }, root)
    }
}

interface KdTreeElement<T> {
    fun compareTo(other: T, level: Int): Int
}