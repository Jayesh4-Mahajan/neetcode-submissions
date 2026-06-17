class Twitter {

    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<int[]>> tweetMap;
    int counter;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        counter = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<>());
        }
        tweetMap.get(userId).add(new int[]{counter++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> -1*a[0]));

        followMap.computeIfAbsent(userId, k -> new HashSet()).add(userId);
        for (int followeeId: followMap.get(userId)) {
            if (tweetMap.containsKey(followeeId)) {
                List<int[]> tweets = tweetMap.get(followeeId);
                int index = tweets.size() - 1;
                int[] tweet = tweets.get(index);
                minHeap.offer(new int[]{tweet[0], tweet[1], followeeId, index});
            }
        }

        while (!minHeap.isEmpty() && feed.size() < 10) {
            int[] curr = minHeap.poll();
            feed.add(curr[1]);
            int index = curr[3];
            if (index > 0) {
                int[] tweet = tweetMap.get(curr[2]).get(index - 1);
                minHeap.offer(new int[]{tweet[0], tweet[1], curr[2], index -1});
            }
        }

        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) {
            followMap.put(followerId, new HashSet<>());
        }
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMap.get(followerId).remove(followeeId);
    }
}
