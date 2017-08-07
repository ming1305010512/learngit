package org.lm.FileOperation;

import java.io.*;

/**
 * Created by 龙鸣 on 2017/8/5.
 */
public class FileTestFour {
    //读取磁盘文件并显示在控制上
    public static  void readFile(String path){

        File file=new File(path);
        FileInputStream fileIn;
        try {
            fileIn=new FileInputStream(file);
//            InputStreamReader inputStreamReader=new InputStreamReader(fileIn,"UTF-8");
            byte []bytes=new byte[1024];
            while (fileIn.read(bytes)!=-1){

                String content=new String(bytes,"gbk");
                System.out.println("文件的内容："+content);
            }
            fileIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readFile("C:\\root\\fileOne.txt");
    }
}
