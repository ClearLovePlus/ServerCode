package com.chenhao.api.provider.server;

import com.chenhao.api.interfaces.Calculator;
import com.chenhao.api.provider.CalculatorImpl;
import com.chenhao.api.request.AddRequest;
import com.chenhao.api.request.RpcRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chenhao
 * @description: rpc 服务端
 */
public class RpcServer {
    private static final Logger logger = LoggerFactory.getLogger(RpcServer.class);
    private Calculator calculator=new CalculatorImpl();

    public static void main(String[] args) throws Exception{
        new RpcServer().run();
    }

    private void run() throws Exception {
        ServerSocket serverSocket = new ServerSocket(9090);
        try {
            while (true){
                Socket socket=serverSocket.accept();
                try {
                    ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
                    Object object=objectInputStream.readObject();
                    logger.info("request is {}",object);
                    int result=0;
                    if(object instanceof RpcRequest){
                        RpcRequest request=(RpcRequest) object;
                        if(request.getObject()!=null){
                            if(request.getObject() instanceof AddRequest){
                                AddRequest addRequest=(AddRequest)  request.getObject();
                                if("add".equals(request.getMethodName())){
                                   result= calculator.add(addRequest);
                                }else {
                                    logger.error("no such method:{}",request.getMethodName());
                                }
                            }
                        }
                    }
                    ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
                    objectOutputStream.writeObject(new Integer(result));
                }catch (Exception e){
                    logger.error("error",e);
                }finally {
                    socket.close();
                }
            }
        } catch (Exception e){
            logger.error("error",e);
        }
        finally {
            serverSocket.close();
        }
    }
}
