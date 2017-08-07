package org.lm.FileOperation;

import java.io.File;
import java.io.IOException;

/**
 * Created by 龙鸣 on 2017/8/5.
 */
public class FileTestOne {
    //在D盘下创建一个文件
    public static File createFile(String filePath){
        boolean result =false;
        File file=new File(filePath);//根据路劲创建一个文件
        if(!file.exists()){
            try {
                result=file.createNewFile();//文件不存在时，在当前目录下新建一个文件，成功返回true
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
    //创建一个目录
    public static File createDirectory(String path){

        File file=new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        return file;
    }

    public static void main(String[] args) {
        boolean ismove=false;
        File file=createFile("D:\\HelloWorld.txt");

        if(file.isFile()){
            System.out.println("创建了一个文件:"+file.getName());
        }
        if(file.isDirectory()){
            System.out.println("创建了一个目录:"+file.getName());
        }
        File IOTestDirectory=createDirectory("D:\\IOTest");
        if(IOTestDirectory.isDirectory()){
            System.out.println("文件夹创建成功："+IOTestDirectory.getName());
        }else{
            System.out.println("文件创建失败");
        }
        //将HelloWorld.txt文件移到IOTest目录下
        ismove=file.renameTo(new File(IOTestDirectory.getAbsolutePath()+"\\"+file.getName()));
        if(ismove){//如果移动成功，执行遍历IOTest文件夹下的文件
            System.out.println("文件移动成功");
            File []files=IOTestDirectory.listFiles();
            System.out.println("IOTest文件夹下的文件：");
            for(File fileSub :files){
                System.out.println(fileSub.getName());
            }
        }else{
            System.out.println("文件移动失败");
        }
    }
}
