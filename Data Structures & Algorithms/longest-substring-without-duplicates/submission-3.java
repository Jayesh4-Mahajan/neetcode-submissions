class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int l = 0, r = 0, res = 0;
        while (r < s.length()) {
            Character ch = s.charAt(r);
            // We found a duplicate
            if (seen.contains(ch)) {
                res = Math.max(seen.size(), res);
                // Now we slide l till we cross the repeating character
                while (s.charAt(l) != ch) {
                    seen.remove(s.charAt(l));
                    l++;
                }
                seen.remove(ch);
                l++;
            } else {
                seen.add(ch);
                r++;
            }
        }

        return Math.max(res, seen.size());
    }
}
