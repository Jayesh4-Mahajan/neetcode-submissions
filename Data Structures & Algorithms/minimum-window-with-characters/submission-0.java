class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        if (s.length() < t.length()) {
            return res;
        }

        Map<Character, Integer> countT = new HashMap<>();
        for (char c: t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int required = countT.size();
        int left = 0, right = 0;
        int matches = 0;
        Map<Character, Integer> currCount = new HashMap<>();
        while (right<s.length()) {
            char c = s.charAt(right);
            currCount.put(c, currCount.getOrDefault(c, 0) + 1);

            if (countT.containsKey(c) && 
                currCount.get(c) == countT.get(c)) {
                    matches++;
            }

            while (left <= right && matches == required) {
                c = s.charAt(left);
                if (res == "" || res.length() > right - left + 1) {
                    res = s.substring(left, right+1);
                }
                currCount.put(c, currCount.get(c) - 1);
                if (countT.containsKey(c) && currCount.get(c) < countT.get(c)) {
                    matches--;
                }
                left++;
            }
            right++;


        }
        if (res.length() > right - left + 1) {
                    res = s.substring(left, right+1);
                }
        return res;
    }
}
