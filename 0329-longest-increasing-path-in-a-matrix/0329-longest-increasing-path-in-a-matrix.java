class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length== 0 || matrix[0].length == 0){
            return 0;
        }
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        int maxPath = 0;

        for(int i = 0; i< n; i++){
            for(int j =0; j<m; j++){
                if(dp[i][j]== 0)
                    dp[i][j] = dfs(matrix, dp, i,j);
                maxPath = Math.max(maxPath, dp[i][j]);
            }
        }

        return maxPath;  
    }

    public int dfs(int[][] matrix, int[][] dp, int row, int col){
        if(dp[row][col] != 0)
            return dp[row][col];
        
        int n = matrix.length, m= matrix[0].length;
        int[] dr = {1,-1,0,0}, dc = {0, 0, 1, -1};
        int maxPath = 1;

        for(int i =0; i< 4; i++){
            int newRow = row+dr[i], newCol = col+dc[i];
            if(newRow>=0 && newRow < n && newCol >=0 && newCol < m && matrix[newRow][newCol]> matrix[row][col]){
                maxPath = Math.max(maxPath, 1 + dfs(matrix, dp, newRow, newCol));
            }
        }

        dp[row][col] = maxPath;
        return maxPath;
    }
}