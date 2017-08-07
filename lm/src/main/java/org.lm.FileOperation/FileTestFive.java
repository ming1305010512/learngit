package org.lm.FileOperation;

import java.io.*;

/**
 * Created by 龙鸣 on 2017/8/5.
 * Problem describe : 在程序中写一个"HelloJavaWorld你好世界"输出到操作系统文件Hello.txt文件中

 */
public class FileTestFive {

    //实现写文件
    public static  void writeFile(String path,String content){
        File file=new File(path);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream=new FileOutputStream(file);

            fileOutputStream.write(content.getBytes("gbk"));
            System.out.println("写入成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("写入失败");
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String content="HelloJavaWorld你好世界";
        String path="C:\\root\\Hello.txt";
        writeFile(path,content);
    }
}
