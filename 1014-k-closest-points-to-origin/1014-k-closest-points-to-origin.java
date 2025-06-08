class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]*a[0]+a[1]*a[1]));
        for(int[] point : points){
            minHeap.offer(point);
        }

        int[][] result = new int[k][2];
        for(int i = 0; i<k; i++){
            result[i] = minHeap.poll();
        }
        return result;

        
    }
}