public class FindPeak {
    public int findPeakElement(int[] nums) {
        //todo:log(n)
        for (int i = 0; i < nums.length; i++) {
            int prev;
            int next;
            prev = i - 1 < 0 ? Integer.MIN_VALUE : nums[i - 1];
            next = i + 1 >= nums.length ? Integer.MIN_VALUE : nums[i + 1];

            if (nums[i] >= prev && nums[i] >= next) {
                return i;
            }
        }
        return -1;
    }
}