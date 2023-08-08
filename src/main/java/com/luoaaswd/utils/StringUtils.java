package com.luoaaswd.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author luochenming
 * @date 2023/8/2
 */

@SuppressWarnings("unused")
public class StringUtils {

    /**
     * 替换字符串中IPv4形式的ip和端口号，例如 192.168.0.1:8080
     * @param originalStr 需要替换ip和端口号的原始字符串
     * @param ipAndPorts 新的ip和port字符串数组，按从原始字符串左到右的顺序替换直到未找到替换目标或者全部替换完成
     * @return 替换ip和端口号后的字符串
     */
    public static String replaceIPAndPort(String originalStr, String... ipAndPorts) {

        String pattern = "(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}):(\\d+)";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(originalStr);
        int index = 0;
        StringBuffer replacedStringBuffer = new StringBuffer();
        while (matcher.find() && index < ipAndPorts.length) {
            String replacedIpAndPort = ipAndPorts[index++];
            matcher.appendReplacement(replacedStringBuffer, replacedIpAndPort);
        }
        matcher.appendTail(replacedStringBuffer);
        return replacedStringBuffer.toString();
    }
}
