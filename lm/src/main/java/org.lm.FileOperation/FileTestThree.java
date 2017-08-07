package org.lm.FileOperation;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by 龙鸣 on 2017/8/5.
 */
public class FileTestThree {
    //获取指定目录下所有的java文件
    public static void getAllFile(String directoryPath, ArrayList<String> fileNameList){
        File file=new File(directoryPath);
        File []files=file.listFiles();
        String []fileName=file.list();
        if(fileName!=null){
            for (String fileNameSub:fileName){
                if(fileNameSub.endsWith(".java")) {//如果是java文件，就加入集合
                    fileNameList.add(fileNameSub);
                }
            }
            for(File file1:files){
//                System.out.println("相对路径："+file1.getPath());
                getAllFile(file1.getPath(),fileNameList);
            }
        }
    }
    public static void main(String[] args) {

//        File file=new File("src");
        String path="src";
        ArrayList<String> fileNameList=new ArrayList();
        getAllFile("D:\\学习\\project\\lm",fileNameList);
        System.out.println("具有如下文件和目录:");
        for(String fileName:fileNameList){
            System.out.println(fileName);
        }
    }
}
