import java.util.LinkedList

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class IsValidBST {
    private fun findMin(node: TreeNode): Int {
        var min = node.`val`
        val queue = LinkedList<TreeNode?>()
        queue.add(node)
        while (queue.isNotEmpty()) {
            val curNode = queue.poll()
            if (curNode!!.`val` < min) {
                min = curNode.`val`
            }
            curNode.left?.let { queue.add(it) }
            curNode.right?.let { queue.add(it) }
        }
        return min
    }

    private fun findMax(node: TreeNode): Int {
        var max = node.`val`
        val queue = LinkedList<TreeNode?>()
        queue.add(node)
        while (queue.isNotEmpty()) {
            val curNode = queue.poll()
            if (curNode!!.`val` > max) {
                max = curNode.`val`
            }
            if(curNode.left!=null){
                queue.add(curNode.left)
            }
            if(curNode.right!=null){
                queue.add(curNode.right)
            }
        }
        return max
    }

    fun isValidBST(node: TreeNode?): Boolean {
        if (node?.left != null && node.left!!.`val` >= node.`val`) {
            return false;
        }
        if (node?.right != null && node.right!!.`val` <= node.`val`) {
            return false;
        }

        val isLeftValid = if (node?.left != null) {
            val maxInLeft = findMax(node.left!!)
            if (maxInLeft >= node.`val`) {
                false
            } else {
                isValidBST(node.left)
            }
        } else true

        val isRightValid = if (node?.right != null) {
            val minInRight = findMin(node.right!!)
            if (minInRight <= node.`val`) {
                false
            } else {
                isValidBST(node.right)
            }
        } else true
        return isLeftValid && isRightValid
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val testNode = TreeNode(5)
    testNode.left = TreeNode(4)
    testNode.right = TreeNode(6)
    testNode.right!!.left = TreeNode(3)
    testNode.right!!.right = TreeNode(7)
    val isValidBST = IsValidBST()
    println(isValidBST.isValidBST(testNode))
}