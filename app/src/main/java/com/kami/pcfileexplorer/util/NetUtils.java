package com.kami.pcfileexplorer.util;

import android.text.format.Formatter;

import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by youyi on 2017/4/24.
 */

public class NetUtils {
    public static final short MAX_MASK_LENGTH = 32;

    public static InetAddress formatIpv4Address(int ipv4Address) throws UnknownHostException {
        byte[] bytes = BigInteger.valueOf(ipv4Address).toByteArray();
        InetAddress inetAddress = Inet4Address.getByAddress(bytes);
        return inetAddress;
    }

    public static int reversalIpv4Address(int Ipv4Address) {
        int reversalIp = 0;
        reversalIp += Ipv4Address << 24 & 0xFF000000;
        reversalIp += Ipv4Address << 8 & 0xFF0000;
        reversalIp += Ipv4Address >> 8 & 0xFF00;
        reversalIp += Ipv4Address >> 24 & 0xFF;
        return reversalIp;
    }

    public static short calculateMaskLength(int netMask) {
        short length = MAX_MASK_LENGTH;
        while (length >= 0) {
            if ((netMask & 0x1) == 1) {
                break;
            }
            netMask = netMask >> 1;
            length--;
        }
        return length;
    }
}
