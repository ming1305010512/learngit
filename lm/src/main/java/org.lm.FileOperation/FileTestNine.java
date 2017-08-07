package org.lm.FileOperation;

import java.io.*;

/**
 * Created by 龙鸣 on 2017/8/6.
 * problem discribe:编写一个Java应用程序，可以实现Dos中的type命令，并加上行号。
 * 即将文本文件在控制台上显示出来，并在每一行的前面加上行号
 */
public class FileTestNine {
    //将文本文件在控制台上显示，并加上行号
    public  static  void printFile(String filename){
        File file=new File(filename);
        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            int count=1;
            String content="";
            while ((content=bufferedReader.readLine())!=null){
                System.out.print(count+":");
                System.out.println(content);
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //将命令解析为需要的路劲
    public static String[] parseStringToPath(String command){

        String []commandArray=new String[2];
        String command1=command.trim();//将命令的前后空格去掉;
//        System.out.println("命令为："+command1);
        String commandType=command1.substring(0,4);//得到命令类型
//        System.out.println("命令类型："+commandType);
        String pathOne=command1.substring(4);//得到前面有空格的路径
        String pathTwo=pathOne.trim();
        commandArray[0]=commandType;
        commandArray[1]=pathTwo;
        return commandArray;
    }
    //输入命令，并返回
    public  static String inputCommand(){

        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String command="";
        try {
            command=bf.readLine();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return command;
    }

    public static void main(String[] args) {
        String filePath="type C:\\root\\fileone.txt";
        String command="";
        String []commandArray=new String [2];
//        command = inputCommand();
//        commandArray = parseStringToPath(command);
//        System.out.println(commandArray[0]);
//        System.out.println(commandArray[1]);
        while (true) {
            command = inputCommand();
            commandArray = parseStringToPath(command);
            if (!"type".equals(commandArray[0])) {
                System.out.println("命令不正确，请重新输入");
            }else {
                printFile(commandArray[1]);
                return ;
            }
        }
    }
}
