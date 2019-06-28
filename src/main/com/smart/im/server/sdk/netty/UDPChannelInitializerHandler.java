package com.smart.im.server.sdk.netty;

import com.smart.im.protocal.proto.MessageProtocalEntity;
import com.smart.im.server.sdk.core.ServerCoreHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;

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

        //获取管道
        ChannelPipeline pipeline = channel.pipeline();

        pipeline.addLast(new ProtobufDecoder(MessageProtocalEntity.Protocal.getDefaultInstance()));
        pipeline.addLast(new ProtobufEncoder());

    }
}
