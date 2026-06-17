class Solution {
    public int findMin(int[] nums) {
        // O(n) single pass solution first
        // int minNum = nums[0];
        // for (int num: nums) {
        //     minNum = Math.min(num, minNum);
        // }
        // return minNum;

        // O(log(n)) solution use binary search to find the point of rotation
        int l = 0, r = nums.length-1;
        while (l < r) {
            // base case array is sorted from left to right
            if (nums[l] < nums[r]) {
                return nums[l];
            }

            int mid = l + (r-l)/2;
            if (nums[mid] <= nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
