package zeus.arithmetic;

import java.util.*;

public class Twitter {

    /**
     * 推文内部类
     */
    private class Tweet{

        private int userId;

        private int timestamp;

        private Tweet next;

        public Tweet(int userId, int timestamp) {
            this.userId = userId;
            this.timestamp = timestamp;
        }
    }

    // 用户id和推文(单链表)的对应关系
    private Map<Integer, Tweet> twitter;

    // 用户id和他关注的用户列表的对应关系
    // HashSet,LinkedSet,TreeSet
    private Map<Integer, Set<Integer>> followings;

    // 使用全局时间戳段,用户每发布一条推文前+1
    private static int timestamp = 0;

    // 合并k组推文使用的数据结构(可以在方法里创建使用),声明成全局变量非必需
    private static PriorityQueue<Tweet> maxHeap;

    // 初始化推特的对象
    public Twitter() {
        followings = new HashMap<>();
        twitter = new HashMap<>();
        maxHeap = new PriorityQueue<>((obj1, obj2) -> (obj2.timestamp - obj1.timestamp));
    }

    /** 检索当前用户新闻推送中最近10条推文的Id
     *  新闻中的每一项都是由用户关注的人
     *  或者是用户自己发布的推文
     * @param usedId
     * @return
     */
    public List<Integer> getNewsFeed(int usedId) {
        // 全局使用，使用之前全部清空
        maxHeap.clear();

        // 根据用户id将包含的推特文章展示出来
        if (twitter.containsKey(usedId)) {
            maxHeap.offer(twitter.get(usedId));
        }
        // 遍历用户关注的人的推特
        Set<Integer> followingList = followings.get(usedId);

        if (followingList != null && followingList.size() > 0) {
            for (Integer followingId : followingList) {
                Tweet tweet = twitter.get(followingId);
                if (tweet != null) {
                    maxHeap.offer(tweet);
                }
            }
        }

        // 展示10条
        List<Integer> res = new ArrayList<>(10);
        int count = 0;

        while (!maxHeap.isEmpty() && count < 10) {
            Tweet headTweet = maxHeap.poll();
            res.add(headTweet.userId);

            if (headTweet.next != null) {
                maxHeap.offer(headTweet.next);
            }
            count++;
        }
        return res;
    }

    /**
     * Compose a new tweet
     * @param userId 用户id
     * @param tweetId 推特文章id
     */
    public void postTweet(int userId, int tweetId) {
        timestamp++;

        if (twitter.containsKey(userId)) {
            Tweet oldHeadTweet = twitter.get(userId);
            Tweet newHeadTweet = new Tweet(tweetId, timestamp);
            newHeadTweet.next = oldHeadTweet;
            twitter.put(userId, newHeadTweet);
        } else {
            twitter.put(userId, new Tweet(tweetId, timestamp));
        }
    }

    /**
     *
     * @param followerId 发起关注者id
     * @param followeeId 被关注者id
     */
    public void follow(int followerId, int followeeId) {
        // 被关注的人不能是自己
        if (followerId == followeeId) return ;

        // 获取我自己的关注列表
        Set<Integer> followingList = followings.get(followerId);

        if (followingList == null) {
            Set<Integer> init = new HashSet<>();
            init.add(followeeId);

            followings.put(followerId, init);
        } else {
            if (followingList.contains(followeeId)) {
                return ;
            }
            followingList.add(followeeId);
        }
    }

    /**
     *
     * @param followerId
     * @param followeeId
     */
    public void unfollow(int followerId, int followeeId) {
        // 本人不能取消关注自己
        if (followeeId == followerId) return ;

        // 获取我自己的关注列表
        Set<Integer> followingList = followings.get(followerId);

        if (followingList == null) return ;

        followingList.remove(followeeId);
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        twitter.postTweet(1,1);
        twitter.postTweet(1,7);
        twitter.postTweet(1,8);
        List<Integer> list1 = twitter.getNewsFeed(1);
        System.out.println("list1:"+list1);

        twitter.postTweet(2,1);
        twitter.postTweet(2,2);
        twitter.postTweet(2,3);
        twitter.follow(2,1);
        List<Integer> list2 = twitter.getNewsFeed(2);
        System.out.println("list2:"+list2);

        twitter.unfollow(2,1);
        List<Integer> list3 = twitter.getNewsFeed(2);
        System.out.println("list3:"+list3);
    }
}
