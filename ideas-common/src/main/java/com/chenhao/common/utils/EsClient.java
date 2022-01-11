package com.chenhao.common.utils;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

/**
 * @description:es实例化入口
 * @author: chenhao
 * @date: 2021-8-31 13:24
 */
public class EsClient {
    private static final Logger logger = LoggerFactory.getLogger(EsClient.class);
    private volatile static RestHighLevelClient esClient;

    /**
     * 防止手动new出来
     */
    private EsClient() {

    }

    public static RestHighLevelClient getEsClient() {
        if (esClient == null) {
            synchronized (EsClient.class) {
                if (esClient == null) {
                    logger.info("start init esClient");
                    initEsClient();
                    logger.info("init esClient success");
                    return esClient;
                }
            }
        }
        return esClient;
    }

    /**
     * 初始化es client
     */
    public static void initEsClient() {
        try {
            Properties properties = new Properties();
            InputStream io = Thread.currentThread().getContextClassLoader().getResourceAsStream("es.properties");
            properties.load(io);
            String[] nodes = properties.get("es.node").toString().split(",");
            Node[] nodeList = new Node[nodes.length];
            for (int i = 0; i < nodes.length; i++) {
                String[] host = nodes[i].split(":");
                HttpHost httpHost = new HttpHost(host[0], Integer.valueOf(host[1]), "http");
                Node esNode = new Node(httpHost);
                nodeList[i] = esNode;
            }
            CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
            credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials((String) properties.get("es.userName"), (String) properties.get("es.password")));
            esClient = new RestHighLevelClient(RestClient.builder(nodeList)
                    .setHttpClientConfigCallback(httpAsyncClientBuilder -> {
                        httpAsyncClientBuilder.disableAuthCaching();
                        return httpAsyncClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
                    }));
            if(io!=null){
                io.close();
            }
        } catch (Exception e) {
            logger.error("初始化esClient异常", e);
        }

    }

}
