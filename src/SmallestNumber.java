// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class SmallestNumber {
    public int solution(int X) {
        int min = Integer.MAX_VALUE;
        String str = String.valueOf(X);
        char[] digits = str.toCharArray();
        for (int i = 0; i < digits.length - 1; i++) {
            int digit1 = digits[i] - '0';
            int digit2 = digits[i + 1] - '0';
            int max = Math.max(digit1, digit2);
            Integer changed = Integer.valueOf(String.format("%s%d%s", str.substring(0, i), max, str.substring(i + 2)));
            min = Math.min(changed, min);
        }
        return min;
    }
}