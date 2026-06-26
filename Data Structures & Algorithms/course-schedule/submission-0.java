class Solution {

    Map<Integer, List<Integer>> adj = new HashMap<>();
    private Set<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i=0; i<numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] prereq: prerequisites) {
            adj.get(prereq[0]).add(prereq[1]);
        }

        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course) {
        if (visiting.contains(course)) {
            return false;
        }
        if (adj.get(course).isEmpty()) {
            return true;
        }

        visiting.add(course);
        for (int pre: adj.get(course)) {
            if (!dfs(pre)) {
                return false;
            }
        }
        visiting.remove(course);
        adj.put(course, new ArrayList<>());
        return true;
    }
}
