package AvlTree

import Avl.AvlVertex
import Tree

class AvlTree<T>(root: AvlVertex<T>): Tree<AvlVertex<T>>(root){
    fun bFactor() = ((this.rightTree as AvlTree<T>?)?.root?.height ?: 0) - ((this.leftTree as AvlTree<T>?)?.root?.height ?: 0)

    fun rotateRight(): AvlTree<T>? {
        val temp = this.leftTree as AvlTree<T>?
        this.leftTree = temp?.rightTree as AvlTree<T>?
        temp?.rightTree = this
        this.updateHeight()
        temp?.updateHeight()
        return temp
    }

    fun rotateLeft(): AvlTree<T>{
        val temp = this.rightTree as AvlTree<T>?
        temp?.rightTree = this.leftTree as AvlTree<T>?
        this.leftTree = temp
        temp?.updateHeight()
        this.updateHeight()
        return this
    }

    fun balance(): AvlTree<T>? {
        this.updateHeight()
        if (this.bFactor() == 2) {
            if ((this.rightTree as AvlTree<T>?)!!.bFactor() < 0) this.rightTree = (this.rightTree as AvlTree<T>?)?.rotateRight()
            this.rotateLeft()
        }
        if (this.bFactor() == -2) {
            if ((this.leftTree as AvlTree<T>?)!!.bFactor() > 0) this.leftTree = (this.leftTree as AvlTree<T>?)?.rotateLeft()
            this.rotateRight()
        }
    }

    fun add(vertex: AvlVertex<T>) {
        if (this.root.key > vertex.key) {
            if (this.leftTree == null) this.leftTree = AvlTree(vertex)
            else (this.leftTree as AvlTree<T>).add(vertex)
        } else {
            if (this.rightTree == null) this.rightTree = AvlTree(vertex)
            else (this.rightTree as AvlTree<T>).add(vertex)
        }
        this.balance()
    }
}