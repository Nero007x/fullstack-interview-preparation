class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subSets = new ArrayList<>();
        List<Integer> curSet = new ArrayList<>();
        helper(0, nums, curSet, subSets);
        return subSets;    
    }

    public void helper(int i, int[] nums, List<Integer> curSet, List<List<Integer>> subSets){
        if(i>= nums.length){
           subSets.add(new ArrayList<>(curSet)); //make a copy
           return;
        }

        // decsion to include
        curSet.add(nums[i]);
        helper(i+1, nums, curSet, subSets);
        curSet.remove(curSet.size() -1);

         // decsion not to include
        helper(i+1, nums, curSet, subSets); 
    }
}