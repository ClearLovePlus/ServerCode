package com.chenhao.common.netttty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description:
 * @author: chenhao
 * @date: 2022-2-9 14:09
 */
public class MyNettyClient {
    private static final Logger logger = LoggerFactory.getLogger(MyNettyClient.class);

    public static void main(String[] args) {
        NioEventLoopGroup eventExecutors = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventExecutors)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new MyClientHandler());
                        }
                    });
            logger.info("netty client start successfully");
            //连接客户端
            ChannelFuture future = bootstrap.connect("127.0.0.1", 6543).sync();
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            logger.error("netty client has an error", e);
        } finally {
            eventExecutors.shutdownGracefully();
        }
    }

}
