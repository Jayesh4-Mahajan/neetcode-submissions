class Solution {
    public int numIslands(char[][] grid) {
        Set<List<Integer>> visited = new HashSet<>();
        int res = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0' || visited.contains(Arrays.asList(i, j))) {
                    continue;
                }
                res++;
                search(i, j, grid, visited);
            }
        }
        return res;
    }

    private void search(int i, int j, char[][] grid, Set<List<Integer>> visited) {
        List<Integer> point = Arrays.asList(i, j);
        if (visited.contains(point)) {
            return;
        }
        Stack<List<Integer>> stack = new Stack<>();
        stack.push(point);
        while (!stack.isEmpty()) {
            point = stack.pop();
            if (visited.contains(point)) {
                continue;
            }
            visited.add(point);
            int r = point.get(0);
            int c = point.get(1);
            if (r + 1 < grid.length && grid[r + 1][c] == '1') {
                stack.push(Arrays.asList(r+1, c));
            }
            if (r - 1 >= 0 && grid[r-1][c] == '1') {
                stack.push(Arrays.asList(r-1, c));
            }
            if (c - 1 >= 0 && grid[r][c-1] == '1') {
                stack.push(Arrays.asList(r, c-1));
            }
            if (c + 1 < grid[0].length && grid[r][c+1] == '1') {
                stack.push(Arrays.asList(r, c+1));
            }
        }
    }
}
