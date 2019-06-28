package com.smart.im.server.sdk.utils;

import com.smart.im.server.sdk.processor.OnlineProcessor;
import io.netty.channel.Channel;

import java.net.SocketAddress;

/**
 * @date : 2019-06-27 15:26
 * @author: lichen
 * @email : 1960003945@qq.com
 * @description :
 */
public class ServerToolKits {


    /**
     * 获取client端的信息如用户id
     * @param session
     * @return
     */
    public static String clientInfoToString(Channel session)
    {
        SocketAddress remoteAddress = session.remoteAddress();
        String s1 = remoteAddress.toString();
        StringBuilder sb = new StringBuilder()
                .append("{uid:")
                .append(OnlineProcessor.getUserIdFromSession(session))
                .append("}")
                .append(s1);
        return sb.toString();
    }
}
