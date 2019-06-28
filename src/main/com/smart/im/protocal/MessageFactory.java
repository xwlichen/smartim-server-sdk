package com.smart.im.protocal;

import com.google.protobuf.InvalidProtocolBufferException;
import com.smart.im.protocal.proto.MessageProtocalEntity;
import com.smart.im.protocal.proto.ProtocalTypeEntity;


/**
 * @date : 2018/8/10 10:54
 * @author: lichen
 * @email : 1960003945@qq.com
 * @description :协议解析
 */

public class MessageFactory {

    public final static String SERVER_ID = "0";


    /**
     * byte[]解析成Protocal
     *
     * @param bytes 数据
     * @return 消息
     */
    public static MessageProtocalEntity.Protocal parseBytesToProtocal(byte[] bytes) {
        return MessageFactory.parse(bytes);
    }


    /**
     * ProtoBuf序列化bytes转protocal
     *
     * @param bytes 数据
     * @return 消息
     */
    public static MessageProtocalEntity.Protocal parse(byte[] bytes) {
        MessageProtocalEntity.Protocal protocal = null;
        try {
            protocal = MessageProtocalEntity.Protocal.parseFrom(bytes);
            return protocal;
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 创建连接（登录）
     *
     * @param userId 用户id
     * @param data   其他相关内容
     * @return 消息
     */
    public static MessageProtocalEntity.Protocal createConnect(String userId, String data) {
        MessageProtocalEntity.Protocal.Builder msgBuilder = MessageProtocalEntity.Protocal.newBuilder();
        MessageProtocalEntity.Header.Builder headerBuilder = MessageProtocalEntity.Header.newBuilder();

        headerBuilder.setProtocalType(ProtocalTypeEntity.ProtocalType.CONNECT);
        headerBuilder.setFrom(SERVER_ID);
        headerBuilder.setTo(userId);

        msgBuilder.setHeader(headerBuilder.build());
        msgBuilder.setBody(data);

        return msgBuilder.build();

    }

    /**
     * 创建连接回应
     *
     * @param toUserId 目标用户ID
     * @param data     相关内容
     * @param msgId    消息的ID
     * @return 消息
     */
    public static MessageProtocalEntity.Protocal createConnAck(String toUserId, String data, String msgId) {


        MessageProtocalEntity.Protocal.Builder msgBuilder = MessageProtocalEntity.Protocal.newBuilder();
        MessageProtocalEntity.Header.Builder headerBuilder = MessageProtocalEntity.Header.newBuilder();

        headerBuilder.setProtocalType(ProtocalTypeEntity.ProtocalType.CONNACK);
        headerBuilder.setFrom(SERVER_ID);
        headerBuilder.setTo(toUserId);
        headerBuilder.setQoS(true);
        headerBuilder.setId(msgId);
        headerBuilder.setTypeu(-1);

        msgBuilder.setHeader(headerBuilder.build());
        msgBuilder.setBody(data);


        return msgBuilder.build();

    }

    /**
     * 创建发送信息
     *
     * @param body       相关内容
     * @param fromUserId 来源用户ID
     * @param toUserId   目标用户ID
     * @param QoS        是否心跳
     * @param msgId      消息ID
     * @param typeu      typeu
     * @return 消息
     */
    public static MessageProtocalEntity.Protocal createPublish(String body, String fromUserId, String toUserId
            , boolean QoS, String msgId, int typeu) {
        MessageProtocalEntity.Protocal.Builder msgBuilder = MessageProtocalEntity.Protocal.newBuilder();
        MessageProtocalEntity.Header.Builder headerBuilder = MessageProtocalEntity.Header.newBuilder();

        headerBuilder.setProtocalType(ProtocalTypeEntity.ProtocalType.PUBLISH);
        headerBuilder.setFrom(fromUserId);
        headerBuilder.setTo(toUserId);
        headerBuilder.setQoS(QoS);
        headerBuilder.setId(msgId);
        headerBuilder.setTypeu(typeu);

        msgBuilder.setHeader(headerBuilder.build());
        msgBuilder.setBody(body);

        return msgBuilder.build();

    }


    /**
     * 创建发送消息回应
     *
     * @param fromUserId 来源用户ID
     * @param toUserId   目标用户ID
     * @param msgId      消息ID
     * @return 消息
     */
    public static MessageProtocalEntity.Protocal createPubAck(String fromUserId, String toUserId
            , String msgId) {
        return createPubAck(fromUserId, toUserId, msgId, false);
    }


    /**
     * 创建发送消息回应
     *
     * @param fromUserId 来源用户ID
     * @param toUserId   目标用户ID
     * @param msgId      消息ID
     * @param bridge     是否桥接跨域
     * @return 消息
     */
    public static MessageProtocalEntity.Protocal createPubAck(String fromUserId, String toUserId
            , String msgId, boolean bridge) {


        MessageProtocalEntity.Protocal.Builder msgBuilder = MessageProtocalEntity.Protocal.newBuilder();
        MessageProtocalEntity.Header.Builder headerBuilder = MessageProtocalEntity.Header.newBuilder();

        headerBuilder.setProtocalType(ProtocalTypeEntity.ProtocalType.PUBACK);
        headerBuilder.setFrom(fromUserId);
        headerBuilder.setTo(toUserId);
        headerBuilder.setId(msgId);
        headerBuilder.setBridge(bridge);

        msgBuilder.setHeader(headerBuilder.build());

        return msgBuilder.build();

    }


    /**
     * 创建收到的消息
     *
     * @param body 消息体内容
     * @param fromUserId 来源用户ID
     * @param toUserId 目标用户ID
     * @param QoS 心跳
     * @param msgId 消息ID
     * @param typeu typeu
     * @return 消息
     */
    public static MessageProtocalEntity.Protocal createReceive(String body, String fromUserId, String toUserId
            , boolean QoS, String msgId, int typeu) {
        MessageProtocalEntity.Protocal.Builder msgBuilder = MessageProtocalEntity.Protocal.newBuilder();
        MessageProtocalEntity.Header.Builder headerBuilder = MessageProtocalEntity.Header.newBuilder();

        headerBuilder.setProtocalType(ProtocalTypeEntity.ProtocalType.RECEIVE);
        headerBuilder.setFrom(fromUserId);
        headerBuilder.setTo(toUserId);
        headerBuilder.setQoS(QoS);
        headerBuilder.setId(msgId);
        headerBuilder.setTypeu(typeu);

        msgBuilder.setHeader(headerBuilder.build());
        msgBuilder.setBody(body);

        return msgBuilder.build();
    }


    /**
     * 收到消息的回应
     * @param fromUserId 来源用户ID
     * @param toUserId 用户ID
     * @param msgId 消息ID
     * @param bridge 是否跨域桥接
     * @return 消息
     */
    public static MessageProtocalEntity.Protocal createReceAck(String fromUserId, String toUserId
            , String msgId, boolean bridge) {


        MessageProtocalEntity.Protocal.Builder msgBuilder = MessageProtocalEntity.Protocal.newBuilder();
        MessageProtocalEntity.Header.Builder headerBuilder = MessageProtocalEntity.Header.newBuilder();

        headerBuilder.setProtocalType(ProtocalTypeEntity.ProtocalType.RECEACK);
        headerBuilder.setFrom(fromUserId);
        headerBuilder.setTo(toUserId);
        headerBuilder.setId(msgId);
        headerBuilder.setBridge(bridge);

        msgBuilder.setHeader(headerBuilder.build());

        return msgBuilder.build();

    }


    /**
     * 创建心跳请求
     *
     * @param fromUserId 来源用户ID
     * @param body       相关内容
     * @return 消息
     */
    public static MessageProtocalEntity.Protocal createPingReq(String fromUserId, String body) {
        MessageProtocalEntity.Protocal.Builder msgBuilder = MessageProtocalEntity.Protocal.newBuilder();
        MessageProtocalEntity.Header.Builder headerBuilder = MessageProtocalEntity.Header.newBuilder();

        headerBuilder.setProtocalType(ProtocalTypeEntity.ProtocalType.PINGREQ);
        headerBuilder.setFrom(fromUserId);
        headerBuilder.setTo(SERVER_ID);

        msgBuilder.setHeader(headerBuilder.build());
        msgBuilder.setBody(body);

        return msgBuilder.build();
    }


    /**
     * 创建心跳回应
     *
     * @param toUserId 目标用户ID
     * @param body     相关内容
     * @return 消息
     */
    public static MessageProtocalEntity.Protocal createPingResp(String toUserId, String body) {
        MessageProtocalEntity.Protocal.Builder msgBuilder = MessageProtocalEntity.Protocal.newBuilder();
        MessageProtocalEntity.Header.Builder headerBuilder = MessageProtocalEntity.Header.newBuilder();

        headerBuilder.setProtocalType(ProtocalTypeEntity.ProtocalType.PINGRESP);
        headerBuilder.setFrom(SERVER_ID);
        headerBuilder.setTo(toUserId);

        msgBuilder.setHeader(headerBuilder.build());
        msgBuilder.setBody(body);

        return msgBuilder.build();
    }


    /**
     * 创建错误返回
     *
     * @param toUserId 目标用户ID
     * @param body     相关内容
     * @return 消息
     */
    public static MessageProtocalEntity.Protocal createErrorResp(String toUserId, String body) {
        MessageProtocalEntity.Protocal.Builder msgBuilder = MessageProtocalEntity.Protocal.newBuilder();
        MessageProtocalEntity.Header.Builder headerBuilder = MessageProtocalEntity.Header.newBuilder();

        headerBuilder.setProtocalType(ProtocalTypeEntity.ProtocalType.ERRORESP);
        headerBuilder.setFrom(SERVER_ID);
        headerBuilder.setTo(toUserId);

        msgBuilder.setHeader(headerBuilder.build());
        msgBuilder.setBody(body);

        return msgBuilder.build();

    }


    /**
     * 创建断开连接
     *
     * @param fromUserId 来源用户ID
     * @return 消息
     */
    public static MessageProtocalEntity.Protocal createDisConnect(String fromUserId) {
        MessageProtocalEntity.Protocal.Builder msgBuilder = MessageProtocalEntity.Protocal.newBuilder();
        MessageProtocalEntity.Header.Builder headerBuilder = MessageProtocalEntity.Header.newBuilder();

        headerBuilder.setProtocalType(ProtocalTypeEntity.ProtocalType.DISCONNET);
        headerBuilder.setFrom(fromUserId);
        headerBuilder.setTo(SERVER_ID);

        msgBuilder.setHeader(headerBuilder.build());

        return msgBuilder.build();
    }


}
