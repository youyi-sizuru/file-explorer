package com.kami.fileexplorer.bean;

/**
 * author: youyi_sizuru
 * data: 2017/7/23
 */

public class FileRoute {
    private String mName;
    private String mTag;

    public FileRoute(String name, String tag) {
        this.mName = name;
        this.mTag = tag;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getTag() {
        return mTag;
    }

    public void setTag(String tag) {
        this.mTag = tag;
    }

    @Override
    public String toString() {
        return "FileRoute{" +
                "mName='" + mName + '\'' +
                ", mTag='" + mTag + '\'' +
                '}';
    }
}
