class Solution {
    
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        Queue<int[]> pacQ = new LinkedList<>();
        Queue<int[]> atlQ = new LinkedList<>();

        for (int i = 0; i < ROWS; i++) {
            pacQ.add(new int[]{i, 0});
            atlQ.add(new int[]{i, COLS - 1});
        }
        for (int j = 0; j < COLS; j++) {
            pacQ.add(new int[]{0, j});
            atlQ.add(new int[]{ROWS-1, j});
        }

        bfs(pacQ, pac, heights);
        bfs(atlQ, atl, heights);

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private void bfs(Queue<int[]> q, boolean[][] ocean, int[][] heights) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            ocean[r][c] = true;
            for (int[] d: directions) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length && !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}
