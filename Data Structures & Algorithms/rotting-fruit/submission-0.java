class Solution {
    public int orangesRotting(int[][] grid) {
        // First find count of fresh bananas
        // Second find all rotten bananas and place them in a queue for
        // multi-source BFS, each minute we check for all rotten bananas in the queue
        // once the queue is empty is fresh bananas count is greater than 0 return -1 
        // else the number of minutes passed.

        int ROWS = grid.length, COLS = grid[0].length;
        int fresh = 0;
        int minutes = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i=0; i<ROWS; i++) {
            for (int j=0; j<COLS; j++) {
                if (grid[i][j] == 1) fresh++;
                else if (grid[i][j] == 2) {
                    int[] pair = {i, j};
                    queue.offer(pair);
                }
            }
        }

        // Directions we can move in from rotten banana
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        // Step 2 Multi source BFS
        while (!queue.isEmpty()) {
            if (fresh == 0) return minutes;
            int size = queue.size();
            for (int i = 0; i<size; i++) {
                int[] point = queue.poll();
                int r = point[0], c = point[1];
                for (int[] dir: dirs) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr >= 0 && nc >= 0 && nr < ROWS && nc < COLS && grid[nr][nc] == 1) {
                        fresh--;
                        grid[nr][nc] = 2;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
            minutes++;
        }
        return fresh > 0 ? -1 : minutes;
    }
}
