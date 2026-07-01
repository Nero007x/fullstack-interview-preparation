class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices or len(prices)==0:
            return 0
        n = len(prices)

        hold = [0]*n
        sold = [0]*n
        cooldown = [0]*n

        #base Case
        hold[0] = -prices[0]        

        for i in range(1, n):
            hold[i] = max(hold[i-1], cooldown[i-1]-prices[i])
            sold[i] = hold[i-1] + prices[i]
            cooldown[i] = max(cooldown[i-1], sold[i-1])

        return max(sold[n-1], cooldown[n-1])