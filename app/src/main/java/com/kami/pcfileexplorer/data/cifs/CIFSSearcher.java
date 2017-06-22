package com.kami.pcfileexplorer.data.cifs;

import com.kami.pcfileexplorer.util.NetUtils;
import com.kami.pcfileexplorer.util.schedulers.SchedulerProvider;

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

    public Flowable<String> searchDevices(int hostAddress) {
        return Flowable.just(hostAddress)
                .map(host -> NetUtils.reversalIpv4Address(host))
                .flatMap(host -> {
                    short netMaskLength = NetUtils.getNetMask(host);
                    if (netMaskLength == 0) {
                        throw new Exception("net mask is 0");
                    }
                    int offset = 32 - netMaskLength;
                    int startIp = (host >> offset << offset) + 2;
                    int endIp = (startIp | ((1 << offset) - 1)) - 2;
                    int count = 0;
                    if (endIp < startIp) {
                        count = startIp - endIp;
                        startIp = endIp;
                    } else {
                        count = endIp - startIp;
                    }
                    return checkDevices(startIp, count);
                });
    }

    private Flowable<String> checkDevices(int startIp, int count) {
        return Flowable.range(startIp, count)
                .map(hostIp -> NetUtils.formatIpv4Address(hostIp).getHostAddress())
                .flatMap(hostIp -> Flowable.just(hostIp)
                        .filter(ip -> this.canConnect(hostIp))
                        .map(ip -> {
                            NbtAddress[] addresses = NbtAddress.getAllByAddress(hostIp);
                            if (addresses == null || addresses.length == 0) {
                                return hostIp;
                            } else {
                                return addresses[0].getHostName();
                            }
                        })
                        .subscribeOn(SchedulerProvider.getInstance().io()));
    }

    private boolean canConnect(String hostIp) throws IOException {
        Socket socket = null;
        try {
            socket = new Socket();
            InetSocketAddress address = new InetSocketAddress(hostIp, 445);
            socket.connect(address, 500);
            return true;
        } catch (IOException e) {
            return false;
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
