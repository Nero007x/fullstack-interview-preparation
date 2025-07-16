class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if(n==1) return matrix[0][0];
        int result = Integer.MAX_VALUE;

        for(int r = 1; r<n; r++){
            for(int c=0; c< n; c++){
                int left = (c-1>=0)? matrix[r-1][c-1] : Integer.MAX_VALUE;
                int up = matrix[r-1][c];
                int right = (c+1<n)? matrix[r-1][c+1] : Integer.MAX_VALUE;

                matrix[r][c] += Math.min(left, Math.min(up, right));
                if(r==n-1){
                    result = Math.min(result, matrix[r][c]);
                }
            }
        }

        return result;
        
    }
}