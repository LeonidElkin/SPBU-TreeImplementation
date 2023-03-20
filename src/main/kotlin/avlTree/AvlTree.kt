package avlTree

import balancers.AvlBalancer
import BTree

class AvlTree<K: Comparable<K>, V>(root: AvlNode<K, V>): BTree<K, V, AvlNode<K, V>>(root){

    private val balancer = AvlBalancer()

    override fun add(node: AvlNode<K, V>) {
        if(this.getRoot() == null){
            setRoot(node)
            return
        }
        if (this.getRoot()!!.getKey() > node.getKey()) {
            if (this.getLeftTree() == null) this.setLeftTree(AvlTree(node))
            else (this.getLeftTree() as AvlTree<K, V>).add(node)
        } else {
            if (this.getRightTree() == null) this.setRightTree(AvlTree(node))
            else (this.getRightTree() as AvlTree<K, V>).add(node)
        }
        balancer.balance()
    }

    override fun delete(key: K) {
        TODO("Not yet implemented")
    }
}