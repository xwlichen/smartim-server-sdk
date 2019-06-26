package com.smart.im.server.sdk.core;


import com.smart.im.server.sdk.Constant;
import com.smart.im.server.sdk.wrapper.ServerLauncherWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @date : 2019-06-25 13:51
 * @author: lichen
 * @email : 1960003945@qq.com
 * @description : smartim-server-sdk服务入口
 */
public class ServerLauncher extends ServerLauncherWrapper {

    private static Logger logger = LoggerFactory.getLogger(ServerLauncher.class);



    public void init() {
        serverCoreHandler=new ServerCoreHandler();

    }


    public void startup() {

    }

    public void shoutdown() {
        if (!this.isRunning) {

        } else {
            logger.warn(Constant.LOGGER_NAME + "基于smartim-server-sdk的UDP服务正在运行，请先调用shutdown()后再试");
        }

    }
}
