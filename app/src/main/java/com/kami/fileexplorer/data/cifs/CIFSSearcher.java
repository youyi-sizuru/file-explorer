package com.kami.fileexplorer.data.cifs;

import com.kami.fileexplorer.bean.CIFSDevice;
import com.kami.fileexplorer.util.NetUtils;
import com.kami.fileexplorer.util.schedulers.SchedulerProvider;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import io.reactivex.Flowable;
import jcifs.netbios.NbtAddress;


/**
 *
 */
public class CIFSSearcher {
    private static final CIFSSearcher ourInstance = new CIFSSearcher();

    public static CIFSSearcher getInstance() {
        return ourInstance;
    }

    private CIFSSearcher() {
    }

    public Flowable<CIFSDevice> searchDevices(int hostAddress) {
        return Flowable.just(hostAddress)
                .map(NetUtils::reversalIpv4Address)
                .flatMap(host -> {
                    short netMaskLength = NetUtils.getNetMask(host);
                    if (netMaskLength == 0) {
                        throw new Exception("net mask is 0");
                    }
                    int offset = 32 - netMaskLength;
                    int startIp = (host >> offset << offset) + 1;
                    int endIp = (startIp | ((1 << offset) - 1)) - 1;
                    int count = endIp - startIp;
                    return checkDevices(startIp, count);
                });
    }

    private Flowable<CIFSDevice> checkDevices(int startIp, int count) {
        return Flowable.range(startIp, count)
                .map(hostIp -> NetUtils.formatIpv4Address(hostIp).getHostAddress())
                .flatMap(hostIp -> Flowable.just(hostIp)
                        .filter(this::canConnect)
                        .map(ip -> {
                            String hostName = ip;
                            NbtAddress[] addresses = NbtAddress.getAllByAddress(ip);
                            if (addresses != null && addresses.length > 0) {
                                for (NbtAddress address : addresses) {
                                    if (address.getNameType() != 0x00 && !address.getHostName().startsWith("IS~")) {
                                        hostName = address.getHostName();
                                        break;
                                    }
                                }
                            }
                            return new CIFSDevice(ip, hostName);
                        })
                        .subscribeOn(SchedulerProvider.getInstance().io()));
    }

    private boolean canConnect(String hostIp) {
        Socket socket = null;
        try {
            socket = new Socket();
            InetSocketAddress address = new InetSocketAddress(hostIp, 445);
            socket.connect(address, 1000);
            return true;
        } catch (IOException e) {
            return false;
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
