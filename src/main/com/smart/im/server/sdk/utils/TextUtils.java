package com.smart.im.server.sdk.utils;

/**
 * @date : 2019-06-27 15:37
 * @author: lichen
 * @email : 1960003945@qq.com
 * @description :
 */
public class TextUtils {


    /**
     * 判断字符串为空
     * @param text
     * @return
     */
    public static boolean isEmpty(String text) {
        if (text == null) {
            return true;
        }
        if ("".equals(text.trim())) {
            return true;
        }

        return false;

    }
}
