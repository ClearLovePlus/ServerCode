package com.chenhao.service.impl;

import com.alibaba.fastjson.JSON;
import com.chenhao.common.utils.EsClient;
import com.chenhao.dto.request.BlogEsRequest;
import com.chenhao.dto.response.BlogContentResponse;
import com.chenhao.service.IBlogFunction;
import com.chenhao.service.IEsService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.fieldcaps.FieldCapabilities;
import org.elasticsearch.action.fieldcaps.FieldCapabilitiesRequest;
import org.elasticsearch.action.fieldcaps.FieldCapabilitiesResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.*;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.Strings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.UpdateByQueryRequest;
import org.elasticsearch.index.search.MatchQuery;
import org.elasticsearch.script.Script;
import org.elasticsearch.search.Scroll;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description:es???????????????
 * @author: chenhao
 * @date: 2021-9-1 13:59
 */
@Service("esService")
public class EsServiceImpl implements IEsService {
    private static final Logger logger = LoggerFactory.getLogger(EsServiceImpl.class);
    /**
     * ?????????????????????
     */
    private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    @Override
    public void insert() throws Exception {
        try {
            BlogEsRequest blogEsRequest = new BlogEsRequest();
            blogEsRequest.setIndex("blog");
            blogEsRequest.setId(1L);
            blogEsRequest.setCreateDate(DateFormatUtils.format(new Date(), DATE_FORMAT_PATTERN));
            blogEsRequest.setAuthorName("??????");
            blogEsRequest.setTextContent("?????? es ???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????? index(es7 ?????????????????? mapping?????????????????? index ??????????????????)??????????????????????????????????????? index.");
            blogEsRequest.setUpdateDate(DateFormatUtils.format(new Date(), DATE_FORMAT_PATTERN));
            blogEsRequest.setTitle("es???????????????");
            IndexRequest request = new IndexRequest(blogEsRequest.getIndex());
            request.source(JSON.toJSONString(blogEsRequest), XContentType.JSON);
            IndexResponse response = EsClient.getEsClient().index(request, RequestOptions.DEFAULT);
        } catch (Exception e) {
            logger.error("??????blog?????????es??????", e);
            throw e;
        }

    }

    @Override
    public void deleteIndex(String index, String id) throws Exception {
        try {
            DeleteRequest deleteRequest = new DeleteRequest(index);
            deleteRequest.id(id);
            EsClient.getEsClient().delete(deleteRequest, RequestOptions.DEFAULT);
        } catch (Exception e) {
            logger.error("??????????????????", e);
            throw e;
        }
    }

    @Override
    public void insertTest() throws Exception {
        try {
            XContentBuilder builder = XContentFactory.jsonBuilder();
            builder.startObject();
            builder.field("id", 2L);
            builder.field("authorName", "?????????");
            builder.timeField("createDate", new Date());
            builder.timeField("updateDate", new Date());
            builder.field("index", "blog");
            builder.field("textContent", "????????????????????????????????????????????????????????????????????????????????????\n" +
                    "\n" +
                    "????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????\n" +
                    "\n" +
                    "???????????????????????????????????????????????????????????????????????????????????????");
            builder.field("title", "??????????????????!");
            builder.endObject();
            IndexRequest blogRequest = new IndexRequest("blog").source(builder);
            IndexResponse blogResponse = EsClient.getEsClient().index(blogRequest, RequestOptions.DEFAULT);
            //??????????????????doc
            if (blogResponse != null) {
                XContentBuilder indexBuilder = XContentFactory.jsonBuilder();
                indexBuilder.startObject();
                indexBuilder.field("blogId", 2L);
                indexBuilder.field("indexId", blogResponse.getId());
                indexBuilder.timeField("createDate", new Date());
                indexBuilder.timeField("updateDate", new Date());
                indexBuilder.endObject();
                IndexRequest indexesRequest = new IndexRequest("indexing").source(indexBuilder);
                IndexResponse response = EsClient.getEsClient().index(indexesRequest, RequestOptions.DEFAULT);
            }
        } catch (Exception e) {
            logger.error("es????????????????????????", e);
            throw e;
        }
    }

    @Override
    public String getTest(IBlogFunction<String, String> function) throws Exception {
//        GetRequest request = new GetRequest(function.execute("test"), "AXRfpHsBhubEUyMaCPZw");
//        request.fetchSourceContext(FetchSourceContext.FETCH_SOURCE);
//        GetResponse response = EsClient.getEsClient().get(request, RequestOptions.DEFAULT);
//        response.getSourceAsString();
//        System.out.println(response.getSourceAsString());
//        String[] includes = new String[]{"title", "authorName", "textContent"};
//        String[] excludes = Strings.EMPTY_ARRAY;
//        request.fetchSourceContext(new FetchSourceContext(true, includes, excludes));
//        GetResponse response1 = EsClient.getEsClient().get(request, RequestOptions.DEFAULT);
//        System.out.println(response1.getSourceAsString());
//        includes = Strings.EMPTY_ARRAY;
//        excludes = new String[]{"title", "authorName", "textContent"};
//        request.fetchSourceContext(new FetchSourceContext(true, includes, excludes));
//        GetResponse response2 = EsClient.getEsClient().get(request, RequestOptions.DEFAULT);
//        System.out.println(response2.getSourceAsString());
//        return response.getSourceAsString();
        return null;
    }

    @Override
    public void updateTest(IBlogFunction<String, String> function, String indexName) throws Exception {
//        UpdateRequest request = new UpdateRequest(indexName, function.execute(indexName)).doc("updateDate", new Date(), "title", "?????????yyds");
//        EsClient.getEsClient().update(request, RequestOptions.DEFAULT);
    }

    @Override
    public void bulkTest(IBlogFunction<String, String[]> function, String indexName) throws Exception {
        BulkRequest bulkRequest = new BulkRequest();
        //??????????????????
        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        builder.field("index", "blog");
        builder.field("id", 6L);
        builder.timeField("createDate", new Date());
        builder.timeField("updateDate", new Date());
        builder.timeField("authorName", "?????????");
        builder.field("title", "es???bulk??????");
        builder.field("textContent", "A BulkRequest can be used to execute multiple index, update and/or delete operations using a single request");
        builder.endObject();
        IndexRequest insert = new IndexRequest(indexName).source(builder);
        //??????update??????
//        UpdateRequest update = new UpdateRequest(indexName, function.execute(indexName)[0]).doc("updateDate", new Date(), "title", "???????????????yyds????????????!");
        //??????delete??????
        DeleteRequest delete = new DeleteRequest(indexName).id(function.execute(indexName)[1]);
//        bulkRequest.add(update);
        bulkRequest.add(insert);
        bulkRequest.add(delete);
        BulkResponse bulk = EsClient.getEsClient().bulk(bulkRequest, RequestOptions.DEFAULT);
        for (BulkItemResponse response : bulk.getItems()) {
            switch (response.getOpType()) {
                case INDEX:
                case CREATE:
                    System.out.println("============================?????????create????????????=====================");
                    IndexResponse create = (IndexResponse) response.getResponse();
                    System.out.println(JSON.toJSONString(create));
                    break;
                case UPDATE:
                    System.out.println("============================?????????update????????????=====================");
                    UpdateResponse updateResponse = (UpdateResponse) response.getResponse();
                    System.out.println(JSON.toJSONString(updateResponse));
                    break;
                case DELETE:
                    System.out.println("============================?????????update????????????=====================");
                    DeleteResponse deleteResponse = (DeleteResponse) response.getResponse();
                    System.out.println(JSON.toJSONString(deleteResponse));
                    break;
                default:
                    System.out.println("?????????????????????");
            }
        }

    }

    @Override
    public void updateByQueryTest(String indexName) throws Exception {
//        UpdateByQueryRequest updateByQueryRequest = new UpdateByQueryRequest("blog");
//        updateByQueryRequest.setQuery(new TermQueryBuilder("id", 2L));
//        updateByQueryRequest.setScript(new Script("ctx._source['title']='??????title2';"));
//        BulkByScrollResponse bulkByScrollResponse = EsClient.getEsClient().updateByQuery(updateByQueryRequest, RequestOptions.DEFAULT);
    }

    @Override
    public List<BlogContentResponse> scrollSearch(String indexName) throws Exception {
        final Scroll scroll=new Scroll(TimeValue.timeValueMinutes(1L));
        SearchRequest searchRequest=new SearchRequest(indexName);
        searchRequest.scroll(scroll);
        SearchSourceBuilder searchRequestBuilder=new SearchSourceBuilder();
        searchRequestBuilder.query(QueryBuilders.matchQuery("index","blog"));
        searchRequestBuilder.size(2);
        searchRequest.source(searchRequestBuilder);
        SearchResponse searchResponse = EsClient.getEsClient().search(searchRequest, RequestOptions.DEFAULT);
        String scrollId=searchResponse.getScrollId();
        SearchHit[] hits = searchResponse.getHits().getHits();
        while (hits!=null&&hits.length>0){
            SearchScrollRequest searchScrollRequest=new SearchScrollRequest(scrollId);
            searchScrollRequest.scroll(scroll);
            SearchResponse scrollResponse = EsClient.getEsClient().scroll(searchScrollRequest, RequestOptions.DEFAULT);
            scrollId=scrollResponse.getScrollId();
            hits=scrollResponse.getHits().getHits();
        }

        ClearScrollRequest clearScrollRequest = new ClearScrollRequest();
        clearScrollRequest.addScrollId(scrollId);
        ClearScrollResponse clearScrollResponse = EsClient.getEsClient().clearScroll(clearScrollRequest, RequestOptions.DEFAULT);
        boolean succeeded = clearScrollResponse.isSucceeded();

        return null;
    }

    @Override
    public void fieldCapabilitiesSearch(String[] indices)  throws Exception{
        FieldCapabilitiesRequest request=new FieldCapabilitiesRequest().fields("authorName").indices(indices);
        FieldCapabilitiesResponse fieldCapabilitiesResponse = EsClient.getEsClient().fieldCaps(request, RequestOptions.DEFAULT);
        Map<String, Map<String, FieldCapabilities>> stringMapMap = fieldCapabilitiesResponse.get();

    }
}
