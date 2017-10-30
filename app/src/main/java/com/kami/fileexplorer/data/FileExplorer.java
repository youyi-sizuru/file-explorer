package com.kami.fileexplorer.data;


import com.kami.fileexplorer.exception.AuthException;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.List;

/**
 * author: youyi_sizuru
 * data: 2017/7/23
 */

public interface FileExplorer extends Serializable{
    public static final String CIFS = "cifs";
    List<File> getFiles(String path) throws IOException;
    String getDeviceName();
    String getTitle();
    void setAuth(String[] auth);
    interface File{
        String getName();
        boolean isDirectory();
        long length();
        long lastModified();
    }
}
