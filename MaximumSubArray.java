public class MaximumSubArray {
    public static int maxSubArrayNaive(int[] nums) {
        var max = Integer.MIN_VALUE;
        for (int left = 0; left < nums.length; left++) {
            for (int right = 0; right < nums.length; right++) {
                if (left > right) {
                    continue;
                }
                var sum = 0;
                for (int k = left; k <= right; k++) {
                    sum += nums[k];
                }
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public static int maxSubArrayLinear(int[] nums) {
        var result = Integer.MIN_VALUE;
        var curSum = 0;
        for (var n : nums) {
            curSum = curSum + n;
            if (curSum > result)
                result = curSum;
            if (curSum < 0)
                curSum = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        //var nums = new int[]{5, 4, -1, 7, 8};
        var nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //var nums = new int[]{-2, 1};
        //var nums = new int[]{-2, -1};
        //var nums = new int[]{-1, -2};
        System.out.println(maxSubArrayNaive(nums));
        System.out.println(maxSubArrayLinear(nums));
    }
}
