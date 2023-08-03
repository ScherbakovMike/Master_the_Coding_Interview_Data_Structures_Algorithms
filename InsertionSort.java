import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] nums) {
        int i = 1;
        while (i < nums.length) {
            int j = i;
            while (j >= 1 && (nums[j] < nums[j - 1])) {
                var buf = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = buf;
                j--;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        var nums = new int[]{10, 9, 1, 2, 3, 4, 5, 6, 1};
        System.out.println(Arrays.toString(nums));
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
