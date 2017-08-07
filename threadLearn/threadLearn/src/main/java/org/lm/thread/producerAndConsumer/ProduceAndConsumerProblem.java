package org.lm.thread.producerAndConsumer;

import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 龙鸣 on 2017/8/7.
 * realized:使用Condition接口的await()方法和signal()方法实现消费者与生产者问题
 */


public class ProduceAndConsumerProblem {
    public static final int MAX_SIZE=10;//堆栈大小
    public static LinkedList linkedList=new LinkedList<Object>();//存放共享数据
//    public static int index=0;//堆栈索引
//    public static int[]date;//共享数据
    public static ReentrantLock reentrantLock=new ReentrantLock();//创建锁
    public static Condition notFull=reentrantLock.newCondition();
    public static Condition notEmpty=reentrantLock.newCondition();
    //生产者
    static class Producer implements Runnable{

        @Override
        public void run() {
            while (true){
                try {
                    reentrantLock.lock();
                    while (linkedList.size() == MAX_SIZE) {//如果缓冲区已满，等待消费者消费，不在生产
                        try {
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    linkedList.add(new Object());//生产一个对象
                    System.out.println("生产了一个对象，当前产品个数为：" + linkedList.size());
                    notEmpty.signal();
                }finally {
                    reentrantLock.unlock();
                }
            }

        }
    }

    //消费者
     class Consumer implements Runnable{

        @Override
        public void run() {
            while (true){
                try {
                    reentrantLock.lock();
                    while (linkedList.size() == 0) {//缓冲区为空，等等待生产者生产
                        System.out.println("缓冲区以空，请等待生产者生产");
                        try {
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    linkedList.remove();//消费一个产品
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("消费了一个产品，产品个数为：" + linkedList.size());
                    notFull.signal();//消费了，缓冲区肯定不为空，可以释放生产者等待了
                }finally {
                    reentrantLock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {

        for(int i=0;i<4;i++){
            new Thread(new Producer()).start();
        }
        for(int i=0;i<4;i++){
            new Thread(new ProduceAndConsumerProblem().new Consumer()).start();
        }
    }
}
