package com.mikebayles

import kotlin.math.max
import kotlin.math.min

fun <T> List<T>.toBinaryTree(): BinaryNode<T>? {
    if (isEmpty()) return null
    if (size == 1) return BinaryNode(this[0])
    val mid = size / 2
    return BinaryNode(
            data = this[mid],
            left = subList(0, mid).toBinaryTree(),
            right = subList(mid + 1, size).toBinaryTree()
    )
}

val BinaryNode<Int>?.min: Int
    get() {
        if (this == null) return Int.MAX_VALUE

        val res = data
        val leftRes = left.min
        val rightRes = right.min

        return min(min(res, leftRes), rightRes)

    }

val BinaryNode<Int>?.max: Int
    get() {
        if (this == null) return Int.MIN_VALUE

        val res = data
        val leftRes = left.max
        val rightRes = right.max

        return max(max(res, leftRes), rightRes)

    }

val BinaryNode<Int>?.isBst: Boolean
    get() {
        if (this == null) return true
        left?.let {
            if (it.data > data) return false
        }

        right?.let {
            if (it.data < data) return false
        }

        return left.isBst && right.isBst
    }

data class BinaryNode<T>(
        override val data: T,
        val left: BinaryNode<T>? = null,
        val right: BinaryNode<T>? = null) : Node<T>() {

    override val children: List<Node<T>>
        get() {
            return mutableListOf<Node<T>>().apply {
                left?.let { add(it) }
                right?.let { add(it) }
            }
        }

    val isBalanced: Boolean
        get() {
            if (right?.children?.isEmpty() != left?.children?.isEmpty()) return false
            return left?.isBalanced == right?.isBalanced
        }

    val height: Int
        get() {
            val leftHeight = left?.height ?: 0
            val rightHeight = right?.height ?: 0

            return 1 + max(leftHeight, rightHeight)
        }

    fun inOrderTraversal(): MutableList<T> {
        val result = mutableListOf<T>()

        left?.let {
            result.addAll(it.inOrderTraversal())
        }

        result.add(data)

        right?.let {
            result.addAll(it.inOrderTraversal())
        }

        return result
    }

    fun preOrderTraversal(): MutableList<T> {
        val result = mutableListOf<T>()

        result.add(data)

        left?.let {
            result.addAll(it.preOrderTraversal())
        }

        right?.let {
            result.addAll(it.preOrderTraversal())
        }

        return result
    }

    fun postOrderTraversal(): MutableList<T> {
        val result = mutableListOf<T>()

        left?.let {
            result.addAll(it.postOrderTraversal())
        }

        right?.let {
            result.addAll(it.postOrderTraversal())
        }

        result.add(data)

        return result
    }

//    fun isBst(): Boolean {
//
//        left?.let {
//            if (it.data > data) return false
//        }
//
//        right?.let {
//            if (it.data < data) return false
//        }
//
//        return left.isBst && right.isBst
//    }
}