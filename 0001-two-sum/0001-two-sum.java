class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> targetMap = new HashMap<>();
        for (int i=0; i< nums.length; i++) {
            if (targetMap.containsKey(target-nums[i])) {
                return new int[] {i, targetMap.get(target-nums[i])};
            }
            targetMap.put(nums[i], i);
        }
        return new int[]{};
    }
}
