package org.lm.thread.practice;

/**
 * Created by 龙鸣 on 2017/8/7.
 * problem discribe:启动3个线程打印递增的数字, 线程1先打印1,2,3,4,5, 然后是线程2打印6,7,8,9,10,
 * 然后是线程3打印11,12,13,14,15. 接着再由线程1打印16,17,18,19,20....以此类推, 直到打印到75
 */
public class ThreadPractice1 {
    private static int num=1;//打印的数字
    private  static int status=1;//用来判断是那个线程
    private static String thread1="线程1:";
    private static String thread2="线程2:";
    private static String thread3="线程3:";

    public static void main(String[] args) {
        ThreadPractice1 tp=new ThreadPractice1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //每个线程一次打印五个值，总共打印75次，有三个线程，则每个线程执行五次
                //执行线程1
                for (int i=0;i<5;i++){
                    synchronized (tp){
                        while (status!=1){
                            try {
                                tp.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        for (int j=0;j<5;j++){
                            System.out.println(thread1+(num++));
                        }
                        System.out.println();
                        status=2;
                        tp.notifyAll();
                    }
                }
            }
        }).start();
        //执行线程2
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5;i++){
                    synchronized (tp){
                        while(status!=2){
                            try {
                                tp.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        for (int j=0;j<5;j++){
                            System.out.println(thread2+num++);
                        }
                        System.out.println();
                        status=3;
                        tp.notifyAll();
                    }
                }
            }
        }).start();
        //执行线程三
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    synchronized (tp){
                        while (status!=3){
                            try {
                                tp.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        for (int j=0;j<5;j++){
                            System.out.println(thread3+(num++));
                        }
                        System.out.println();
                        status=1;
                        tp.notifyAll();
                    }
                }
            }
        }).start();
    }
}
