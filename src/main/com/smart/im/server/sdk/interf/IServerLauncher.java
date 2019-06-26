package com.smart.im.server.sdk.interf;

/**
 * @date : 2019-06-26 11:33
 * @author: lichen
 * @email : 1960003945@qq.com
 * @description :
 */
public interface IServerLauncher {


    /**
     * 初始化一些配置
     */
    void init();


    /**
     * 开启服务
     */
    void startup();


    /**
     *
     */
    void shoutdown();

}
