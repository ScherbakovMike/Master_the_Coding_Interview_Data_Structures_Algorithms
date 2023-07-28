class ContainsDuplicate {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = HashSet<Int>()
        nums.forEach {
            if (set.contains(it)) {
                return true
            }
            set.add(it)
        }
        return false
    }
}

fun main() {
    val nums = intArrayOf(1, 2, 3, 4, 5, 6, 6)
    println(ContainsDuplicate().containsDuplicate(nums))
}