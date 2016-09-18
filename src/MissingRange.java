import java.util.ArrayList;
import java.util.List;

public class MissingRange {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            if (lower == upper)
                result.add(String.valueOf(lower));
            else
                result.add(lower + "->" + upper);
            return result;
        }
        String range;
        range = expandRangeLeft(lower, nums[0]);
        if (!range.isEmpty())
            result.add(range);
        for (int i = 0; i < nums.length - 1; i++) {
            range = expandRange(nums[i], nums[i + 1]);
            if (!range.isEmpty())
                result.add(range);
        }
        range = expandRangeRight(nums[nums.length - 1], upper);
        if (!range.isEmpty())
            result.add(range);
        return result;
    }

    private String expandRangeRight(int num, int upper) {
        if (upper - num == 1) {
            return String.valueOf(upper);
        } else if (upper - num > 1) {
            return (num + 1) + "->" + upper;
        } else {
            return "";
        }
    }

    private String expandRangeLeft(int lower, int num) {
        if (num - lower == 1) {
            return String.valueOf(lower);
        } else if (num - lower > 1) {
            return lower + "->" + (num - 1);
        } else {
            return "";
        }
    }

    private String expandRange(int left, int right) {
        if (right - left > 2)
            return (left + 1) + "->" + (right - 1);
        else if (right - left == 2)
            return String.valueOf(right - 1);
        else
            return "";
    }

}
