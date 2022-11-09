class KdTree<T : Comparable<T>> {
    data class Node<T>(
        val data: List<T>,
        var parent: Node<T>? = null,
        var left: Node<T>? = null,
        var right: Node<T>? = null,
    )

    private var root: Node<T>? = null

    fun insert(t: List<T>) {
        if (root == null) {
            root = Node(t)
            return
        }
        if (t.size != root!!.data.size) throw Exception("dafuq you doin")

        var x = root
        var level = 0
        val maxLevel = t.size
        while (x != null) {
            when {
                t[level] < x.data[level] && x.left == null  -> { x.left = Node(t); return }
                t[level] < x.data[level]                    -> x = x.left
                t[level] > x.data[level] && x.right == null -> { x.right = Node(t); return }
                t[level] > x.data[level]                    -> x = x.right
                t[level] == x.data[level]                   -> return
            }
            level = (level + 1) % maxLevel
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