import java.util.*;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int maxArea = 0;

        // BFS function
        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    int area = 0;
                    queue.offer(new int[]{r, c});
                    visited[r][c] = true;

                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int row = cell[0], col = cell[1];
                        area++;

                        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
                        for (int[] d : directions) {
                            int newRow = row + d[0];
                            int newCol = col + d[1];

                            if (
                                newRow >= 0 && newRow < rows &&
                                newCol >= 0 && newCol < cols &&
                                grid[newRow][newCol] == 1 &&
                                !visited[newRow][newCol]
                            ) {
                                queue.offer(new int[]{newRow, newCol});
                                visited[newRow][newCol] = true;
                            }
                        }
                    }

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }
}
