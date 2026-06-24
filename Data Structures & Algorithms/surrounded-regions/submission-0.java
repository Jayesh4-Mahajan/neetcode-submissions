class Solution {
    int ROWS, COLS;
    int[][] directions;
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;
        directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i=0; i<ROWS; i++) {
            dfs(i, 0, board);
            dfs(i, COLS-1, board);
        }

        for (int j = 0;j<COLS; j++) {
            dfs(0, j, board);
            dfs(ROWS-1, j, board);
        }
        
        for (int i=0; i < ROWS; i++) {
            for (int j=0; j<COLS; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        return;
    }

    private void dfs(int r, int c, char[][] board) {
        if (r < 0 || c < 0) return;
        if (r >= board.length || c >= board[0].length) return;
        if (board[r][c] == '#' || board[r][c] == 'X') return;
        board[r][c] = '#';
        for (int[] dir: directions) {
            int nr = r + dir[0], nc = c + dir[1];
            dfs(nr, nc, board);
        }
    }
}
