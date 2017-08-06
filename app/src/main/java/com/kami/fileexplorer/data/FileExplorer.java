package com.kami.fileexplorer.data;


import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.List;

/**
 * author: youyi_sizuru
 * data: 2017/7/23
 */

public interface FileExplorer extends Serializable{
    List<File> getFiles(String path) throws IOException;
    String getDeviceName();
    String getTitle();
    interface File{
        String getName();
        boolean isDirectory();
        long length();
        long lastModified();
    }
}
