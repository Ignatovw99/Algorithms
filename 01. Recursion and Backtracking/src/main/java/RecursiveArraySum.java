public class RecursiveArraySum {

    public static int sum(int[] arr, int index) {
        if (index > arr.length - 1) {
            return 0;
        }
        return arr[index] + sum(arr, index + 1);
    }
}
