class Solution {
    public int maxProfit(int[] prices) {
        int maxP =0;   

        for(int i = 1; i< prices.length; i++){
            int p = prices[i] - prices[i-1];
            if(p > 0){
                maxP+= p;
            }
        }
        return maxP;
    }
}