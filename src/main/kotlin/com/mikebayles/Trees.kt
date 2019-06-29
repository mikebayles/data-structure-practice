package com.mikebayles

fun inOrderTraversal(result: MutableList<String>, head: BinaryNode) {
    if (head.left != null) {
        inOrderTraversal(result, head.left)
    }

    result.add(head.data)

    if (head.right != null) {
        inOrderTraversal(result, head.right)
    }
}


fun preOrderTraversal(result: MutableList<String>, head: BinaryNode) {
    result.add(head.data)

    if (head.left != null) {
        preOrderTraversal(result, head.left)
    }

    if (head.right != null) {
        preOrderTraversal(result, head.right)
    }
}

fun postOrderTraversal(result: MutableList<String>, head: BinaryNode) {
    if (head.left != null) {
        postOrderTraversal(result, head.left)
    }

    if (head.right != null) {
        postOrderTraversal(result, head.right)
    }

    result.add(head.data)
}