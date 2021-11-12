package com.tensquare.notice.config;

import com.tensquare.notice.netty.NettyServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version v1.0
 * @ClassName NettyConfig
 * @Description TODO
 * @Author Q
 */
@Configuration
public class NettyConfig {

    @Bean
    public NettyServer createNettyServer() {
        NettyServer nettyServer = new NettyServer();

        //启动Netty服务，使用新的线程启动
        new Thread(() -> {
            nettyServer.start(1234);
        }).start();
        return nettyServer;
    }
}
