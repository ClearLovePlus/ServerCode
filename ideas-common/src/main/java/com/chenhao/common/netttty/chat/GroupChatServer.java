package com.chenhao.common.netttty.chat;

import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @description:
 * @author: chenhao
 * @date: 2022-2-10 13:55
 */
public class GroupChatServer {
    private static final Logger logger= LoggerFactory.getLogger(GroupChatServer.class);
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    public static final int PORT=7777;

    public GroupChatServer() {
        try {
            this.selector=Selector.open();
            this.serverSocketChannel=ServerSocketChannel.open();
            this.serverSocketChannel.bind(new InetSocketAddress("127.0.0.1",PORT));
            this.serverSocketChannel.configureBlocking(false);
            this.serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        }catch (Exception e){
            logger.error("init GroupServer error",e);
        }
    }

    private void listen(){
        try {
            while (true){
                int count=selector.select(2000);
                if(count>0){
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> it = selectionKeys.iterator();
                    while (it.hasNext()){
                        SelectionKey next = it.next();
                        if(next.isAcceptable()){
                            SocketChannel accept = serverSocketChannel.accept();
                            accept.configureBlocking(false);
                            accept.register(selector,SelectionKey.OP_READ);
                            logger.info(accept.getRemoteAddress()+"上线了...");
                        }
                        if(next.isReadable()){
                            readData(next);
                        }
                        it.remove();
                    }
                }else {
                    logger.info("服务端准备就绪,等待客户端连接...");
                }
            }

        }catch (Exception e){
            logger.error("GroupChatServer listener has some error: ",e);
        }
    }

    private void  readData(SelectionKey selectionKey){
        SocketChannel socketChannel=null;
        try {
            socketChannel= (SocketChannel) selectionKey.channel();
            ByteBuffer byteBuffer= ByteBuffer.allocate(1024);
            int count=socketChannel.read(byteBuffer);
            if(count>0){
                String msg=new String(byteBuffer.array(), CharsetUtil.UTF_8);
                logger.info("来自客户端["+socketChannel.getRemoteAddress()+"]说:"+msg);
                notifyAll(msg,socketChannel);
            }
        }catch (Exception e){
            logger.error("服务器错误",e);
              try {
                  //打印离线的通知
                  logger.info(socketChannel.getRemoteAddress() + "离线了...");
                  //取消注册
                  selectionKey.cancel();
                  //关闭流
                  socketChannel.close();
              }catch (Exception e1){
                  logger.error("服务器错误:",e1);
              }
        }
    }

    /**
     * 通知所有上线的客户端
     * @param msg
     * @param socketChannel
     * @throws Exception
     */
    private void  notifyAll(String msg,SocketChannel socketChannel)throws  Exception{
        logger.info("服务器群发消息.....");
        for(SelectionKey selectionKey:selector.keys()){
            Channel channel=selectionKey.channel();
            if(channel instanceof SocketChannel&&channel!=socketChannel){
                SocketChannel outChannel=(SocketChannel) channel;
                ByteBuffer byteBuffer=ByteBuffer.wrap(msg.getBytes(StandardCharsets.UTF_8));
                outChannel.write(byteBuffer);
            }
        }

    }

    public static void main(String[] args) {
        GroupChatServer chatServer=new GroupChatServer();
        chatServer.listen();
    }
}
