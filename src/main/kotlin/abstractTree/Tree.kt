package abstractTree

abstract class Tree<T>(private var root: T?) {

    private var leftTree: Tree<T>? = null
    private var rightTree: Tree<T>? = null
    private val vRoot = this.root as Vertex<*>

    fun getRoot() = this.root

    fun setRoot(newRoot: T?){
        this.root = newRoot
    }

    fun getLeftTree() = this.leftTree

    fun setLeftTree(newValue: Tree<T>?) {
        this.leftTree = newValue
    }

    fun getRightTree() = this.rightTree

    fun setRightTree(newValue: Tree<T>?) {
        this.rightTree = newValue
    }

    fun getHeight(): Int{
        if(root == null)return 0
        return vRoot.getHeight()
    }

    fun setHeight(newValue: Int){
        vRoot.setHeight(newValue)
    }

    fun updateHeight() {
        val leftHeight = this.getLeftTree()?.getHeight() ?: 0
        val rightHeight = this.getRightTree()?.getHeight() ?: 0
        setHeight(leftHeight + rightHeight + 1)
    }

    fun find(key: Int): Any? {
        if (vRoot.getkey() == key) return vRoot.getValue()
        return if (vRoot.getkey() > key) {
            this.getLeftTree()?.find(key)
        } else {
            this.getRightTree()?.find(key)
        }
    }
}