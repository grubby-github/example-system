package cn.gaoz.example;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String getCurrentDatetime() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }
}
