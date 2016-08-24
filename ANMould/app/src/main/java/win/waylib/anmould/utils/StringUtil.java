package win.waylib.anmould.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 处理字符串的工具类
 *
 * @date 2016-1-15 下午2:13:39
 */
public class StringUtil {

    /**
     * 判断一个字符串是否为null或长度为0或是空格符
     *
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {

        return (str == null || str.trim().length() == 0);
    }

    /**
     * 判断一个字符串是否为null或长度为0
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {

        return (str == null || str.trim().length() == 0);
    }

    /**
     * 比较两个字符串
     *
     * @param actual
     * @param expected
     * @return 一样则返回true, 否则返回false
     */
    public static boolean isEquals(String actual, String expected) {

        return actual == expected || (actual == null ? expected == null : actual.equals(expected));
    }

    /**
     * 把为null的String对象转成空字符串
     *
     * @param str
     * @return
     */
    public static String nullStrToEmpty(String str) {

        return (str == null ? "" : str);
    }

    /**
     * 判断是否是手机号
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobileNo(String mobiles) {
        Pattern p = Pattern.compile("^((13[0-9])|(14[0-9])|(15[^4,\\D])|(17[0-9])|(18[0,2,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }


    /**
     * 判断是否是邮箱
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        Pattern p = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * 汉字转拼音缩写
     *
     * @param str 要转换的汉字字符串
     * @return String 拼音缩写
     */
    public static String getPYString(String str) {
        String tempStr = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 33 && c <= 126) {// 字母和符号原样保留
                tempStr += String.valueOf(c);
            } else {// 累加拼音声母
                tempStr += getPYChar(String.valueOf(c));
            }
        }
        return tempStr;
    }

    public static boolean isStrArrayContains(String[] array, String str) {
        if (array == null || isBlank(str)) {
            return false;
        }
        for (String s : array) {
            if (s.equals(str.trim())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 取单个字符的拼音声母
     *
     * @param c 要转换的单个汉字
     * @return String 拼音声母
     */
    public static String getPYChar(String c) {
        byte[] array = new byte[2];
        array = String.valueOf(c).getBytes();
        int i = (short) (array[0] - '\0' + 256) * 256 + ((short) (array[1] - '\0' + 256));
        if (i < 0xB0A1)
            return "*";
        if (i < 0xB0C5)
            return "a";
        if (i < 0xB2C1)
            return "b";
        if (i < 0xB4EE)
            return "c";
        if (i < 0xB6EA)
            return "d";
        if (i < 0xB7A2)
            return "e";
        if (i < 0xB8C1)
            return "f";
        if (i < 0xB9FE)
            return "g";
        if (i < 0xBBF7)
            return "h";
        if (i < 0xBFA6)
            return "j";
        if (i < 0xC0AC)
            return "k";
        if (i < 0xC2E8)
            return "l";
        if (i < 0xC4C3)
            return "m";
        if (i < 0xC5B6)
            return "n";
        if (i < 0xC5BE)
            return "o";
        if (i < 0xC6DA)
            return "p";
        if (i < 0xC8BB)
            return "q";
        if (i < 0xC8F6)
            return "r";
        if (i < 0xCBFA)
            return "s";
        if (i < 0xCDDA)
            return "t";
        if (i < 0xCEF4)
            return "w";
        if (i < 0xD1B9)
            return "x";
        if (i < 0xD4D1)
            return "y";
        if (i < 0xD7FA)
            return "z";
        return "*";
    }
}
