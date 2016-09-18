public class BalancedArray {
    static int isArray_Balanced(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }
        int[] cumulativeLeft = new int[arr.length];
        int[] cumulativeRight = new int[arr.length];
        cumulativeLeft[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            cumulativeLeft[i] = cumulativeLeft[i - 1] + arr[i];
        }
        cumulativeRight[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            cumulativeRight[i] = cumulativeRight[i + 1] + arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            if (cumulativeLeft[i] == cumulativeRight[i]) {
                return i;
            }
        }
        return -1;
    }
}
