class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] jump = new int[n+1];

        for(int i= 0; i< ranges.length; i++){

            if(ranges[i] == 0){
                continue;
            }

            int start = Math.max(0, i-ranges[i]);
            int end = Math.min(n, i+ranges[i]);

            jump[start] = Math.max(jump[start], end);
        }

        int farest = 0;
        int taps = 0;
        int currEnd = 0;

        for(int i =0; i<n; i++){
            farest = Math.max(farest, jump[i]);

            //its time to use new tap
            if(i==currEnd){
                // If the farthest we can reach is no better than our current position,
                // it means there's a gap we can't cover.
                if(farest <= i){
                    return -1;
                }
                taps++;
                currEnd = farest;
            }
        }

        return farest >= n? taps :-1;
    }
}