package com.chenhao.common.netttty.server;

import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @description: 不基于netty的nio demo
 * @author: chenhao
 * @date: 2022-2-10 10:51
 */
public class JNIOServer {
    public static void main(String[] args) throws  Exception{
        ServerSocketChannel serverSocketChannel= ServerSocketChannel.open();
        InetSocketAddress address=new InetSocketAddress("127.0.0.1",7777);
        serverSocketChannel.bind(address);
        serverSocketChannel.configureBlocking(false);
        Selector selector=Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true){
            if(selector.select(3000)==0){
                System.out.println("服务器等待3秒，没有连接");
                continue;
            }
            Set<SelectionKey> selectionKeys=selector.selectedKeys();
            Iterator<SelectionKey> it=selectionKeys.iterator();
            while (it.hasNext()){
                SelectionKey next = it.next();
                if(next.isAcceptable()){
                    SocketChannel accept = serverSocketChannel.accept();
                    accept.configureBlocking(false);
                    accept.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }
                if(next.isReadable()){
                    SocketChannel socketChannel = (SocketChannel) next.channel();
                    Object attachment = next.attachment();
                    ByteBuffer buffer=(ByteBuffer) attachment;
                    socketChannel.read(buffer);
                    System.out.println("来自客户端： "+new String(buffer.array(), CharsetUtil.UTF_8));
                }
            }
           it.remove();
        }
    }
}
