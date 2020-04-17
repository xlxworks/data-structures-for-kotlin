package com.struct.link

interface ILink<T> {
    fun addFirst(item: T)

    fun addLast(item: T)

    fun removeFirst()

    fun removeLast()

    fun indexOf(item: T): Int

    fun isEmpty(): Boolean

    fun size(): Int

    fun contains(item: T): Boolean

}