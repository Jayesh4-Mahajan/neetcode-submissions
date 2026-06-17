class Solution {

    class Pair {
        int idx;
        int height;

        public Pair(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }

        public int getIdx() {
            return this.idx;
        }

        public int getHeight() {
            return this.height;
        }

        public void setIdx(int val) {
            this.idx = val;
        }

    }

    public int largestRectangleArea(int[] heights) {
        Stack<Pair> stack = new Stack<>();
        int res = heights[0];

        for (int i=0; i<heights.length; i++) {
            Pair p = new Pair(i, heights[i]);
            Pair topPair = p;
            while (!stack.isEmpty() && stack.peek().height > p.height) {
                topPair = stack.pop();
                int area = (p.idx - topPair.idx) * topPair.height;
                res = Math.max(res, area);
            }
            p.setIdx(topPair.getIdx());
            stack.push(p);
        }

        while (!stack.isEmpty()) {
            Pair topPair = stack.pop();
            int area = (heights.length - topPair.idx) * topPair.height;
            res = Math.max(res, area);
        }

        return res;
    }
}
