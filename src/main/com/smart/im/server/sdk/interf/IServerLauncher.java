package com.smart.im.server.sdk.interf;

import com.smart.im.server.sdk.listenter.OnEventListener;
import com.smart.im.server.sdk.listenter.OnQosListener;

/**
 * @date : 2019-06-26 11:33
 * @author: lichen
 * @email : 1960003945@qq.com
 * @description :
 */
public interface IServerLauncher {


    /**
     * 初始化配置
     */
    void init();


    /**
     * 初始化配置
     * @param onEventListener 事件监听
     * @param onQosListener   心跳监听
     */
    void init(OnEventListener onEventListener, OnQosListener onQosListener);



    /**
     * 开启服务
     */
    void startup();


    /**
     *
     */
    void shoutdown();

}
