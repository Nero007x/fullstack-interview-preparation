import java.util.*;

class Twitter {
    private static int timeStamp = 0;

    // Tweet class to store tweet id and timestamp
    private static class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    // Maps userId -> set of users they follow
    private Map<Integer, Set<Integer>> followMap;
    // Maps userId -> list of tweets
    private Map<Integer, List<Tweet>> tweetMap;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId, timeStamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);
        Set<Integer> users = new HashSet<>();

        users.add(userId);  // add self
        users.addAll(followMap.getOrDefault(userId, new HashSet<>()));  // add followees

        for (int user : users) {
            List<Tweet> tweets = tweetMap.getOrDefault(user, new ArrayList<>());
            for (Tweet tweet : tweets) {
                maxHeap.offer(tweet);
            }
        }

        List<Integer> result = new ArrayList<>();
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            result.add(maxHeap.poll().tweetId);
            count++;
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
