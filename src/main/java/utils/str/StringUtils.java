package utils.str;

/**
 * @author wanxintao
 * @date 2019/2/17 3:52 PM
 * @Version 1.0
 **/
public class StringUtils {
    public static String rstrip(String str) {
        char[] chars = str.toCharArray();
        int end = chars.length - 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            char ch = chars[i];
            if (ch == '\r') {
                end--;
                continue;
            } else if (ch == '\n') {
                end--;
                continue;
            } else if (ch == ' ') {
                end--;
                continue;
            }
            break;
        }
        return str.substring(0, end + 1);
    }
}
