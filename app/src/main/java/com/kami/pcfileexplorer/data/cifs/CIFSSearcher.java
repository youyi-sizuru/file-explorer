package com.kami.pcfileexplorer.data.cifs;

import com.kami.pcfileexplorer.Constants;
import com.kami.pcfileexplorer.util.NetUtils;

import java.io.IOException;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.Socket;

import io.reactivex.Flowable;
import io.reactivex.Observable;


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
                .map(host -> {
//            System.setProperty("jcifs.smb.client.useExtendedSecurity", "false");
//            NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("", "", "");
                    InetAddress inetAddress = Inet4Address.getByAddress(BigInteger.valueOf(host).toByteArray());
                    NetworkInterface networkInterface = NetworkInterface.getByInetAddress(inetAddress);
                    for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                        int length = interfaceAddress.getNetworkPrefixLength();
                        if (length > 0 && length <= Constants.NET_MASK_MAX_LENGTH) {
                            return String.valueOf(interfaceAddress.getNetworkPrefixLength());
                        }
                    }
                    return "0";
//            try {
//                Socket socket = new Socket();
//                InetSocketAddress address = new InetSocketAddress("192.168.16.112", 445);
//                socket.connect(address, 500);
//                socket.close();
//                return "success";
//            } catch (IOException e) {
//                return "fail";
//            }

//            SmbFile[] childFile = rootFile.listFiles();
//            int size = childFile == null ? 0 : childFile.length;
//            StringBuilder builder = new StringBuilder();
//            builder.append("size = " + size);
//            builder.append("\n");
//            for (int i = 0; i < size; i++) {
//                builder.append(childFile[i].getName() + "\n");
//            }
//            return builder.toString();
                });
    }
}
