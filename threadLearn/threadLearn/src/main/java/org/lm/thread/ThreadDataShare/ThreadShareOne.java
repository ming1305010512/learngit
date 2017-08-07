package org.lm.thread.ThreadDataShare;

/**
 * Created by 龙鸣 on 2017/8/7.
 * the one scene:每个线程执行的代码相同,可以使用同一个Runnable对象
 * 本例模拟取票系统
 */
public class ThreadShareOne {
    public static void main(String[] args) {

        Ticket ticket=new Ticket();
        Thread thread1=new Thread(ticket);
        Thread thread2=new Thread(ticket);
        thread1.start();
        thread2.start();
    }
}
class Ticket implements Runnable{

    private int ticket=10;
    @Override
    public void run() {

        while (ticket>0){
            ticket--;
            System.out.println(Thread.currentThread().getName()+"取了一票"+"还剩余:"+ticket+"张");
        }
    }
}
