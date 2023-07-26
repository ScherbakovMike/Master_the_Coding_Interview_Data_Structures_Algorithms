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

    public static void main(String[] args) {
        var nums = new int[]{5, 4, -1, 7, 8};
        System.out.println(maxSubArrayNaive(nums));
    }
}
