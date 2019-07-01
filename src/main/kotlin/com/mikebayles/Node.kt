package com.mikebayles

import java.util.*

abstract class Node<T> {
    abstract val data: T
    abstract val children: List<Node<T>>

    fun nodesByDepth(depth: Int): Map<Int, MutableList<T>> {
        val result = mutableMapOf(depth to mutableListOf(data))

        children.forEach {
            val childResult = it.nodesByDepth(depth + 1)
            childResult.forEach { kv ->
                result.getOrPut(kv.key, { mutableListOf() }).addAll(kv.value)
            }
        }

        return result
    }

    fun levelOrderTraversal(): List<T> {
        val result = mutableListOf<T>()
        val visited = mutableSetOf<Node<T>>()
        val queue = ArrayDeque<Node<T>>()

        queue.add(this)
        visited.add(this)

        while (queue.isNotEmpty()) {
            val node = queue.remove()
            result.add(node.data)
            node.children.filter { !visited.contains(it) }.forEach {
                queue.add(it)
                visited.add(it)
            }
        }

        return result
    }
}