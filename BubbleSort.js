/**
 * @param {number[]} nums
 * @return {number[]}
 */
function bubbleSort(nums) {
    let arrayChanged = false
    let firstTime = true
    for (let i = 0; i < nums.length; i++) {
        if (firstTime || !arrayChanged) {
            firstTime = false
            arrayChanged = false
            for (let j = 1; j < nums.length; j++) {
                if (nums[j] < nums[j - 1]) {
                    buf = nums[j]
                    nums[j] = nums[j - 1]
                    nums[j - 1] = buf;
                    arrayChanged = true
                }
            }
        }
    }
}

function print(nums) {
    nums.forEach(value => console.log(value))
}

const array = Array.from(Array(10000).keys(),
    (item) => Math.round(Math.random() * (100 - 1)) + 1);
const arrayCopy = Array.from(array)
//print(array)

console.time("Bubble sort improved")
console.log(bubbleSort(array));
console.timeEnd("Bubble sort improved")
//print(array)
