class BST<T : Comparable<T>> {
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
        while (x != null) when {
            t < x.data && x.left == null    -> { x.left = Node(t, x); return }
            t < x.data                      -> x = x.left
            t > x.data && x.right == null   -> { x.right = Node(t, x); return }
            t > x.data                      -> x = x.right
            t == x.data                     -> return
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
