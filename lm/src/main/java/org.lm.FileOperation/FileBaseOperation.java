package org.lm.FileOperation;


import java.io.File;
import java.io.IOException;

/**
 * Created by 龙鸣 on 2017/8/5.
 */
public class FileBaseOperation {
    //创建文件
    public static boolean createFile(String path){
//        "c:\\root\\myFileTest.txt"
        File file=new File(path);//创建文件

        boolean result=false;
        if(!file.exists()){
            try {
                result=file.createNewFile();//如果文件不存在创建一个新的文件，成功返回true

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return result;
    }
    //创建文件夹
    public static boolean createDirectory(String directory){

        boolean result =false;
        File file=new File(directory);//创建文件夹
        if(!file.exists()){
            result=file.mkdirs();//创建抽象路径命名的路径，不需要一定包含父目录

        }
        System.out.println("文件夹："+result);
        return result;
    }
    //删除文件
    public  static boolean deleteFile(String path){
        boolean result=false;
        File file=new File(path);
        if(file.exists()&&file.isFile()){//如果是文件并且文件存在，则删除
            result=file.delete();
        }
        if(result){
            System.out.println("文件删除成功");
        }else{
            System.out.println("文件删除失败");
        }
        return result;
    }
    //删除文件夹，删除到当前文件。例如此例删除到fileOne文件夹
    public static void delectDirectory(String filePath){
//        boolean result=false;
        File file=new File(filePath);
        if(!file.exists()){
            return ;
        }
        if(file.isFile()){//如果是文件，则删除文件，否则，就是删除目录
            file.delete();
        }else{
            File []files=file.listFiles();//获取该路径下的文件夹和文件，并返回一个数组
            for(File myFile:files){
                delectDirectory(filePath+"/"+myFile.getName());//传递一个要删除的文件夹
            }
            file.delete();//从路径最深层删除文件夹
        }
//        return  result;
    }

    public static void main(String[] args) {
        createFile("c:\\root\\myFileTest.txt");
//        createDirectory("c:\\myDirectory\\fileOne");
//        deleteFile("c:\\\\root\\\\myFileTest.txt");
//        delectDirectory("c:\\myDirectory\\fileOne");
    }

}
