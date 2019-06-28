package com.smart.im.server.sdk.netty;

import com.smart.im.protocal.proto.MessageProtocalEntity;
import com.smart.im.server.sdk.Constant;
import com.smart.im.server.sdk.core.ServerCoreHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @date : 2019-06-27 15:02
 * @author: lichen
 * @email : 1960003945@qq.com
 * @description : 数据核心处理的管道
 */
public class UDPChannelInboundHandler extends ChannelInboundHandlerAdapter {

    private static Logger logger = LoggerFactory.getLogger(UDPChannelInboundHandler.class);


    private ServerCoreHandler serverCoreHandler=null;


    public UDPChannelInboundHandler(ServerCoreHandler serverCoreHandler) {
        this.serverCoreHandler = serverCoreHandler;
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable e) {
        try{
            serverCoreHandler.exceptionCaught(ctx, e);
        }catch (Exception e2){
            logger.error(Constant.LOGGER_NAME+e.getMessage().toString());
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        serverCoreHandler.sessionCreated(ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        serverCoreHandler.sessionClosed(ctx.channel());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx,  Object msg) throws Exception {
        MessageProtocalEntity.Protocal protocal=(MessageProtocalEntity.Protocal)msg;
        serverCoreHandler.msgRecevied(protocal);
    }
}
