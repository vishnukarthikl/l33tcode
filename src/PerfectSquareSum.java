public class PerfectSquareSum {
    public int numSquares(int n) {
        int[] sums = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            if (isPerfectSquare(i)) {
                sums[i] = 1;
            } else {
                int ans = Integer.MAX_VALUE;
                for (int j = 1; j * j < i; j++) {
                    ans = Math.min(ans, sums[i - (j * j)] + sums[j * j]);
                }
                sums[i] = ans;
            }
        }
        return sums[n];
    }

    private boolean isPerfectSquare(int input) {
        long closestRoot = (long) Math.sqrt(input);
        return input == closestRoot * closestRoot;
    }
}