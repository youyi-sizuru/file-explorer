package com.kami.pcfileexplorer.data.cifs;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

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

    public Observable<String> searchDevices() {
        return Observable.just(0).map(text -> {
//            System.setProperty("jcifs.smb.client.useExtendedSecurity", "false");
//            NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("", "", "");

            try {
                Socket socket = new Socket();
                InetSocketAddress address = new InetSocketAddress("192.168.16.112", 445);
                socket.connect(address, 500);
                socket.close();
                return "success";
            } catch (IOException e) {
                return "fail";
            }

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
