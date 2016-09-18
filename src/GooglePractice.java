class GooglePractice {
    public int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        long[] cumulative = new long[A.length];
        long[] reverseCumulative = new long[A.length];
        cumulative[0] = A[0];
        reverseCumulative[A.length - 1] = A[A.length - 1];
        for (int i = 1; i < A.length; i++) {
            int lastIndex = A.length - 1;
            cumulative[i] = cumulative[i - 1] + A[i];
            reverseCumulative[lastIndex - i] = reverseCumulative[lastIndex - i + 1] + A[lastIndex - i];
        }
        for (int i = 0; i < A.length; i++) {
            if (cumulative[i] == reverseCumulative[i]) {
                return i;
            }
        }
        if (cumulative[A.length - 1] == 0) {
            return 0;
        }
        return -1;
    }
}