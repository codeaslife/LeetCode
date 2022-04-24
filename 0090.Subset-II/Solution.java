class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }

        Arrays.sort(nums);

        // 递归搜索
        List<Integer> subset = new ArrayList<>();
        subsetHelper(nums, 0, subset, results);
        return results;
    }

    private void subsetHelper(int[] nums, 
                            int startIndex, 
                            List<Integer> subset, 
                            List<List<Integer>> results) {
        // deep copy subset & add to results                       
        results.add(new ArrayList<Integer>(subset));

        for (int i = startIndex; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && i > startIndex) {
                continue;
            }
            subset.add(nums[i]);
            subsetHelper(nums, i + 1, subset, results);
            subset.remove(subset.size() - 1);
        }
    }
}