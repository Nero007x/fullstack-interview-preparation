class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] jump = new int[n+1];
        for(int i = 0; i<=n; i++){
            if(ranges[i]<=0)
            continue;

            int start = Math.max(0, i-ranges[i]);
            int end = Math.min(n, i+ranges[i]);

            jump[start] = Math.max(jump[start], end); //5, 
        }

        int farthest = 0;
        int currEnd = 0;
        int tap = 0;

        for(int i = 0; i<n; i++){
            farthest = Math.max(farthest, jump[i]);
            if(currEnd == i){
                if(farthest <= i)
                    return -1;
                tap++;
                currEnd = farthest;
            }
        }
        return tap;
    }
}