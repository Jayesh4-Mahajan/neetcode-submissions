class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char ch: tasks) {
            freq[ch - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int cnt: freq) {
            if (cnt > 0) {
                maxHeap.add(cnt);
            }
        }
        Deque<Pair> deq = new ArrayDeque<>();
        int time = 0;

        while (!maxHeap.isEmpty() || !deq.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int cnt = maxHeap.poll() - 1;
                if (cnt > 0) {
                    Pair p = new Pair(cnt, time+n);
                    deq.add(p);
                }
            }
            
            if (!deq.isEmpty() && deq.peek().wait == time) {
                maxHeap.add(deq.poll().val);
            }
        }

        return time;

    }

}

class Pair {
    int val;
    int wait;

    Pair(int x, int y) {
        val = x;
        wait = y;
    }
}
