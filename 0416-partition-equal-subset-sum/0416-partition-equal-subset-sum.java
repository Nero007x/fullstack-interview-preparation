class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0, n = nums.length;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0){
            return false;
        }
        int target= sum/2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0); //baseCase always Zero sum possible

        for(int i = n-1; i>=0; i--){
            Set<Integer> nextDp = new HashSet<>();
            for(int t : dp){
                if(t+nums[i]== target){
                    return true;
                }
                nextDp.add(t+nums[i]);
                nextDp.add(t);
            }
            dp = nextDp;
        }

        return false;
    }
}