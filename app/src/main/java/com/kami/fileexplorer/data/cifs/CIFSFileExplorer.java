package com.kami.fileexplorer.data.cifs;

import com.kami.fileexplorer.data.FileExplorer;

import java.io.Serializable;
import java.util.List;

/**
 * author: youyi_sizuru
 * data: 2017/7/23
 */

public class CIFSFileExplorer implements FileExplorer,Serializable {
    public CIFSFileExplorer(String ip) {
    }

    @Override
    public List<File> getRootFiles() {
        return null;
    }

    public static class CIFSFile implements File{

    }
}
