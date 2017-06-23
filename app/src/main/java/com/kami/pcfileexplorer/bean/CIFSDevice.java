package com.kami.pcfileexplorer.bean;

import com.google.common.base.Objects;

/**
 * author: youyi_sizuru
 * data: 2017/6/23
 */

public class CIFSDevice implements Device {
    private String mHostIp;
    private String mHostName;

    public CIFSDevice(String hostIp, String hostName) {
        this.mHostIp = hostIp;
        this.mHostName = hostName;
    }

    public String getHostIp() {
        return mHostIp;
    }

    public void setHostIp(String hostIp) {
        this.mHostIp = hostIp;
    }

    public String getHostName() {
        return mHostName;
    }

    public void setHostName(String hostName) {
        this.mHostName = hostName;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mHostIp, mHostName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        CIFSDevice device = (CIFSDevice) obj;
        return Objects.equal(device.getHostIp(), mHostIp) &&
                Objects.equal(device.getHostName(), mHostName);
    }

    @Override
    public String toString() {
        return String.format("hostIp: %s, hostName: %s", mHostIp, mHostName);
    }
}
