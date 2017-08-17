package com.kami.fileexplorer.comparable;

import com.kami.fileexplorer.data.FileExplorer;

import java.util.Comparator;

/**
 * author: youyi_sizuru
 * data: 2017/8/17
 */

public class DefaultFileComparator implements Comparator<FileExplorer.File> {
    @Override
    public int compare(FileExplorer.File file1, FileExplorer.File file2) {
        if(file1.isDirectory() && !file2.isDirectory()){
            return -1;
        }else if(file2.isDirectory() && !file1.isDirectory()){
            return 1;
        }
        else {
            return file1.getName().compareTo(file2.getName());
        }
    }
}
