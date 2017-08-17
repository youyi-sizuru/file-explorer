package com.kami.fileexplorer.bean;

/**
 * author: youyi_sizuru
 * data: 2017/7/23
 */

public class FileRoute {
    private String mName;
    private String mPath;

    public FileRoute(String name, String path) {
        this.mName = name;
        this.mPath = path;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getPath() {
        return mPath;
    }

    public void setPath(String mPath) {
        this.mPath = mPath;
    }

    @Override
    public String toString() {
        return "FileRoute{" +
                "mName='" + mName + '\'' +
                ", mPath='" + mPath + '\'' +
                '}';
    }
}
