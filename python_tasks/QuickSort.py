def quick_sort(array, left, right):
    if right <= left:
        return
    pivot = array[right]
    i = left
    for j in range(left, right):
        if array[j] < pivot:
            buf = array[i]
            array[i] = array[j]
            array[j] = buf
            i += 1
    buf = array[right]
    array[right] = array[i]
    array[i] = buf

    quick_sort(array, left, i-1)
    quick_sort(array, i+1, right)


array = [9, 88, 7, 6, 99, 4, 3, 2, 10, 0]
print(array)
quick_sort(array, 0, len(array) - 1)
print(array)
