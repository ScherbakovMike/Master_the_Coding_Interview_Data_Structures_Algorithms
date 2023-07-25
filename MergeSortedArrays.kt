fun main() {
    mergeArrays(arrayOf(1, 2, 3, 4, 5, 6, 7), arrayOf(4, 5, 6, 7, 8, 9, 10))
            .forEach { println(it) }

    mergeArrays(arrayOf(1, 2, 3, 4, 5, 6, 7), arrayOf())
            .forEach { println(it) }
}

fun mergeArrays(array1: Array<Int>, array2: Array<Int>): Array<Int> {
    if (array1.isEmpty()) {
        return array2
    }
    if (array2.isEmpty()) {
        return array1
    }
    var left = 0
    var right = 0
    var pos = 0
    val lengthResult = array1.size + array2.size
    val result = Array(lengthResult) { 0 }
    while (pos < lengthResult) {
        if (left == array1.size) {
            result[pos] = array2[right]
            right++
        } else if (right == array2.size) {
            result[pos] = array1[left]
            left++
        } else {
            if (array1[left] <= array2[right]) {
                result[pos] = array1[left]
                left++
            } else {
                result[pos] = array2[right]
                right++
            }
        }
        pos++
    }
    return result
}