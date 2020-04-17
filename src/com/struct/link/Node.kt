package com.struct.link

data class Node<T>(val value:T) {
    var next: Node<T>? = null
    override fun toString(): String {
        return "Node(value=$value, next=$next)"
    }


}