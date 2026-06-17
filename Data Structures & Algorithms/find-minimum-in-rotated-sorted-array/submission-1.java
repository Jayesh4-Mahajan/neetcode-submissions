class Solution {
    public int findMin(int[] nums) {
        // O(n) single pass solution first
        int minNum = nums[0];
        for (int num: nums) {
            minNum = Math.min(num, minNum);
        }
        return minNum;
    }
}
