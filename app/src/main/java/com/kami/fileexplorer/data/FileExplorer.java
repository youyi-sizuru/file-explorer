package com.kami.fileexplorer.data;


import java.io.Serializable;
import java.util.List;

/**
 * author: youyi_sizuru
 * data: 2017/7/23
 */

public interface FileExplorer extends Serializable{
    List<File> getRootFiles();
    String getDeviceName();
    String getTitle();
    interface File{

    }
}
