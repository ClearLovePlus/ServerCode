package com.chenhao.dto.request;


import com.chenhao.dto.annotations.NotNull;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @description:请求测试类
 * @author: chenhao
 * @date: 2021-6-9 15:29
 */
@Data
public class TestRequestDTO {
    private String  filedString;
    private List<Integer> filedList;
    private Integer filedInteger;
    private Float filedFloat;
    private Double filedDouble;
    private Map<String,String> filedMap;

}
