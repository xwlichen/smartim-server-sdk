package com.smart.im.server.sdk.wrapper;

import com.smart.im.server.sdk.core.ServerCoreHandler;
import com.smart.im.server.sdk.interf.IServerLauncher;

/**
 * @date : 2019-06-26 14:02
 * @author: lichen
 * @email : 1960003945@qq.com
 * @description :
 */
public abstract class ServerLauncherWrapper implements IServerLauncher {


    /**
     * 是否与web端桥接
     */
    public static boolean bridgeEnable = false;


    /**
     * 核心处理类
     */
    protected ServerCoreHandler serverCoreHandler;

    /**
     * 是否正在运行
     */
    protected boolean isRunning = false;
}
