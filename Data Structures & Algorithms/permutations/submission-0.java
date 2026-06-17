class Solution {

    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        Set<Integer> visit = new HashSet<>();
        backtrack(nums, new ArrayList<>(), visit);
        return res;
    }

    public void backtrack(int[] nums, List<Integer> subset, Set<Integer> visit) {
        if (subset.size() == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        for (int i = 0; i<nums.length; i++) {
            if (!visit.contains(nums[i])) {
                subset.add(nums[i]);
                visit.add(nums[i]);
                backtrack(nums, subset, visit);
                subset.remove(subset.size() - 1);
                visit.remove(nums[i]);
            }
        }

    }
}
