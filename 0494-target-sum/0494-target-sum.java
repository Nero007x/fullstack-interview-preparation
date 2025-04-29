class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int num: nums){
            total+=num;
        }
        if((total+target)%2!=0 || Math.abs(target)> total){
            return 0;
        }
        int subsetSum= (target+total)/2;
        int[] dp = new int[subsetSum+1];
        dp[0]= 1; //base case exactly one way to make a sum '0' by chosing no elements

        for(int num : nums){
            for(int i= subsetSum; i>num-1; i-- ){
                dp[i]+=dp[i-num];
            }
        }

        return dp[subsetSum];
        
    }
}