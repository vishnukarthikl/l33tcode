import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> nums = new ArrayList<>();
        if (matrix.length == 0) {
            return nums;
        }
        int[][] offset = new int[][]{
                {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        int[] lengths = new int[]{matrix[0].length, matrix.length - 1};
        int direction = 0;
        int rOffset = 0;
        int cOffset = -1;
        while (lengths[direction % 2] != 0) {
            for (int i = 0; i < lengths[direction % 2]; i++) {
                rOffset += offset[direction][0];
                cOffset += offset[direction][1];
                nums.add(matrix[rOffset][cOffset]);
            }
            lengths[direction % 2]--;
            direction = (direction + 1) % 4;
        }

        return nums;
    }
}