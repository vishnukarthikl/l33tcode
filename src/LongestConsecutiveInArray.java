import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveInArray {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> values = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            values.put(num, 1);
        }
        for (int num : nums) {
            int i = num + 1;
            while (values.containsKey(i) && values.get(i) == 1) {
                i++;
            }
            if (values.containsKey(i) && values.get(i) != 1) {
                i += values.get(i);
            }
            values.put(num, i - num);
            max = Math.max(values.get(num), max);
        }
        return max;
    }
}