package avlTree

import Avl.AvlVertex
import abstractTree.Tree

class AvlTree<T>(root: AvlVertex<T>): Tree<AvlVertex<T>>(root){
    fun bFactor() = ((this.getRightTree() as AvlTree<T>?)?.getRoot()?.getHeight() ?: 0) - ((this.getLeftTree() as AvlTree<T>?)?.getRoot()?.getHeight() ?: 0)

    fun rotateRight(){
        val temp = this.getLeftTree() as AvlTree<T>?
        this.setLeftTree(temp?.getRightTree() as AvlTree<T>?)
        temp?.setRightTree(this)
        this.updateHeight()
        temp?.updateHeight()
    }

    fun rotateLeft(){
        val temp = this.getRightTree() as AvlTree<T>?
        temp?.setRightTree(this.getLeftTree() as AvlTree<T>?)
        this.setLeftTree(temp)
        temp?.updateHeight()
        this.updateHeight()
    }

    fun balance(){
        this.updateHeight()
        if (this.bFactor() == 2) {
            if ((this.getRightTree() as AvlTree<T>?)!!.bFactor() < 0) (this.getRightTree() as AvlTree<T>?)?.rotateRight()
            this.rotateLeft()
        }
        if (this.bFactor() == -2) {
            if ((this.getLeftTree() as AvlTree<T>?)!!.bFactor() > 0) (this.getLeftTree() as AvlTree<T>?)?.rotateLeft()
            this.rotateRight()
        }
    }

    fun add(vertex: AvlVertex<T>) {
        if(this.getRoot() == null){
            setRoot(vertex)
            return
        }
        if (this.getRoot()!!.getKey() > vertex.getKey()) {
            if (this.getLeftTree() == null) this.setLeftTree(AvlTree(vertex))
            else (this.getLeftTree() as AvlTree<T>).add(vertex)
        } else {
            if (this.getRightTree() == null) this.setRightTree(AvlTree(vertex))
            else (this.getRightTree() as AvlTree<T>).add(vertex)
        }
        this.balance()
    }
}