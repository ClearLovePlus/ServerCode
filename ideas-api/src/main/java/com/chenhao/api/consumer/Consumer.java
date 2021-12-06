package com.chenhao.api.consumer;

import com.chenhao.api.request.AddRequest;
import com.chenhao.api.request.RpcRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 消费者
 */
public class Consumer {
    private static final int port=9090;
    private  static final Logger logger= LoggerFactory.getLogger(Consumer.class);

    public static void main(String[] args) {
    new Consumer().run();
    }
    public int run(){
        List<String> serverList=getServerLists("TargetService.add");
        String targetServer=getTargetServer(serverList,"default");
        AddRequest request=new AddRequest();
        request.setVar1(1);
        request.setVar2(2);
        RpcRequest rpcRequest=new RpcRequest();
        rpcRequest.setObject(request);
        rpcRequest.setMethodName("add");
        try {
            Socket socket=new Socket(targetServer,port);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(rpcRequest);
            ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
            Object response=objectInputStream.readObject();
            logger.info("返回值：{}",response);
            if(response instanceof Integer){
                return (Integer) response;
            }else {
                logger.error("返回类型错误");
            }
        }catch (Exception e){
            logger.error("error");
        }
        return 0;
    }


    /**
     * 服务查找策略，各个算法都ok
     * @param serverList
     * @param strategy
     * @return
     */
    private String getTargetServer(List<String> serverList,String strategy){
        switch (strategy){
            default:
                return serverList.get(0);
        }
    }
    /**
     * 获取服务列表
     * @param serviceName
     * @return
     */
    private static List<String> getServerLists(String serviceName){
        List<String> serverLists=new ArrayList<>();
        serverLists.add("127.0.0.1");
        return serverLists;
    }

}
