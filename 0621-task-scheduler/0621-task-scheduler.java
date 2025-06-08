class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char task : tasks){
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int f : freq){
            if(f>0){
                maxHeap.offer(f);
            }
        }

        Queue<int[]> coolDown = new LinkedList<>();
        int time = 0;

        while(!maxHeap.isEmpty() || !coolDown.isEmpty()){
            time++;

            if(!coolDown.isEmpty() && coolDown.peek()[1] == time){
                maxHeap.offer(coolDown.poll()[0]);
            }

            if(!maxHeap.isEmpty()){
                int cur = maxHeap.poll() - 1;
                if(cur> 0){
                    coolDown.offer(new int[]{cur, time+n+1});
                }
            }
        }

        return time;
    }
}