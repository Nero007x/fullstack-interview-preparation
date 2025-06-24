class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <= 1){
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        int[] currentInterval = intervals[0];
        result.add(currentInterval);

        for(int i = 1; i< intervals.length; i++){
            int start = currentInterval[0];
            int end = currentInterval[1];
            int nextStart = intervals[i][0];
            int nextEnd =  intervals[i][1];

            if(end >= nextStart){
                currentInterval[1] = Math.max(end, nextEnd);  
            }else{
                currentInterval = intervals[i];
                result.add(currentInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
        
    }
}