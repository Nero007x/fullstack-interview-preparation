class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for(int i = 0; i < n; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int startPointer = 0;
        int endPointer = 0;
        int noOfRooms = 0;

        while(startPointer < n){
            if(start[startPointer]< end[endPointer]){
                noOfRooms++;
                startPointer++;
            }
            else{
                endPointer++;
                startPointer++;
            }
        }

        return noOfRooms;
    }
}