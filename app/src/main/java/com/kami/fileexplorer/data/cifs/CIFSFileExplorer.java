package com.kami.fileexplorer.data.cifs;

import com.kami.fileexplorer.bean.CIFSDevice;
import com.kami.fileexplorer.data.FileExplorer;

import java.io.Serializable;
import java.util.List;

/**
 * author: youyi_sizuru
 * data: 2017/7/23
 */

public class CIFSFileExplorer implements FileExplorer {
    private CIFSDevice mDevice;
    public CIFSFileExplorer(CIFSDevice device) {
        mDevice = device;
    }

    @Override
    public String getTitle() {
        return "网络邻居";
    }

    @Override
    public List<File> getRootFiles() {
        return null;
    }

    @Override
    public String getDeviceName() {
        return mDevice.getHostName();
    }

    public static class CIFSFile implements File{

    }
}
