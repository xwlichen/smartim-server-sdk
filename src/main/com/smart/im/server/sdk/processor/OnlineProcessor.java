package com.smart.im.server.sdk.processor;

import com.smart.im.server.sdk.Constant;
import com.smart.im.server.sdk.core.ServerCoreHandler;
import com.smart.im.server.sdk.utils.TextUtils;
import io.netty.channel.Channel;
import io.netty.util.AttributeKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @date : 2019-06-27 15:22
 * @author: lichen
 * @email : 1960003945@qq.com
 * @description :
 */
public class OnlineProcessor {

    public final static String USER_ID_IN_SESSION_ATTRIBUTE = "__user_id__";
    public static final AttributeKey<String> USER_ID_IN_SESSION_ATTRIBUTE_ATTR =
            AttributeKey.newInstance(USER_ID_IN_SESSION_ATTRIBUTE);

    private static Logger logger = LoggerFactory.getLogger(OnlineProcessor.class);


    private static OnlineProcessor instance = null;
    private ConcurrentMap<String, Channel> onlineSessions = new ConcurrentHashMap<String, Channel>();


    public static OnlineProcessor getInstance() {
        if (instance == null) {
            instance = new OnlineProcessor();
        }
        return instance;
    }


    /**
     * 根据uid获取session
     *
     * @param uid
     * @return
     */
    public Channel getOnlineSession(String uid) {
        if (TextUtils.isEmpty(uid)) {
            logger.error(Constant.LOGGER_NAME + "getOnlineSession 时 uid为空");
            return null;
        }

        return onlineSessions.get(uid);
    }


    /**
     * 添加online session
     *
     * @param uid
     * @param session
     */
    public void putOnlineSession(String uid, Channel session) {
        if (onlineSessions.containsKey(uid)) {
            logger.warn(Constant.LOGGER_NAME + "用户id=" + uid + "已经在在线列表中了，session也是同一个吗？");
        }
        onlineSessions.put(uid, session);
        printOnline();
    }


    /**
     * 根据uid 删除online session
     * @param uid
     * @return
     */
    public boolean removeOnlineSession(String uid) {
        synchronized (onlineSessions) {
            if (!onlineSessions.containsKey(uid)) {
                logger.warn(Constant.LOGGER_NAME + "用户id=" + uid + "不存在在线列表中，本次removeUser没有继续.");
                printOnline();
                return false;
            } else
                return (onlineSessions.remove(uid) != null);
        }
    }


    public void printOnline() {
        logger.debug(Constant.LOGGER_NAME + "当前在线用户共(" + onlineSessions.size() + ")人");
        if (Constant.DEBUG) {
            for (String key : onlineSessions.keySet())
                logger.debug("      > user_id=" + key + ",session=" + onlineSessions.get(key).remoteAddress());
        }
    }


    /**
     * 通过session 获取uid
     *
     * @param session
     * @return
     */
    public static String getUserIdFromSession(Channel session) {
        Object attr = null;
        if (session != null) {
            attr = session.attr(USER_ID_IN_SESSION_ATTRIBUTE_ATTR).get();
            if (attr != null)
                return (String) attr;
        }
        return null;
    }
}
