package com.chenhao.dto.response;

import lombok.Data;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-9-22 13:48
 */
@Data
public class PageResponse<T> {
    private Long total;
    private Integer currentPage;
    private T data;
    private Integer pageSize;
}
