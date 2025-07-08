class Solution {
    public int maxValue(int[][] events, int k) {
        // Step 1: Sort events by end time
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));

        // Step 2: Store all end times to use in binary search
        int n = events.length;
        int[] endTimes = new int[n];
        for (int i = 0; i < n; i++) {
            endTimes[i] = events[i][1];
        }

        // Step 3: DP array
        int[][] dp = new int[n + 1][k + 1];

        // Step 4: Fill DP
        for (int i = 1; i <= n; i++) {
            int[] curr = events[i - 1];
            int start = curr[0];
            int end = curr[1];
            int value = curr[2];

            // Find last event that ends before current start
            int last = binarySearch(endTimes, start - 1);

            for (int j = 1; j <= k; j++) {
                // Option 1: skip current event
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                // Option 2: take current event
                dp[i][j] = Math.max(dp[i][j], dp[last + 1][j - 1] + value);
            }
        }

        return dp[n][k];
    }

    // Binary search: find the last event ending before given day
    private int binarySearch(int[] endTimes, int target) {
        int low = 0, high = endTimes.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (endTimes[mid] <= target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}