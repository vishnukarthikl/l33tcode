import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            numberIndex.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (numberIndex.containsKey(other)) {
                return new int[]{i, other};
            }
        }
        return new int[2];
    }

}
