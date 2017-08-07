package org.lm.thread.threadRealized;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by 龙鸣 on 2017/8/7.
 * problem discribe:通过实现Callable接口实现有返回值的线程
 * train:1、实现Callable接口
 *       2、创建一个线程池
 *       3、实例化实现了Callable接口的类
 *       4、使用ExecutorService，也即线程池提交Callable，返回Future
 *       5、使用Future的get（）方法获得返回值
 */
public class ThreadRealizeWithCallable {

    public static void main(String[] args) {

        System.out.println("程序开始启动");
        Date date1=new Date();
        int taskSize=5;
        ExecutorService pool= Executors.newFixedThreadPool(taskSize);//使用执行者工具类创建一个线程池
        List<Future> list=new ArrayList<Future>();
        for (int i=0;i<taskSize;i++){
            Callable c=new MyCallable(i+"任务");
            Future future=pool.submit(c);//提交实现了Callable接口的任务，并返回任务待处理结果的Future
            list.add(future);
        }
        pool.shutdown();
        for (Future f:list){
            try {
                System.out.println(f.get().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
}

class MyCallable implements Callable<Object>{

    private String taskNum;//第哪一个任务
    MyCallable(String taskNum){
        this.taskNum=taskNum;
    }
    @Override
    public Object call() throws Exception {
        System.out.println("任务"+taskNum+"以启动");
        Date d1=new Date();
        Thread.sleep(1000);//参数类型为long
        Date d2=new Date();
        long timeExecutive=d2.getTime()-d1.getTime();
        System.out.println("任务"+taskNum+"结束");
        return taskNum+"的返回结果，总共执行了"+timeExecutive+"s";//返回线程执行的结果
    }
}
