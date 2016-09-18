import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> substringChars = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int currentMax = 0;
            for (int j = i; j < s.length(); j++) {
                if (!substringChars.contains(chars[j])) {
                    currentMax += 1;
                    substringChars.add(chars[j]);
                } else {
                    break;
                }
            }
            if (currentMax > max) {
                max = currentMax;
            }
            substringChars.clear();
        }
        return max;
    }
}
