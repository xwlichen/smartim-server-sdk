package com.smart.im.server.sdk.netty;

import com.smart.im.server.sdk.core.ServerCoreHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;

/**
 * @date : 2019-06-26 14:34
 * @author: lichen
 * @email : 1960003945@qq.com
 * @description : netty的一些handler初始化
 */
public class UDPChannelInitializerHandler extends ChannelInitializer<Channel> {

    private ServerCoreHandler serverCoreHandler;

    public UDPChannelInitializerHandler(ServerCoreHandler serverCoreHandler) {
        this.serverCoreHandler = serverCoreHandler;
    }

    protected void initChannel(Channel channel) throws Exception {

    }
}
