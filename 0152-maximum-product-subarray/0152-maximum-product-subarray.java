class Solution {
    public int maxProduct(int[] nums) {
        int currentMaxProduct = nums[0];
        int currentMinProduct = nums[0];
        int maxProduct = nums[0];

        for(int i = 1; i< nums.length; i++){
           if(nums[i]< 0){
            int temp = currentMaxProduct;
            currentMaxProduct = currentMinProduct;
            currentMinProduct = temp;
           }
           currentMaxProduct = Math.max(nums[i], currentMaxProduct * nums[i]);
           currentMinProduct = Math.min(nums[i], currentMinProduct * nums[i]);
           maxProduct = Math.max(maxProduct, currentMaxProduct);
        }
        return maxProduct;
    }
}