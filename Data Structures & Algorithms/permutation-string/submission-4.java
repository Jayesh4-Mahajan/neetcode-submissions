class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] counts1 = new int[26];
        int[] counts2 = new int[26];
        int len = s1.length();
        if (s1.length() > s2.length()) {
            return false;
        }
        for (int i = 0; i<len; i++) {
            counts1[s1.charAt(i) - 'a']++;
            counts2[s2.charAt(i) - 'a']++;
        }

        if (compareArray(counts1, counts2)) {
            return true;
        }
        if (s1.length() == s2.length()) {
            return false;
        }

        for (int i=len; i<s2.length(); i++) {
            counts2[s2.charAt(i-len) - 'a']--;
            counts2[s2.charAt(i) - 'a']++;
            if (compareArray(counts1, counts2)) {
                return true;
            }
        }
        return false;
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
