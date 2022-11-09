class KdTreeMultiType<T : KdTreeElement<T>> {
    data class Node<T>(
        val data: T,
        var parent: Node<T>? = null,
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
            val comparison = t.compareTo(x.data).let { it[level % it.size] }
            when {
                comparison < 0 && x.left == null  -> { x.left = Node(t); return }
                comparison < 0                    -> x = x.left
                comparison > 0 && x.right == null -> { x.right = Node(t); return }
                comparison > 0                    -> x = x.right
                else                              -> return
            }
            level++
        }
    }

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
    fun compareTo(other: T): List<Int>
}
