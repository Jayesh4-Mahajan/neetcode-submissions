class Solution {

    boolean[][] visit;
    boolean found;

    public boolean exist(char[][] board, String word) {
        int ROWS = board.length, COLS = board[0].length;
        found = false;
        visit = new boolean[ROWS][COLS];

        for (int r = 0; r<ROWS; r++) {
            for (int c = 0; c<COLS; c++ ) {
                backtrack(board, r, c, 0, word);
                if (found) {
                    return true;
                }
            }
        }

        return found;
    }

    public void backtrack(char[][] board, int r, int c, int idx, String word) {
        if (idx >= word.length()) {
            found = true;
            return;
        }
        int ROWS = board.length, COLS = board[0].length;
        if (r >= ROWS || c >= COLS || r < 0 || c <0 ||  visit[r][c]) {
            return;
        }
        
        if (board[r][c] == word.charAt(idx)) {
            visit[r][c] = true;
            backtrack(board, r + 1, c, idx+1, word);
            backtrack(board, r - 1, c, idx+1, word);
            backtrack(board, r, c + 1, idx+1, word);
            backtrack(board, r, c - 1, idx+1, word);
            visit[r][c] = false;
        }
    }
}
