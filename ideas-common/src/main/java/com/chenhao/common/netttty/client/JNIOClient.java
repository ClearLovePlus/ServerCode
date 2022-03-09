package com.chenhao.common.netttty.client;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @description: 不基于netty的 nio client demo
 * @author: chenhao
 * @date: 2022-2-10 11:15
 */
public class JNIOClient {
    public static void main(String[] args) throws Exception {
        SocketChannel channel=SocketChannel.open();
        InetSocketAddress address=new InetSocketAddress("127.0.0.1",7777);
        channel.configureBlocking(false);
        boolean connect = channel.connect(address);
        if(!connect){
            while (!channel.finishConnect()){
                System.out.println("服务器连接中...");
            }
        }
        String msg = "不基于netty的 nio client demo！";
        ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());
        //把byteBuffer数据写入到通道中
        channel.write(byteBuffer);
        //让程序卡在这个位置，不关闭连接
        System.in.read();
    }
}
