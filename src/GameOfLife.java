public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int lives = calculateLiveNeighbors(board, rows, cols, i, j);
                if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] >>= 1;
            }
        }

    }

    private int calculateLiveNeighbors(int[][] board, int rows, int cols, int i, int j) {
        int alive = 0;
        for (int k = Math.max(i - 1, 0); k <= Math.min(i + 1, rows - 1); k++) {
            for (int l = Math.max(j - 1, 0); l <= Math.min(j + 1, cols - 1); l++) {
                alive += board[k][l] & 1;
            }
        }
        alive -= board[i][j] & 1;
        return alive;
    }
}