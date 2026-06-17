class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if (grid == null || grid.length == 0) return;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            for (int[] dir: dirs) {
                int nr = r + dir[0], nc = c + dir[1];

                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length) {
                    if (grid[nr][nc] == 2147483647) {
                        grid[nr][nc] = grid[r][c] + 1;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
    }

}
