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
    @NotNull
    private String  filedString;
    @NotNull
    private List<Integer> filedList;
    @NotNull(minValue = 1)
    private Integer filedInteger;
    @NotNull(minValue = 1)
    private Float filedFloat;
    @NotNull(minValue = 1)
    private Double filedDouble;
    @NotNull
    private Map<String,String> filedMap;

}
