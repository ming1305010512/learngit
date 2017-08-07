package org.lm.FileOperation;

import java.io.File;
import java.util.Comparator;

/**
 * Created by 龙鸣 on 2017/8/6.
 */
public class FileSorted implements Comparator<File>{
    @Override
    public int compare(File file1, File file2) {
        if (file1.length() > file2.length()) {
            return 1;
        } else if (file1.length() == file2.length()) {
            return 0;
        } else if (file1.length() < file2.length()) {
            return - 1;
        }
        return 0;
    }
}
