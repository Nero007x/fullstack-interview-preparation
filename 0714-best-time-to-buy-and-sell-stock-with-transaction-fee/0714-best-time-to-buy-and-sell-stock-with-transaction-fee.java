class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            cash = Math.max(cash, hold + price - fee);
            hold = Math.max(hold, cash - price);
        }

        return cash;
    }
}
