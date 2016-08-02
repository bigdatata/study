package com;

import java.util.concurrent.TimeUnit;

/**
 * Created by xionger on 2016/7/28.
 */
public class ThreadLocalExample {

    public static class MyRunner implements Runnable{
        public ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
        @Override
        public void run() {
            threadLocal.set((int)(Math.random()*100D));
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunner sharedRunnableInstance = new MyRunner();
        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


    }

}
