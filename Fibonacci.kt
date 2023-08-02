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

fun fibonacciRecursive(n: Int, prev1: Int = 0, prev2: Int = 1) {
    if (n == 2) {
        return
    }
    if (prev1 == 0 && prev2 == 1) {
        print("${prev1}, ${prev2}")
    }
    val cur = prev1 + prev2
    print(", ${cur}")
    fibonacciRecursive(n - 1, prev2, cur)
}

fun main() {
    println(fibonacciIterative(10))
    fibonacciRecursive(10)
}