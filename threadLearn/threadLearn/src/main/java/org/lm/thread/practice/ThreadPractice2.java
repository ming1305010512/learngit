package org.lm.thread.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by 龙鸣 on 2017/8/7.
 * problem discribe:生产者消费者模型：两个线程，一个负责生产，一个负责消费，生产者生产一个，
 * 消费者消费一个
 */
//同步堆栈类，共享数据
class   Resource{
    private int index=0;//堆栈索引
    private int size=1;//栈大小
    private int[]data;//共享数据
    public Resource(int size){
        //从测试类中获得栈大小
        this.size=size;
        data=new int[size];
    }
    //生产数据
    public void push(int n){
        synchronized (this){
            while(index==size){//栈已满，需等待消费者消费
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("生产了一个" + n);
            data[index]=n;
            index++;
            this.notify();//唤醒消费者线程消费
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
            int n=data[--index];//消费一个数据，并赋给ch
            this.notify();//唤醒生产者线程生产
            return n;
        }
    }
}
//生产者
class Producer implements Runnable{

    private Resource resource;
    public Producer(Resource resource){
        this.resource=resource;
    }
    @Override
    public void run() {

        for (int i=0;i<20;i++) {
            System.out.println("请生产一个字符");
           int n=new Random().nextInt(100);
           resource.push(n);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
//消费者
class Consumer implements Runnable{

    private Resource resource;
    public  Consumer(Resource resource){
        this.resource=resource;
    }
    @Override
    public void run() {
        while (true) {
//            System.out.println("消费中...");
            for (int i=0;i<20;i++) {
                int n = resource.pop();
                System.out.println("消费了一个" + n);
            }
        }
    }
}
public class ThreadPractice2 {

    public static void main(String[] args) {
        Resource resource=new Resource(1);
        Producer producer=new Producer(resource);
        Consumer consumer=new Consumer(resource);
        Thread producerThread=new Thread(producer);
        Thread consumerThread=new Thread(consumer);
        producerThread.start();
        consumerThread.start();
    }

}
