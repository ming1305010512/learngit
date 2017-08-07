package org.lm.FileOperation;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by 龙鸣 on 2017/8/6.
 * problem discribe:查看D盘中所有的文件和文件夹名称，并且使用名称升序降序，文件夹在前和文件夹在
 * 后，文件大小排序等。
 */
public class FileTestEleven {
    //获取所有的文件
    public static void getAllFile(String directoryPath,ArrayList<File> fileList){
        File file=new File(directoryPath);
        File []files=file.listFiles();
        String []fileName=file.list();
        if(files!=null){
            fileList.addAll(Arrays.asList(files));
            for(File file1:files){
                if(file1.isDirectory()){
                    getAllFile(file1.getAbsolutePath(),fileList);
                }
            }
        }
    }


    public static void main(String[] args) {
        ArrayList<File> arrayList=new ArrayList<File>();
        String path="c:\\root";
        getAllFile(path,arrayList);
        Collections.sort(arrayList,new FileSorted());//按文件大小排序
        System.out.println("按文件大小排序");
        for(File file:arrayList){
            System.out.println(file.getName());
        }
        System.out.println("按名称升序排序");
        Collections.sort(arrayList, new Comparator<File>() {
            @Override
            public int compare(File file1, File file2) {
                String s1 = file1.getName();
                String s2 = file2.getName();
                int n1 = s1.length();
                int n2 = s2.length();
                int min = Math.min(n1, n2);
                for (int i = 0; i < min; i++) {
                    char c1 = s1.charAt(i);
                    char c2 = s2.charAt(i);
                    if (c1 != c2) {
                        c1 = Character.toUpperCase(c1);
                        c2 = Character.toUpperCase(c2);
                        if (c1 != c2) {
                            c1 = Character.toLowerCase(c1);
                            c2 = Character.toLowerCase(c2);
                            if (c1 != c2) {
                                // No overflow because of numeric promotion
                                return c1 - c2;
                            }
                        }
                    }
                }
                return n1 - n2;
            }
        });
        for(File file:arrayList){
            System.out.println(file.getName());
        }
        System.out.println("文件夹在前");
        ArrayList<File> arrayListDerectory=new ArrayList<File>();
        ArrayList<File> arrayListFile=new ArrayList<File>();
        for(File file:arrayList){
            if (file.isDirectory()){
                arrayListDerectory.add(file);
            }
            if (file.isFile()){
                arrayListFile.add(file);
            }
        }
        for(File file:arrayListDerectory){
            System.out.println(file.getName());
        }
        for(File file:arrayListFile){
            System.out.println(file.getName());
        }
        System.out.println("文件夹在后");
        for(File file:arrayListFile){
            System.out.println(file.getName());
        }
        for(File file:arrayListDerectory){
            System.out.println(file.getName());
        }
    }
}
