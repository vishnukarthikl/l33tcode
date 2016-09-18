public class LongestKSubstring {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int distinctCharacters = 0;
        int longestLength = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]++ == 0) distinctCharacters++;

            if (distinctCharacters > k) {
                while (--count[s.charAt(j++)] > 0) ;
                distinctCharacters--;
            }
            longestLength = Math.max(longestLength, i - j + 1);
        }
        return longestLength;
    }

}