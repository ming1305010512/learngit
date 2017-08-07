package org.lm.FileOperation;

import java.io.*;

/**
 * Created by 龙鸣 on 2017/8/5.
 * problem discribe :拷贝一张图片，从一个目录到另外一个目录下(PS:是拷贝是不是移动)
 */
public class FileTestSix {
    //实现图片复制
    public static void copyFile(String fileOnePath,String fileTwoPath){
        File fileOne=new File(fileOnePath);
        File fileTwo=new File(fileTwoPath);
        FileInputStream fileOneIn=null;
        FileOutputStream fileTwoOut=null;
        if(!fileTwo.exists()){
            fileTwo.mkdirs();
            System.out.println("hello");
        }
        try {
            fileOneIn=new FileInputStream(fileOne);
            fileTwoOut=new FileOutputStream(new File(fileTwo.getAbsolutePath()+"\\"+fileOne.getName()));

            byte []bytes=new byte[1024];
            while (fileOneIn.read(bytes)!=-1){
                fileTwoOut.write(bytes);
            }
            System.out.println("文件复制成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("文件复制失败");
        }finally {
            try {
                fileOneIn.close();
                fileTwoOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String fileOnePath="D:\\java\\IO_FileTest\\fileOne\\data.png";
        String fileTwoPath="D:\\java\\IO_FileTest\\fileTwo";
        copyFile(fileOnePath,fileTwoPath);
    }
}
