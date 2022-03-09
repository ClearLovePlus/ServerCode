package com.chenhao.common.netttty.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @description:
 * @author: chenhao
 * @date: 2022-2-15 10:56
 */
public class GroupChatClient {
    private static final Logger logger= LoggerFactory.getLogger(GroupChatClient.class);
    private Selector selector;
    private SocketChannel socketChannel;
    private String userName;
    public GroupChatClient(){
        try {
            this.selector=Selector.open();
            socketChannel=SocketChannel.open(new InetSocketAddress("127.0.0.1",7777));
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
            userName=socketChannel.getLocalAddress().toString().substring(1);
            logger.info(userName+"已经上线");
        }catch (Exception e){
            logger.error("groupChatClient error");
        }
    }
    /**
     *     发送消息到服务端
     */

    private void sendMsg(String msg) {
        msg = userName + "说：" + msg;
        try {
            socketChannel.write(ByteBuffer.wrap(msg.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取服务端发送过来的消息
     */
    private void readMsg() {
        try {
            int count = selector.select();
            if (count > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    //判断是读就绪事件
                    if (selectionKey.isReadable()) {
                        SocketChannel channel = (SocketChannel) selectionKey.channel();
                        //创建一个缓冲区
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        //从服务器的通道中读取数据到缓冲区
                        channel.read(byteBuffer);
                        //缓冲区的数据，转成字符串，并打印
                        System.out.println(new String(byteBuffer.array()));
                    }
                    iterator.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GroupChatClient chatClient=new GroupChatClient();
        new Thread(()->{
            while (true){
                chatClient.readMsg();
                try {
                    Thread.sleep(3000);
                }catch (Exception e){
                    logger.info("read msg error");
                }
            }
        }).start();
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String msg = scanner.nextLine();
            chatClient.sendMsg(msg);
        }
    }
}
