package com.kami.fileexplorer.util;


import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * author: youyi_sizuru
 * data: 2017/8/17
 */

public class CommonUtils {
    public static String[] FILE_LENGTH_UNITS = {"B", "KB", "MB", "GB", "TB", "PB"};

    public static String formatFileSize(long length) {
        String unit = "";
        float value = length;
        for (String fileUnit : FILE_LENGTH_UNITS) {
            unit = fileUnit;
            if (value < 1024f) {
                break;
            }
            value = value / 1024;
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.###");
        return decimalFormat.format(value) + unit;
    }

    public static String formatFileModifiedTime(long lastModified) {
        long now = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        if ((now - lastModified) / 1000 > 365 * 24 * 60 * 60) {
            dateFormat.applyPattern("yyyy年MM月dd日");
        } else {
            dateFormat.applyPattern("MM月dd日");
        }
        return dateFormat.format(new Date(lastModified));
    }
}
