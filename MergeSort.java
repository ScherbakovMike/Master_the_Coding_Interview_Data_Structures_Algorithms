import java.util.Arrays;

public class MergeSort {

    private static void mergeSort(int[] array) {
        var length = array.length;
        if (length == 1) {
            return;
        }
        var leftArray = Arrays.copyOfRange(array, 0, length / 2);
        var rightArray = Arrays.copyOfRange(array, length / 2, length);
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array) {
        var i = 0;
        var l = 0;
        var r = 0;
        while (l < leftArray.length && r < rightArray.length) {
            if (leftArray[l] < rightArray[r]) {
                array[i++] = leftArray[l++];
            } else {
                array[i++] = rightArray[r++];
            }
        }
        while (l < leftArray.length) {
            array[i++] = leftArray[l++];
        }
        while (r < rightArray.length) {
            array[i++] = rightArray[r++];
        }
    }

    public static void main(String[] args) {
        var array = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
