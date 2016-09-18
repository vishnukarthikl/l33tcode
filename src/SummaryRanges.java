import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = i;
            while (i + 1 < nums.length && nums[i] == nums[i + 1] - 1) {
                i++;
            }
            result.add(makeRange(start, i, nums));
        }
        return result;
    }

    private String makeRange(int start, int end, int[] nums) {
        if (start == end) {
            return String.valueOf(nums[start]);
        } else {
            return nums[start] + "->" + nums[end];
        }
    }
}