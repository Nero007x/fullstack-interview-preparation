class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int globMax = nums[0], globMin = nums[0], total =0;
        int currMax = 0, currMin = 0;


        for(int num : nums){
            currMax = Math.max(currMax+num, num);
            currMin = Math.min(currMin+num, num);

            globMax = Math.max(currMax, globMax);
            globMin = Math.min(currMin, globMin);

            total += num;
        }

        if(globMax < 0){
            return globMax;
        }

        return Math.max(globMax, (total - globMin));
        
    }
}