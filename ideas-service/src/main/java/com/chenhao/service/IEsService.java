package com.chenhao.service;

import com.chenhao.dto.response.BlogContentResponse;

import java.util.List;

/**
 * @description:es操作使用类
 * @author: chenhao
 * @date: 2021-9-1 10:22
 */
public interface IEsService {
    /**
     * 插入es
     */
    void insert() throws Exception;

    /**
     * 删除索引
     * @param index
     * @throws Exception
     */
    void  deleteIndex(String index,String id) throws Exception;

    /**
     * 插入测试
     * @throws Exception
     */

    void insertTest() throws Exception;

    /**
     * 搜索测试
     * @param function
     * @return
     * @throws Exception
     */

    String getTest(IBlogFunction<String,String> function) throws Exception;

    /**
     * es更新测试demo
     * @param function
     * @param indexName
     * @throws Exception
     */
    void updateTest(IBlogFunction<String,String> function,String indexName) throws Exception;

    /**
     * es bulk测试方法
     * @param function
     * @param indexName
     * @throws Exception
     */

    void bulkTest(IBlogFunction<String,String[]>function,String indexName)throws Exception;

    /**
     * 根据查询条件去批量更新数据，类似于数据库中 update table tb_a set Name='***' where type=2;
     * @param indexName
     * @throws Exception
     */
    void updateByQueryTest(String indexName) throws Exception;

    /**
     * 滚动查询
     * @param indexName
     * @return
     * @throws Exception
     */
    List<BlogContentResponse> scrollSearch(String indexName) throws Exception;

    /**
     * FieldCapabilitiesSearch 测试
     * @param indices
     */
    void fieldCapabilitiesSearch(String [] indices) throws Exception;

}
