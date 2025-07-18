class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 0; // minium no.of operations for empty strings

                // Initialization for base cases
        for(int i = 0; i <= n; i++) dp[i][0] = i; // delete all from word1
        for(int j = 0; j <= m; j++) dp[0][j] = j; // insert all to word1


        for(int i = 1; i<= n; i++){
            for(int j=1; j<=m; j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min( dp[i-1][j-1],  Math.min(dp[i-1][j],  dp[i][j-1])) +1; 
                }
            }
        }

        return dp[n][m];

        
    }
}