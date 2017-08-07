package org.lm.FileOperation;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 龙鸣 on 2017/8/6.
 * problem discribe:输入两个文件夹名称，将A文件夹内容全部拷贝到B文件夹，要求使用多线程来操作。
 *
 */
public class FileTestTen implements Runnable{

    //实现文件的复制
    public  static  void copyFile(File sourceFile,File targetFile){

        FileInputStream fileInputStream=null;
        FileOutputStream fileOutputStream=null;
        InputStreamReader inputStreamReader=null;
        BufferedReader bufferedReader=null;
        try {
            fileInputStream=new FileInputStream(sourceFile);
            inputStreamReader=new InputStreamReader(fileInputStream);
            bufferedReader=new BufferedReader(inputStreamReader);
            fileOutputStream=new FileOutputStream(targetFile);
//            byte []bytes=new byte[1024];
            String content="";
            while ((content=bufferedReader.readLine())!=null){

                fileOutputStream.write(content.getBytes());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //线程实现文件夹的复制,参数sourceFile,targetFile只能是文件夹
    public static void copyDirectory(File sourceFile,File targetFile){

        ArrayList<String> fileNameList=new ArrayList<String>();//用来存放sourceFile文件夹下的所有文件和文件夹
        FileTestTwo.getAllFileName(sourceFile.getAbsolutePath(),fileNameList);
        for(String fileName:fileNameList){
//            System.out.println(fileName);
            File fileSource=new File(sourceFile.getAbsolutePath()+"\\"+fileName);
            File fileTarget=new File(targetFile.getAbsolutePath()+"\\"+fileName);
            System.out.println(fileTarget.getAbsolutePath());
            if(fileSource.isFile()){
                copyFile(fileSource,fileTarget);
            }else if(fileSource.isDirectory()){
                fileTarget.mkdirs();
            }
        }
    }

    public static void main(String[] args) {

        FileTestTen fileTestTen=new FileTestTen();
        Thread threadOne=new Thread(fileTestTen);
        threadOne.start();
    }

    @Override
    public void run() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("源文件夹路径：");
        String sourceDir = scanner.next();// 接收输入
        System.out.println("目标文件夹路径：");
        String targetDir = scanner.next();// 接收输入
        File sourceFile=new File(sourceDir);
        File targetFile=new File(targetDir);
        copyDirectory(sourceFile,targetFile);
    }
}
