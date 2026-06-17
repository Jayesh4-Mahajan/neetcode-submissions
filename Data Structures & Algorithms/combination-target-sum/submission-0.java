class Solution {

    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, target, 0, subset, 0);
        return res;
    }

    public void dfs(int[] nums, int target, int rs, 
    List<Integer> subset, int i) {
        if (rs == target) {
            res.add(new ArrayList<>(subset));
            return;
        } else if (rs > target) {
            return;
        }
        if (i >= nums.length) return;

        // for (int j = i; j < nums.length; j++) {
        subset.add(nums[i]);
        dfs(nums, target, rs + nums[i], subset, i);
        subset.remove(subset.size() - 1);
        dfs(nums, target, rs, subset, i+1);
        // }
    }
}
