class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Brute force approach
        // Let go over each windown
        int[] res = new int[nums.length - k + 1];
        for (int i=0; i<=nums.length - k; i++) {
            int maxNum = nums[i];
            for (int j = i; j<i+k; j++) {
                maxNum = Math.max(maxNum, nums[j]);
            }
            res[i] = maxNum;
        }
        return res;
    }
}
