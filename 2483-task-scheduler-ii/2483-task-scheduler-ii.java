class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> lastDone = new HashMap<>();
        long day = 0;

        for (int task : tasks) {
            day++;

            if (lastDone.containsKey(task)) {
                long lastDay = lastDone.get(task);
                if (day <= lastDay + space) {
                    day = lastDay + space + 1;
                }
            }

            lastDone.put(task, day);
        }

        return day;
    }
}
