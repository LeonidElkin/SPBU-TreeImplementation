package redBlackTree

import abstractTree.Vertex

class RedBlackVertex<T>(key: Int, value: T): Vertex<T>(key, value){
    var color: Int = Color.RED
}