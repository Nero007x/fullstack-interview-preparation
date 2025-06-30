class Solution {
    public int maxProduct(int[] nums) {
        int currentMaxProduct = nums[0];
        int currentMinProduct = nums[0];
        int maxProduct = nums[0];

        for(int i = 1; i< nums.length; i++){
            int temp = currentMaxProduct * nums[i];
            currentMaxProduct = Math.max(nums[i], Math.max(currentMaxProduct * nums[i], currentMinProduct * nums[i]));
            currentMinProduct = Math.min(nums[i], Math.min(currentMinProduct * nums[i], temp));
            maxProduct = Math.max(maxProduct, currentMaxProduct);
        }
        return maxProduct;
    }
}