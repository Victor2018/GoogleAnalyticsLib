package com.victor.analytics.library;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

/**
 * Created by Administrator on 2017/12/11.
 */

public class DateUtil {
    private static String TAG = "DateUtil";

    /**
     * 获取今天的日期
     * @return
     */
    public static String getTodayDate () {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String today = formatter.format(date);
        return today;
    }
}
