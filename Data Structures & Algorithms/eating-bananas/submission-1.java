class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = piles[0];
        for (int pile: piles) {
            max = Math.max(max, pile);
        }

        int res = max;
        while (min <= max) {
            int mid = min + (max-min) / 2;
            int time = calculateTime(piles, mid);
            if (time > h) {
                min = mid + 1;
            } else {
                res = Math.min(mid, res);
                max = mid - 1;
            }
        }
        return res;

    }

    public int calculateTime(int[] piles, int rate) {
        int time = 0;
        for (int pile: piles) {
            if (pile % rate != 0) {
                time += 1;
            }
            time += pile / rate;
        }

        return time;
    }

}
