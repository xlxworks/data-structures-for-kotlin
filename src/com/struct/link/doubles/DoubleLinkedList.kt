package com.struct.link.doubles

import com.struct.link.ILink

class DoubleLinkedList<T> : ILink<T> {
    private var size: Int = 0
    private var first: Node<T>? = null
    private var last: Node<T>? = null

    /**
     * add first
     */
    override fun addFirst(item: T) {
        val f = first
        val node = Node(item, null, f)
        first = node
        if (f == null) {
            last = node
        } else {
            f.pre = node
        }
        size++

    }

    /**
     * add last
     */
    override fun addLast(item: T) {
        val l = last
        val node = Node(item, l, null)
        last = node
        if (l == null) {
            first = node
        } else {
            l.next = node
        }
        size++
    }

    /**
     * remove first
     */
    override fun removeFirst() {
        if (isEmpty()) {
            throw NoSuchElementException()
        }

        if (first == last) {
            first = null
            last = null
        } else {
            val node = first?.next
            first = null
            first = node
        }
        size--
    }

    /**
     * remove last
     */
    override fun removeLast() {
        if (last == null) {
            throw NoSuchElementException()
        }
        val l = last
        if (first == last) {
            first = null
            last = null
        } else {
            val pre = l?.pre
            pre?.next = null
            last = pre
        }

        size--
    }

    override fun indexOf(item: T): Int {
        var index = 0
        var curr = first
        while (curr != null) {
            if (curr.value == item) {
                return index
            }
            curr = curr.next
            index++
        }

        return -1
    }

    override fun isEmpty(): Boolean {
        return first == null
    }

    override fun size(): Int {
        return size
    }

    override fun contains(item: T): Boolean {
        return indexOf(item) != -1
    }

    override fun toString(): String {
        var curr = first
        val builder = StringBuilder("[")
        while (true) {
            if (curr?.next == null) {
                return builder.append(if (curr?.value == null) "" else curr.value).append("]").toString()
            }
            builder.append(curr.value)
            curr = curr.next
            builder.append(", ").append(" ")
        }
    }


}