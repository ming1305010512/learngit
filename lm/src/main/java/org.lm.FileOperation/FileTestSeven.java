package org.lm.FileOperation;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 龙鸣 on 2017/8/5.
 * problem discribe:统计一个txt文件中各个字母出现次数：
 */
public class FileTestSeven {
    //统计次数的方法
    public static void getCharacterCountFromFile(String filePath, HashMap<String,Integer> map){
        File file=new File(filePath);
        FileInputStream fileIn=null;
        InputStreamReader inputStreamReader=null;
        BufferedReader bufferedReader=null;
        try {
            fileIn=new FileInputStream(file);
            inputStreamReader=new InputStreamReader(fileIn,"UTF-8");
            bufferedReader=new BufferedReader(inputStreamReader);
//            char []chars=new char[1024];
            String tem=null;
            String value="";
            while ((tem=bufferedReader.readLine())!=null){
                value=value+tem;

            }
            System.out.println("字符串为："+value);
            char []c=value.toCharArray();//将读取的字符串转化为字符数组
            for(int i=0;i<c.length;i++) {
                String key=String.valueOf(c[i]);
                if (map.containsKey(key)) {
                    int val = map.get(key);
                    map.put(key, val + 1);
                } else {
                    map.put(key, 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
                inputStreamReader.close();
                fileIn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String filePath="C:\\root\\fileOne.txt";
        HashMap<String ,Integer> map=new HashMap<String ,Integer>();
        getCharacterCountFromFile(filePath,map);
        for (Map.Entry entry:map.entrySet()){
            System.out.print(entry.getKey()+"("+entry.getValue()+")"+" ");
        }
    }
}
