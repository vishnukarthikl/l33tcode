public class LongestPalindrome {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        String longestPalindrome = "";
        for (int i = 0; i < chars.length; i++) {
            String palindrome = expandPalindrome(chars, i);
            if (longestPalindrome.length() < palindrome.length()) {
                longestPalindrome = palindrome;
            }
        }
        return longestPalindrome;
    }

    private String expandPalindrome(char[] chars, int start) {
        int j;
        for (j = 0; j < chars.length; j++) {
            int leftIndex = start - j;
            int rightIndex = start + j;
            if (isValid(chars, leftIndex, rightIndex)) {
                break;
            }
        }
        String oddPalindrome = (new String(chars)).substring(start - j + 1, start + j);
        int i;
        for (i = 1; i < chars.length; i++) {
            int leftIndex = start - i + 1;
            int rightIndex = start + i;
            if (isValid(chars, leftIndex, rightIndex)) {
                break;
            }
        }
        String evenPalindrome = (new String(chars)).substring(start - i + 2, start + i);
        return oddPalindrome.length() > evenPalindrome.length() ? oddPalindrome : evenPalindrome;
    }

    private boolean isValid(char[] chars, int leftIndex, int rightIndex) {
        return leftIndex < 0 || rightIndex >= chars.length || chars[leftIndex] != chars[rightIndex];
    }
}
