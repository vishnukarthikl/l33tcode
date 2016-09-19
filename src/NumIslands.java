public class NumIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                char point = grid[i][j];
                if (point == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (grid[i][j] == '1') {
            grid[i][j] = 'x';
            if (i > 0) dfs(grid, i - 1, j);
            if (i < grid.length - 1) dfs(grid, i + 1, j);
            if (j > 0) dfs(grid, i, j - 1);
            if (j < grid[0].length - 1) dfs(grid, i, j + 1);
        }
    }
}