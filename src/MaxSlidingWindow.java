import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> maxWindow = new ArrayDeque<>();

        for (int i = 0, ri = 0; i < nums.length; i++) {
            int num = nums[i];
            while (!maxWindow.isEmpty() && nums[maxWindow.peekLast()] <= num)
                maxWindow.removeLast();
            maxWindow.add(i);
            if (maxWindow.peekFirst() <= i - k) {
                maxWindow.removeFirst();
            }
            if (i >= k - 1) {
                result[ri++] = nums[maxWindow.peek()];
            }
        }
        return result;
    }
}