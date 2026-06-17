class Solution {
    private List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        backtrack(n, 0, 0, new ArrayList<>());
        return res;
    }

    public void backtrack(int n, int curr, int back, List<String> subset) {
        if (curr >= n && back >= n) {
            res.add(String.join("", subset));
            return;
        }

        if (curr < n) {
            curr++;
            subset.add("(");
            backtrack(n, curr, back, subset);
            subset.remove(subset.size()-1);
            curr--;
        }
        if (back < n && back < curr) {
            back++;
            subset.add(")");
            backtrack(n, curr, back, subset);
            subset.remove(subset.size()-1);
            back--;
        }
    }
}
