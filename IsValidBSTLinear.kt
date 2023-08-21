import kotlin.math.max
import kotlin.math.min

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
class IsValidBSTLinear {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun isValidBST(node: TreeNode?): Boolean {
        fun isBST(node: TreeNode?, min: Int?, max: Int?, testLeft: Boolean, testRight: Boolean): Boolean {
            val leftValid = if (testLeft && node?.left != null) {
                if (node.left?.`val`!! >= min ?: Int.MAX_VALUE) {
                    false
                } else {
                    isBST(node.left, min(min ?: Int.MAX_VALUE, node.`val`), max, true, false)
                }
            } else true
            val rightValid = if (testRight && node?.right != null) {
                if (node.right?.`val`!! <= max ?: Int.MIN_VALUE) {
                    false
                } else {
                    isBST(node.right, min, max(max ?: Int.MIN_VALUE, node.`val`), false, true)
                }
            } else true
            return leftValid && rightValid
        }

        return isBST(node, null, null, true, true)
    }
}


fun main() {
    val testNode = IsValidBSTLinear.TreeNode(5)
    testNode.left = IsValidBSTLinear.TreeNode(1)
    testNode.right = IsValidBSTLinear.TreeNode(4)
    testNode.right!!.left = IsValidBSTLinear.TreeNode(3)
    testNode.right!!.right = IsValidBSTLinear.TreeNode(6)
    val isValidBST = IsValidBSTLinear()
    println(isValidBST.isValidBST(testNode))
}