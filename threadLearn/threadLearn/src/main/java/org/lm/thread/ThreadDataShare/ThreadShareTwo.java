package org.lm.thread.ThreadDataShare;

import java.util.Random;

/**
 * Created by 龙鸣 on 2017/8/7.
 * the second scene:每个线程执行的代码不同,这时候需要用不同的Runnable对象
 * the solution way:将共享数据封装成另外一个对象，然后将这个对象逐一传递给各个Runnable对象
 * ，每个线程对共享数据的操作方法也分配到那个对象身上完成，这样容易实现针对数据进行各个操作
 * 的互斥和通信
 * simulate:本例模拟银行取款
 * train:1、在每个线程执行的代码不同情况下，需要使用不同的Runnable对象
 *       2、将共享数据封装成一个类，具体操作也在此完成
 *       3、创建Runnable执行对象，依赖共享类，操作由共享类提供，调用共享类的方法即可
 *       4、开启线程
 */
public class ThreadShareTwo {

    public static void main(String[] args) {
        Acount acount=new Acount(2000);
        Bank bank=new Bank(acount);
        Consumer consumer=new Consumer(acount);
        Thread bankThread=new Thread(bank);
        Thread consumerThread=new Thread(consumer);
        bankThread.start();
        consumerThread.start();
    }

}
//此类为共享数据，封装成一个对象,并且把共享数据的底层操作在此对象完成，这里对应取款和存款
class Acount{

    private int money;//客户存款数,也是这里的共享变量
    public Acount(int money){
        this.money=money;
    }
    public synchronized void getMoney(int money){
        while (this.money<money) {
            System.out.println("取款数" + money + " " + "余额：" + this.money + "\n" + "存款不足！");

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.money=this.money-money;
        System.out.println("取出："+money+" "+"剩余:"+this.money);
    }
    public synchronized void setMoney(int money){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.money=this.money+money;

        System.out.println("存入："+money+" "+"余额："+this.money);
        notify();
    }
}
//存款类，一个Runnable对象,要依赖共享类Acount
class  Bank implements Runnable{

    Acount acount;
    public Bank(Acount acount){
        this.acount=acount;
    }
    @Override
    public void run() {

        int count=20;
        while (count>0){
            int temp=new Random().nextInt(1000);
            acount.setMoney(temp);
            count--;
        }
    }
}
//取款类，一个Runnable对象，要依赖共享类Acount
class Consumer implements Runnable{

    Acount acount;
    public Consumer(Acount acount){
        this.acount=acount;
    }
    @Override
    public void run() {

        int count=20;
        while (count>0){
            int temp=new Random().nextInt(1000);
            acount.getMoney(temp);
            count--;
        }
    }
}
