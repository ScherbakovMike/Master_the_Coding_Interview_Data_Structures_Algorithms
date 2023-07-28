class Solution(object):
    def move_zeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        non_zero_position = 0
        for n in nums:
            if n != 0:
                nums[non_zero_position] = n
                non_zero_position += 1
        while non_zero_position < len(nums):
            nums[non_zero_position] = 0
            non_zero_position += 1
        print(nums)


nums = [1, 0, 3, 0, 0, 5, 8, 9, 0]
Solution().move_zeroes(nums)
