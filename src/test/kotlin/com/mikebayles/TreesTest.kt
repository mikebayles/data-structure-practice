/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.mikebayles

import kotlin.test.*

class TreesTest {

    //https://en.wikipedia.org/wiki/Tree_traversal
    val wikiTreeHead: BinaryNode<String> = BinaryNode(
            data = "F",
            left = BinaryNode(
                    data = "B",
                    left = BinaryNode(data = "A"),
                    right = BinaryNode(
                            data = "D",
                            left = BinaryNode("C"),
                            right = BinaryNode("E")
                    )
            ),
            right = BinaryNode(
                    data = "G",
                    right = BinaryNode(
                            data = "I",
                            left = BinaryNode("H")
                    )
            )
    )

    @Test
    fun `in order traversal`() {
        val actual = wikiTreeHead.inOrderTraversal()

        assertEquals(mutableListOf("A", "B", "C", "D", "E", "F", "G", "H", "I"), actual)
    }

    @Test
    fun `pre order traversal`() {
        val actual = wikiTreeHead.preOrderTraversal()

        assertEquals(mutableListOf("F", "B", "A", "D", "C", "E", "G", "I", "H"), actual)
    }

    @Test
    fun `post order traversal`() {
        val actual = wikiTreeHead.postOrderTraversal()

        assertEquals(mutableListOf("A", "C", "E", "D", "B", "H", "I", "G", "F"), actual)
    }

    //
    @Test
    fun `list toBinaryTree of odd length`() {
        val actual = listOf(1, 3, 5).toBinaryTree()
        val expected = BinaryNode(
                data = 3,
                left = BinaryNode(1),
                right = BinaryNode(5)
        )

        assertEquals(expected, actual)
    }

    @Test
    fun `list toBinaryTree of even length`() {
        val actual = listOf(3, 6).toBinaryTree()
        val expected = BinaryNode(
                data = 6,
                left = BinaryNode(3)
        )

        assertEquals(expected, actual)
    }

    @Test
    fun `list toBinaryTree with single element`() {
        val actual = listOf(5).toBinaryTree()
        val expected = BinaryNode(5)

        assertEquals(expected, actual)
    }

    @Test
    fun `toBinaryTree with no elements should return null`() {
        val actual = emptyList<String>().toBinaryTree()

        assertNull(actual)
    }

    @Test
    fun `wiki depth test`() {
        val actual = wikiTreeHead.nodesByDepth(0)

        assertEquals(mutableListOf("F"), actual[0])
        assertEquals(mutableListOf("B", "G"), actual[1])
        assertEquals(mutableListOf("A", "D", "I"), actual[2])
        assertEquals(mutableListOf("C", "E", "H"), actual[3])
    }

    @Test
    fun `wiki level order traversal test`() {
        val actual = wikiTreeHead.levelOrderTraversal()

        assertEquals(listOf("F", "B", "G", "A", "D", "I", "C", "E", "H"), actual)
    }

    @Test
    fun `simple unbalanced test`() {
        val head = BinaryNode(
                data = "A",
                left = BinaryNode(
                        data = "B",
                        left = BinaryNode("C")
                )
        )
        assertFalse(head.isBalanced)
    }

    @Test
    fun `simple balanced test`() {
        val head = BinaryNode(
                data = "A",
                left = BinaryNode("B"),
                right = BinaryNode("C")

        )
        assertTrue(head.isBalanced)
    }

    @Test
    fun `simple height test`() {
        val head = BinaryNode(
                data = "A",
                left = BinaryNode(
                        data = "B",
                        left = BinaryNode("C")
                )
        )
        assertEquals(3, head.height)
    }

    @Test
    fun `wiki height test`() {
        assertEquals(4, wikiTreeHead.height)
    }

    @Test
    fun `simple min test`() {
        val head = BinaryNode(
                data = 3,
                left = BinaryNode(2),
                right = BinaryNode(
                        data = 5,
                        left = BinaryNode(4),
                        right = BinaryNode(1)
                )
        )
        assertEquals(1, head.min)
    }

    @Test
    fun `simple max test`() {
        val head = BinaryNode(
                data = 3,
                left = BinaryNode(2),
                right = BinaryNode(
                        data = 5,
                        left = BinaryNode(4),
                        right = BinaryNode(1)
                )
        )
        assertEquals(5, head.max)
    }

    @Test
    fun `naive isBst test`() {
        val head = BinaryNode(
                data = 3,
                left = BinaryNode(
                        data = 2,
                        right = BinaryNode(5)
                )
        )
        assertFalse(head.isBst)
    }
}
