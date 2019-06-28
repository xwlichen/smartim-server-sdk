package com.smart.im.server.sdk.core;

import com.smart.im.protocal.proto.MessageProtocalEntity;
import com.smart.im.server.sdk.Constant;
import com.smart.im.server.sdk.processor.OnlineProcessor;
import com.smart.im.server.sdk.utils.ServerToolKits;
import com.smart.im.server.sdk.utils.TextUtils;
import com.sun.corba.se.impl.activation.ServerTool;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @date : 2019-06-26 11:01
 * @author: lichen
 * @email : 1960003945@qq.com
 * @description :
 */
public class ServerCoreHandler {
    private static Logger logger = LoggerFactory.getLogger(ServerCoreHandler.class);


    public void msgRecevied(MessageProtocalEntity.Protocal protocal) {
        dispathcMsg(protocal);


    }

    public void sessionCreated(Channel session) throws Exception {
        logger.info(Constant.LOGGER_NAME + ServerToolKits.clientInfoToString(session) + "的会话建立(channelActive)了...");
    }

    public void sessionClosed(Channel session) throws Exception {

        if (session != null) {
            String uid = OnlineProcessor.getUserIdFromSession(session);
            if (!TextUtils.isEmpty(uid)) {
                logger.warn(Constant.LOGGER_NAME + ServerToolKits.clientInfoToString(session) +
                        "的会话已关闭(uid=" + uid + ")了...");
                Channel sessionOnline = OnlineProcessor.getInstance().getOnlineSession(uid);
                if (session == sessionOnline) {
                    OnlineProcessor.getInstance().removeOnlineSession(uid);
                } else {
                    logger.warn(Constant.LOGGER_NAME + "会话" + ServerToolKits.clientInfoToString(session)
                            + "不在在线列表中，意味着它是被客户端弃用的，本次忽略这条关闭事件即可！");
                }
            } else {
                logger.info(Constant.LOGGER_NAME + "[会话]" + ServerToolKits.clientInfoToString(session) +
                        "被系统close，但是在没有在服务器中存放uid");

            }
        }

    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error(Constant.LOGGER_NAME + "此客户端的Channel抛出了exceptionCaught，原因是：" + cause.getMessage() + "，可以提前close掉了哦！", cause);
        if (ctx != null) {
            Channel channel = ctx.channel();
            if (channel != null) {
                channel.close();
            }
            ctx.close();
        }

    }


    protected void dispathcMsg(MessageProtocalEntity.Protocal protocal) {
        if (protocal == null) {
            return;
        }

        switch (protocal.getHeader().getProtocalType()) {
            case CONNECT:

                break;
            case CONNACK:
                LogUtils.d(TAG, "登陆等相关验证信息验证成功");
                //添加netty心跳管理，发送心跳信息
                clientCoreWrapper.configureKeepAliveHandler();
                break;
            case PUBLISH:
                break;
            case PUBACK:
                LogUtils.d(TAG, "收到服务端的发送响应包");
                break;
            case RECEIVE:
                LogUtils.d(TAG, "收到服务端的发送的消息");
                MessageProtocalEntity.Protocal msg = clientCoreWrapper.createReciveAckMsg();
                clientCoreWrapper.sendMsg(msg, true);
                clientCoreWrapper.receivedMsg(protocal);
                break;
            case RECEACK:
                break;
            case PINGREQ:
                break;
            case PINGRESP:
                LogUtils.d("收到服务断心跳响应消息，message=" + protocal.getHeader().getId()
                        + "当前心跳间隔为：" + getClientCoreWrapper().createKeepAliveMsg() + "ms");
                break;
            case ERRORESP:
                handleError(protocal);
                break;
            case DISCONNET:
                if (clientCoreWrapper.getOnConnectListener() != null) {
                    clientCoreWrapper.getOnConnectListener().onConnectStatus(ConfigEntity.CONNECT_STATE_BROKEN);
                }
                break;
            case UNRECOGNIZED:
            default:
                break;

        }
    }
}
