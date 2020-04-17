package com.struct.link

import java.lang.IllegalArgumentException

/**
 * 单向链表
 */
class SingleLinkedList<T> : ILink<T> {

    private var first: Node<T>? = null
    private var last: Node<T>? = null
    private var size: Int = 0

    /**
     * add first
     */
    override fun addFirst(item: T) {
        val node = Node(item)
        if (isEmpty()) {
            first = node
            last = node
        } else {
            node.next = first
            first = node
        }

        size++
    }

    /**
     * add last
     */
    override fun addLast(item: T) {
        val node = Node(item)
        if (isEmpty()) {
            first = node
            last = node
        } else {
            last?.next = node
            last = node
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
            val second = first?.next
            first?.next = null
            first = second
        }
        size--
    }

    override fun removeLast() {
        if (isEmpty()) {
            throw NoSuchElementException()
        }
        if (first == last) {
            first = null
            last = null
        } else {
            val previous = getPrevious(last)
            last = previous
            previous?.next = null
        }

        size--
    }

    /**
     * 获取目标节点的前置节点
     */
    private fun getPrevious(item: Node<T>?): Node<T>? {
        var curr = first
        while (curr != null) {
            if (curr.next == item) {
                return curr
            }
            curr = curr.next
        }
        return null
    }

    /**
     * index of
     */
    override fun indexOf(item: T): Int {
        var index = 0
        var curr: Node<T>? = first
        while (curr != null) {
            if (curr.value == item) {
                return index
            }
            curr = curr.next
            index++
        }

        return -1
    }

    /**
     * reverse
     */
    fun reverse() {
        if (isEmpty()) {
            return
        }

        var p = first
        var c = first?.next
        while (c != null) {
            val n = c.next
            c.next = p
            p = c
            c = n
        }

        last = first
        last?.next = null
        first = p
    }

    /**
     * 返回倒数第k个元素
     */
    fun lastKthOf(k: Int): T? {
        if (isEmpty() || (k < 0 || k > size)) {
            throw IllegalArgumentException()
        }

        var fast = first
        var slow = first

//        (0 until k - 1).forEach { _ ->
//            fast = fast?.next
//        }
        repeat((0 until k - 1).count()) {
            fast = fast?.next
        }

        while (fast != last) {
            fast = fast?.next
            slow = slow?.next
        }

        return slow?.value
    }

    /**
     * links data length
     */
    override fun size(): Int {
        return size
    }

    /**
     * isEmpty
     */
    override fun isEmpty(): Boolean {
        return first == null
    }

    override fun contains(item: T): Boolean {
        return indexOf(item) != -1
    }
}