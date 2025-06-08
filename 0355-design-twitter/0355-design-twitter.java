class Twitter {

    private static int timeStampe = 0;

    private static class Tweet{
        int tweetId;
        int time;

        Tweet(int tweetId, int time){
            this.tweetId = tweetId;
            this.time = time;
        }
    }
    //userid ---> set(followeeIds))
    Map<Integer, Set<Integer>> followMap;
    //usetid --> list(tweets)
    Map<Integer, List<Tweet>> tweetMap;
    public Twitter() {
        this.followMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId, timeStampe++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        //step1 : setting up maxHeap based timestampe
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a,b)->b.time - a.time);

        //step2 : gather all users including current user
        Set<Integer> users = new HashSet<>();
        users.add(userId);
        users.addAll(followMap.getOrDefault(userId, new HashSet<>()));

        //step3 : add each user tweets to maxHeap
        for(int user : users){
            List<Tweet> tweets = tweetMap.getOrDefault(user, new ArrayList<>());
            for(Tweet t : tweets){
                maxHeap.offer(t);
            }
        } 

        //stepr : retrive all top 10 recent tweets
        int count = 0;
        List<Integer> result = new ArrayList<>();
        while(!maxHeap.isEmpty() && count<10){
            result.add(maxHeap.poll().tweetId);
            count++;
        } 
        return result;   
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId))
        followMap.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */