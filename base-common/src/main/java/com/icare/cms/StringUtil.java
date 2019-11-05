package cn.gaoz.example;

/**
 * 字符串工具
 */
public class StringUtil {

    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str == null || str == "") {
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否不为空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        if (str != null && str != "") {
            return true;
        }
        return false;
    }

    public static String getUrl(String ip, int port) {
        return String.format("http://%s:%s", ip, port);
    }
}
