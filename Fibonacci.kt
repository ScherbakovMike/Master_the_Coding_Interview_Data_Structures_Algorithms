fun fibonacciIterative(n: Int): List<Int> {
    val result = arrayListOf<Int>()
    var count = 2
    var prev1 = 0
    var prev2 = 1
    result.add(prev1)
    result.add(prev2)
    while (count < n) {
        val cur = prev1 + prev2
        prev1 = prev2
        prev2 = cur
        result.add(cur)
        count++
    }
    return result
}

fun fibonacciRecursive(n: Int): Int {
    if (n <= 1) return n
    return fibonacciRecursive(n - 2) + fibonacciRecursive(n - 1)

}

fun main() {
    println(fibonacciIterative(400))
    println(fibonacciRecursive(40))
}