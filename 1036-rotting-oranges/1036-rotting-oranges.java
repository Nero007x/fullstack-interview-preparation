import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0, time = 0;

        // Count fresh oranges and add rotten ones to queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                } else if (grid[r][c] == 2) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // BFS
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] pos = q.poll();
                int r = pos[0], c = pos[1];

                for (int[] dir : directions) {
                    int row = r + dir[0];
                    int col = c + dir[1];

                    if (row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        q.offer(new int[]{row, col});
                        fresh--;
                    }
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }
}
