package org.lm.FileOperation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * Created by 龙鸣 on 2017/8/6.
 * problem discribe:使用随机文件流类RandomAccessFile将一个文本文件倒置读出。
 */
public class FileTestEight {
    //把文件倒置读出
    public  static  void readConvertFile(String filePath){

        File file=new File(filePath);
        try {
            RandomAccessFile randomAccessFile=new RandomAccessFile(file,"rw");
            long length=randomAccessFile.length();
            int count=0;//用于换行
            String tem=null;
            String value="";
            while ((tem=randomAccessFile.readLine())!=null){
                value=value+tem;

            }
            String content=new String(value.getBytes(),"UTF-8");
            System.out.println("字符串为："+content);
            System.out.println("倒序为：");
            char []c=content.toCharArray();//将读取的字符串转化为字符数组
            for(int i=c.length-1;i>=0;i--) {
                System.out.print(c[i]);
            }
            randomAccessFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
            /*while(0!=length--){
                randomAccessFile.seek(length);
                char ch=(char)randomAccessFile.read();
                System.out.print(ch);
                if(count==90){
                    System.out.println();
                }
                count++;
            }*/
//            randomAccessFile.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) {
        String filePath="C:\\root\\fileone.txt";
        readConvertFile(filePath);
    }
}
