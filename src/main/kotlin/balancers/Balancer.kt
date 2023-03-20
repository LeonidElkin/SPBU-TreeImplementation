package balancers

abstract class Balancer {
    protected fun leftRotate(){
        TODO()
    }

    protected fun rightRotate(){
        TODO()
    }

    protected fun balanceFactory(){
        TODO()
    }

    abstract fun balance()
}




/*

Lenya ento tvoya realization balancer.Balancer

fun bFactor() = ((this.getRightTree() as avlTree.AvlTree<T, K>?)?.getRoot()?.getHeight() ?: 0) - ((this.getLeftTree() as avlTree.AvlTree<T, K>?)?.getRoot()?.getHeight() ?: 0)

    fun rotateRight(){
        val temp = this.getLeftTree() as avlTree.AvlTree<T, K>?
        this.setLeftTree(temp?.getRightTree() as avlTree.AvlTree<T, K>?)
        temp?.setRightTree(this)
        this.updateHeight()
        temp?.updateHeight()
    }

    fun rotateLeft(){
        val temp = this.getRightTree() as avlTree.AvlTree<T, K>?
        temp?.setRightTree(this.getLeftTree() as avlTree.AvlTree<T, K>?)
        this.setLeftTree(temp)
        temp?.updateHeight()
        this.updateHeight()
    }

    fun balance(){
        this.updateHeight()
        if (this.bFactor() == 2) {
            if ((this.getRightTree() as avlTree.AvlTree<T, K>?)!!.bFactor() < 0) (this.getRightTree() as avlTree.AvlTree<T, K>?)?.rotateRight()
            this.rotateLeft()
        }
        if (this.bFactor() == -2) {
            if ((this.getLeftTree() as avlTree.AvlTree<T, K>?)!!.bFactor() > 0) (this.getLeftTree() as avlTree.AvlTree<T, K>?)?.rotateLeft()
            this.rotateRight()
        }
    }*/