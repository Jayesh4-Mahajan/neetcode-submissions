class Solution {
    private List<List<String>> res = new ArrayList<>();
    private List<String> part = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(0, 0, s);
        return res;
    }

    public void dfs(int j, int i, String s) {
        if (i >= s.length()) {
            if (i == j) {
                res.add(new ArrayList<>(part));
            }
            return;
        }

        if (isPali(s.substring(j, i+1))) {
            part.add(s.substring(j, i+1));
            dfs(i+1, i+1, s);
            part.remove(part.size()-1);
        }

        dfs(j, i+1, s);
    }

    public boolean isPali(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
