/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotatePopAndShift = function (nums, k) {
    if (nums === undefined || k === undefined || nums.length === 0) {
        return
    }
    k = k % nums.length;
    for (let i = 0; i < k; i++) {
        nums.unshift(nums.pop())
    }
    console.log(nums)
};

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotateNewArray = function (nums, k) {
    if (nums === undefined || k === undefined || nums.length === 0) {
        return
    }
    k = k % nums.length;
    newArr = []
    for (let i = 0; i < nums.length; i++) {
        if (i < k) {
            newArr[i] = nums[nums.length - k + i]
        } else {
            newArr[i] = nums[i - k]
        }
    }
    newArr.forEach((value, index) => nums[index] = value)
    console.log(nums)
};

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotateReversing = function (nums, k) {
    if (nums === undefined || k === undefined || nums.length === 0) {
        return
    }
    k = k % nums.length;
    for (let i = 0; i < nums.length / 2; i++) {
        swap(nums, i, nums.length - i - 1)
    }
    for (let i = 0; i < k / 2; i++) {
        swap(nums, i, k - i - 1)
    }
    for (let i = k; i < (k + (nums.length - k) / 2); i++) {
        swap(nums, i, nums.length - i + k - 1)
    }
    console.log(nums)
};

function swap(nums, index1, index2) {
    buf = nums[index1]
    nums[index1] = nums[index2]
    nums[index2] = buf
}

//console.log(rotatePopAndShift([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11], 3))
//console.log(rotateNewArray([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11], 3))
console.log(rotateReversing([1, 2, 3, 4, 5, 6, 7], 3))
//console.log(rotate())