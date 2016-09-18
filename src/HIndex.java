import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int max = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            int citation = citations[i];
            if (citations.length - i <= citation) {
                max = Math.max(max, citations.length - i);
            }
        }
        return max;
    }
}