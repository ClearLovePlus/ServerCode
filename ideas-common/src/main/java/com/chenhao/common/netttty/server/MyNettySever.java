package com.chenhao.common.netttty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description:
 * @author: chenhao
 * @date: 2022-2-9 10:54
 */
public class MyNettySever {
    private static final Logger logger= LoggerFactory.getLogger(MyNettySever.class);
    public static void main(String[] args) {
        EventLoopGroup fatherGroup=new NioEventLoopGroup();
        EventLoopGroup sonGroup=new NioEventLoopGroup();
        try{
            ServerBootstrap serverBootstrap=new ServerBootstrap();
            serverBootstrap.group(fatherGroup,sonGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,128)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new MyNettyServerHandler());
                        }
                    });
            logger.info("myNettyServer start");
            //绑定端口启动服务
            ChannelFuture channelFuture=serverBootstrap.bind(6543).sync();
            //对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
        }catch (Exception e){
            logger.error("test error",e);
        }finally {
            fatherGroup.shutdownGracefully();
            sonGroup.shutdownGracefully();
        }
    }
}
