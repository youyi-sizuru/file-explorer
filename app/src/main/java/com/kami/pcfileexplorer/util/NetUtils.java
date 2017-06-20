package com.kami.pcfileexplorer.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;

import com.kami.pcfileexplorer.Constants;

import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by youyi on 2017/4/24.
 */

public class NetUtils {

    public static InetAddress formatIpv4Address(int ipv4Address) throws UnknownHostException {
        byte[] bytes = BigInteger.valueOf(ipv4Address).toByteArray();
        return Inet4Address.getByAddress(bytes);
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
        short length = Constants.NET_MASK_MAX_LENGTH;
        while (length >= 0) {
            if ((netMask & 0x1) == 1) {
                break;
            }
            netMask = netMask >> 1;
            length--;
        }
        return length;
    }

    /**
     * check wifi is connected.
     *
     * @param context context
     * @return is wifi connected
     */
    public static boolean isWifiConnected(@NonNull Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI;
    }
}
