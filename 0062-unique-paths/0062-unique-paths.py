class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        row = [1]*n

        for i in range(1, m):
            newrow = [1]*n

            for j in range(1, n):
                newrow[j] = row[j] + newrow[j-1]

            row = newrow

        return row[n-1]
        