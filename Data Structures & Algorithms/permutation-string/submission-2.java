class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] counts = new int[26];
        int len = s1.length();
        for (int i = 0; i<len; i++) {
            counts[s1.charAt(i) - 'a']++;
        }

        for (int i=0; i<=s2.length()-s1.length(); i++) {
            int[] c = new int[26];
            for (int j=i; j<i+s1.length(); j++) {
                c[s2.charAt(j) - 'a']++;
            }
            if (compareArray(counts, c)) {
                return true;
            }
        }
        return false;

        // Set<Character> seen = new HashSet<>();
        // int[] count = new int[26];
        // int len = s1.length();
        // for (int i = 0; i<len; i++) {
        //     count[s1.charAt(i) - 'a']++;
        //     seen.add(s1.charAt(i));
        // }

        // int l = 0;
        // for (int r = 0; r<s2.length(); r++) {
        //     int idx = s2.charAt(r) - 'a';
        //     if (count[idx] > 0) {
        //         count[idx]--;
        //         if ((r-l+1) == len) {
        //             return true;
        //         }
        //     } else {
        //         while (l<=r) {
        //             if (seen.contains(s2.charAt(l))) {
        //                 count[s2.charAt(l) - 'a']++;
        //             }
        //             l++;
        //         }
        //     }
        // }
        // return false;
    }

    public boolean compareArray(int[] nums1, int[] nums2) {
        for (int i = 0; i<nums1.length; i++) {
            if (nums1[i] != nums2[i]) {
                return false;
            }
        }
        return true;
    }
}
