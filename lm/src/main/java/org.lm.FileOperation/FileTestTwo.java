package org.lm.FileOperation;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 龙鸣 on 2017/8/5.
 */
public class FileTestTwo {

    //获取指定目录下的所有文件和文件夹
    public static void getAllFileName(String directoryPath,ArrayList<String> fileNameList){
        File file=new File(directoryPath);
        File []files=file.listFiles();
        String []fileName=file.list();
        if(files!=null){
            fileNameList.addAll(Arrays.asList(fileName));
            for(File file1:files){
                if(file1.isDirectory()){
                    getAllFileName(file1.getAbsolutePath(),fileNameList);
                }
            }
        }
    }
    public static void main(String[] args) {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        try {
            String filePath=bufferedReader.readLine();

            ArrayList<String> fileNameList=new ArrayList<String>();
            getAllFileName(filePath,fileNameList);
            System.out.println("具有如下文件和目录:");
            for(String fileName:fileNameList){
                System.out.println(fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
