class Solution {

    public class Pair {
        public int num;
        public int idx;

        public Pair(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        public int getNum() {
            return this.num;
        }

        public int getIdx() {
            return this.idx;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        // Hints mention using heaps, which is fine
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.getNum() - a.getNum());
        for (int i=0; i<k-1; i++) {
            maxHeap.add(new Pair(nums[i], i));
        }
        int l = 0, r = k-1;
        for (int i = 0; i<nums.length - k + 1; i++) {
            maxHeap.add(new Pair(nums[r], r));
            while (true) {
                Pair top = maxHeap.peek();
                if (top.getIdx() >= l && top.getIdx() <= r) {
                    res[i] = top.getNum();
                    break;
                } else {
                    maxHeap.poll();
                }
            }
            l++;
            r++;
        }
        return res;
    }
}
