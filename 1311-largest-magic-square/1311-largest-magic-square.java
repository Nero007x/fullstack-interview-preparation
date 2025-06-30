class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // Prefix sums for rows and columns
        int[][] rowPrefix = new int[m][n + 1];
        int[][] colPrefix = new int[m + 1][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                rowPrefix[i][j + 1] = rowPrefix[i][j] + grid[i][j];
                colPrefix[i + 1][j] = colPrefix[i][j] + grid[i][j];
            }

        int maxK = Math.min(m, n);
        for (int k = maxK; k >= 1; k--) {
            for (int i = 0; i <= m - k; i++) {
                for (int j = 0; j <= n - k; j++) {
                    if (isMagic(grid, i, j, k, rowPrefix, colPrefix)) {
                        return k;
                    }
                }
            }
        }

        return 1; // fallback
    }

    private boolean isMagic(int[][] grid, int r, int c, int k, int[][] rowPrefix, int[][] colPrefix) {
        int target = 0;

        // Main diagonal
        for (int i = 0; i < k; i++)
            target += grid[r + i][c + i];

        int diag2 = 0; // anti-diagonal
        for (int i = 0; i < k; i++)
            diag2 += grid[r + i][c + k - 1 - i];

        if (diag2 != target) return false;

        // Rows
        for (int i = 0; i < k; i++) {
            int rowSum = rowPrefix[r + i][c + k] - rowPrefix[r + i][c];
            if (rowSum != target) return false;
        }

        // Columns
        for (int j = 0; j < k; j++) {
            int colSum = colPrefix[r + k][c + j] - colPrefix[r][c + j];
            if (colSum != target) return false;
        }

        return true;
    }
}
