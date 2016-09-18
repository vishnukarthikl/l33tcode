public class SprialMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int[][] offset = new int[][]{
                {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        int[] lengths = new int[]{n, n - 1};
        int i = 1;
        int direction = 0;
        int r = 0;
        int c = -1;
        while (i <= n * n) {
            for (int j = 0; j < lengths[direction % 2]; j++) {
                r += offset[direction][0];
                c += offset[direction][1];
                matrix[r][c] = i++;
            }
            lengths[direction % 2]--;
            direction = (direction + 1) % 4;
        }
        return matrix;
    }
}