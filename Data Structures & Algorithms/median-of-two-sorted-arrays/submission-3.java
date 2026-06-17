class Solution {
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     int[] nums = new int[nums1.length+nums2.length];
    //     int i = 0;
    //     int j = 0;
    //     int k = 0;
    //     while (i<nums1.length && j < nums2.length) {
    //         if (nums1[i] < nums2[j]) {
    //             nums[k] = nums1[i];
    //             i++;
    //         } else {
    //             nums[k] = nums2[j];
    //             j++;
    //         }
    //         k++;
    //     }
    //     while (i<nums1.length) {
    //         nums[k] = nums1[i];
    //         i++;
    //         k++;
    //     }
    //     while (j<nums2.length) {
    //         nums[k] = nums2[j];
    //         j++;
    //         k++;
    //     }
    //     if (nums.length % 2 == 0) {
    //         double res = nums[nums.length/2];
    //         res += nums[(nums.length/2) - 1];
    //         return res / (double) 2;
    //     }
    //     return nums[nums.length/2];
    // }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int half = (m + n + 1) / 2;
        int low = 0, high = m;
        while (low <= high) {
            int mid1 = low + (high-low)/2;
            int mid2 = half - mid1;
            int l1 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r2 = Integer.MAX_VALUE;
            if (mid1 < m) {
                r1 = nums1[mid1];
            }
            if (mid2 < n) {
                r2 = nums2[mid2];
            }
            if (mid1 - 1 >= 0) {
                l1 = nums1[mid1-1];
            }
            if (mid2 - 1 >= 0) {
                l2 = nums2[mid2-1];
            }
            if (l1 > r2) {
                high = mid1 - 1;
            } else if (l1 <= r2 && l2 <= r1) {
                if ((m+n)%2 == 0) {
                    return ((double) Math.max(l1, l2) + Math.min(r1, r2)) / (double) 2;
                } else {
                    return Math.max(l1, l2);
                }
            } else {
                low = mid1 + 1;
            }
        }

        return (double) 0;

    }
}
