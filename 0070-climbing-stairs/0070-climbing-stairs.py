class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 2:
            return n

        dp = [1, 2]
        i = 2

        while i < n:
            temp = dp[1]
            dp[1] = dp[0]+ dp [1]
            dp[0] = temp
            i+=1

        return dp[1] 