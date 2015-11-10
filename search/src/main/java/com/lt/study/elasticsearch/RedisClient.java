package com.lt.study.elasticsearch;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import com.google.common.collect.Lists;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;


public class RedisClient {

    private Jedis jedis;//非切片额客户端连接
    private JedisPool jedisPool;//非切片连接池
    private ShardedJedis shardedJedis;//切片额客户端连接
    private ShardedJedisPool shardedJedisPool;//切片连接池

    public RedisClient() {
        initialPool();
        initialShardedPool();
        shardedJedis = shardedJedisPool.getResource();
        jedis = jedisPool.getResource();


    }

    /**
     * 初始化非切片池
     */
    private void initialPool() {
        // 池基本配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxActive(20);
        config.setMaxIdle(5);
        config.setMaxWait(1000l);
        config.setTestOnBorrow(false);

        jedisPool = new JedisPool(config, "127.0.0.1", 6379);
    }

    /**
     * 初始化切片池
     */
    private void initialShardedPool() {
        // 池基本配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxActive(20);
        config.setMaxIdle(5);
        config.setMaxWait(1000l);
        config.setTestOnBorrow(false);
        // slave链接
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
        shards.add(new JedisShardInfo("127.0.0.1", 6379, "master"));

        // 构造池
        shardedJedisPool = new ShardedJedisPool(config, shards);
    }

    public void show() {
        jedisPool.returnResource(jedis);
        shardedJedisPool.returnResource(shardedJedis);
    }

    private static Random random = new Random();
    private static String adID = String.format("redis-record-%d", random.nextInt(3000));
    private static String fakeIp = String.format("%d.%d.%d.%d", random.nextInt(10), random.nextInt(256), random.nextInt(256), random.nextInt(256));

    public static void main(String[] args) throws InterruptedException {
        int num = 30;
        final CountDownLatch countDownLatch = new CountDownLatch(num);
        List<ThreadRedis> threadRedisList = Lists.newArrayList();
        for (int i = 0; i < num; i++) {
            threadRedisList.add(new ThreadRedis(countDownLatch, i));
        }
        long start = System.currentTimeMillis();
        for (ThreadRedis threadRedis : threadRedisList) {
            threadRedis.start();
        }
        countDownLatch.await();
        System.out.println("cost " + (System.currentTimeMillis() - start));

    }

    private static class ThreadRedis extends Thread {
        private CountDownLatch countDownLatch;
        private int threadNum;
        RedisClient redisClient = new RedisClient();

        ThreadRedis(final CountDownLatch countDownLatch, int threadNum) {
            this.countDownLatch = countDownLatch;
            this.threadNum = threadNum;
        }

        @Override
        public void run() {

            String adID = String.format("redis-record-%d", random.nextInt(3000));
            for (int i = 0; i < 20000; i++) {
//                redisClient.jedisPool.getResource().hincrBy(adID,fakeIp,1);
                redisClient.jedis.hincrBy(adID, fakeIp, 1);
            }
            countDownLatch.countDown();
            System.out.println("finished threadNum:" + threadNum);

        }
    }

}