class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int count =0;
        int prev = nums[0];

        for(int i = 1; i <= nums.length-1; i++){
            if(nums[i]> prev){
                prev = nums[i];
            }else{
                count += 1;
                if(count>1){
                    return false;
                }
                if(i==1 || nums[i]> nums[i-2]){
                    prev = nums[i];
                }
            }
        }
        return true;
    }
}