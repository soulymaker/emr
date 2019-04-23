package utils.str;


import java.util.Random;


/**
 * 随机数生成
 */
@SuppressWarnings("all")
public class RandomCodeUtil {
    private RandomCodeUtil() {
    }

    /**
     * 只有数字
     *
     * @param length 验证码长度
     * @return
     */
    public static String getTxtcodeWithoutAlphabet(int length) {
        long start = System.currentTimeMillis();
        Random random = new Random();
        String words = "123456789";
        StringBuffer sb2 = new StringBuffer();
        for (int i = 0; i < length; i++) {
            // 生成 length 位的随机数
            int index2 = random.nextInt(words.length());
            // 获得字母数字
            char m = words.charAt(index2);
            sb2.append(m);
        }
        long end = System.currentTimeMillis();
        return sb2.toString();
    }

    /**
     * 带字母和数字
     *
     * @param length 验证码长度
     * @return
     */
    public static String getTxtcodeWithAlphabet(int length) {
        long start = System.currentTimeMillis();
        Random random = new Random();
        String words = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer sb2 = new StringBuffer();
        for (int i = 0; i < length; i++) {
            // 生成 length 位的随机数
            int index2 = random.nextInt(words.length());
            // 获得字母数字
            char m = words.charAt(index2);
            sb2.append(m);
        }

        long end = System.currentTimeMillis();
        return sb2.toString();
    }

    /**
     * 只有字母
     *
     * @param length 验证码长度
     * @return
     */
    public static String getTxtcodeOnlyAlphabet(int length) {
        Random random = new Random();
        String words = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer sb2 = new StringBuffer();
        for (int i = 0; i < length; i++) {
            // 生成 length 位的随机数
            int index2 = random.nextInt(words.length());
            // 获得字母数字
            char m = words.charAt(index2);
            sb2.append(m);
        }
        return sb2.toString();
    }

}
