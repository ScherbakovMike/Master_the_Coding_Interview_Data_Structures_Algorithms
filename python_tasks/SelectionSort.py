def selection_sort(nums):
    for i in range(0, len(nums) - 1):
        min = i
        for j in range(i + 1, len(nums)):
            if nums[j] < nums[min]:
                min = j
        if min != i:
            buf = nums[min]
            nums[min] = nums[i]
            nums[i] = buf


array: list = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
print(array)
selection_sort(array)
print(array)