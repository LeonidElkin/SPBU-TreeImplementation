abstract class Tree<T>(val root: T) {

    var leftTree: Tree<T>? = null
    var rightTree: Tree<T>? = null

    fun getHeight() = (this.root as Vertex<*>).height

    fun updateHeight() {
        var leftHeight = 0
        if(this.leftTree != null) leftHeight = (this.leftTree?.root as Vertex<*>).height

        var rightHeight = 0
        if(this.rightTree != null) rightHeight = (this.rightTree?.root as Vertex<*>).height

        (this.root as Vertex<*>).height = leftHeight + rightHeight + 1
    }

    fun find(key: Int): Any? {
        if ((this.root as Vertex<*>).key == key) return this.root.value
        return if ((this.root as Vertex<*>).key > key) {
            this.leftTree?.find(key)
        } else {
            this.rightTree?.find(key)
        }
    }
}