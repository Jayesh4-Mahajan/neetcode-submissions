class Solution {

    private Map<Integer, Integer> counts;
    private List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        res.add(new ArrayList<>());
        counts = new HashMap<>();
        
        for (int num: nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        backtrack(new ArrayList<>(counts.keySet()), 0, new ArrayList<>());

        return res;
    }

    public void backtrack(List<Integer> nums, int idx, List<Integer> subset) {
        if (idx >= nums.size()) return;

        // Take if present
        int num = nums.get(idx);
        if (counts.get(num) > 0) {
            subset.add(num);
            counts.put(num, counts.get(num) - 1);
            res.add(new ArrayList<>(subset));
            backtrack(nums, idx, subset);
            subset.remove(subset.size()-1);
            counts.put(num, counts.get(num) + 1);
        }
        backtrack(nums, idx+1, subset);
    }
}
