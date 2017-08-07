package org.lm.thread.threadSynchronization;

/**
 * Created by 龙鸣 on 2017/8/7.
 */
public class ThreadBySynchronized implements Runnable{
    @Override
    public void run() {
        synchronized(this){
            for(int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }

    public static void main(String[] args) {
        Runnable r = new ThreadBySynchronized();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();

    }
}
