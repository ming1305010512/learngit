package org.lm.thread.practice;

import java.util.Random;

/**
 * Created by 龙鸣 on 2017/8/7.
 * problem discribe:生产者消费者模型：四个线程，两个个负责生产，
 * 两个个负责消费，生产者生产一个，消费者消费一个
 */
//同步堆栈类，共享数据
class   Resource2{
    private int index=0;//堆栈索引
    private int size=1;//栈大小
    private int[]data;//共享数据
    public Resource2(int size){
        //从测试类中获得栈大小
        this.size=size;
        data=new int[size];
    }
    //生产数据
    public void push(int n){
        synchronized (this){
//            System.out.println("请生产一个字符");
            while(index==size){//栈已满，需等待消费者消费
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"生产了一个" + n);
            data[index]=n;
            index++;
            this.notifyAll();//唤醒消费者线程消费
        }
    }
    public  int pop(){
        synchronized (this){
            while (index==0){//栈空，需等待生产者生产

                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("消费中...");
            System.out.println(Thread.currentThread().getName()+"消费了一个" + data[index-1]);
            int n=data[--index];//消费一个数据，并赋给n
            this.notifyAll();//唤醒生产者线程生产
            return n;
        }
    }
}
//生产者
class Producer2 implements Runnable{

    private Resource2 resource2;
    public Producer2(Resource2 resource2){
        this.resource2=resource2;
    }
    @Override
    public void run() {

        for (int i=0;i<20;i++) {
            int n=new Random().nextInt(100);
            resource2.push(n);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
//消费者
class Consumer2 implements Runnable{

    private Resource2 resource2;
    public  Consumer2(Resource2 resource2){
        this.resource2=resource2;
    }
    @Override
    public void run() {
        while (true) {
//            System.out.println("消费中...");
            for (int i=0;i<20;i++) {
                int n = resource2.pop();
            }
        }
    }
}
public class ThreadPratice3 {
    public static void main(String[] args) {
        Resource2 resource2=new Resource2(1);
        Producer2 producer2=new Producer2(resource2);
        Consumer2 consumer2=new Consumer2(resource2);
        Thread producerThread1=new Thread(producer2);
        Thread producerThread2=new Thread(producer2);

        Thread consumerThread1=new Thread(consumer2);
        Thread consumerThread2=new Thread(consumer2);
        producerThread1.start();
        producerThread2.start();
        consumerThread1.start();
        consumerThread2.start();
    }
}
