class Solution {

    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        
        Map<Integer, Integer> counts = new HashMap<>();
        for (int candidate: candidates) {
            counts.put(candidate, counts.getOrDefault(candidate, 0) + 1);
        }

        backtrack(new ArrayList<>(counts.keySet()), 0, target, new ArrayList<>(), counts);
        
        return res;
    }

    public void backtrack(List<Integer> candidates, int idx, int target, List<Integer> subset, 
    Map<Integer, Integer> counts) {
        if (target == 0) {
            res.add(new ArrayList<>(subset));
            return;
        } else if (target < 0 || idx >= candidates.size()) {
            return;
        }

        Integer num = candidates.get(idx);
        if (counts.get(num) > 0) {
            counts.put(num, counts.get(num) - 1);
            subset.add(num);
            backtrack(candidates, idx, target - num, subset, counts);
            counts.put(num, counts.get(num) + 1);
            subset.remove(subset.size() - 1);
        }

        backtrack(candidates, idx + 1, target, subset, counts);
    }
}
