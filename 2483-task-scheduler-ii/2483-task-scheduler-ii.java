class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> taskLastDone = new HashMap<>();
        long day = 0;

        for(int task : tasks){
            day++;

            if(taskLastDone.containsKey(task)){
                long dayPrevDone = taskLastDone.get(task);
                if(day<= dayPrevDone + space){
                    day = dayPrevDone + space + 1;
                }
            }



            taskLastDone.put(task, day);
        }

       return day; 
    }
}