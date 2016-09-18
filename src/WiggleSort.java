import java.util.Arrays;

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        //todo no need to sort, use the lesser and greater property to swap
        int[] sorted = Arrays.stream(nums).sorted().toArray();
        int j = 0;
        for (int i = 0; i < sorted.length / 2; i++) {
            nums[j++] = sorted[i];
            nums[j++] = sorted[sorted.length - i - 1];
        }
        if (j == nums.length - 1) {
            nums[j] = sorted[sorted.length / 2];
        }
    }
}