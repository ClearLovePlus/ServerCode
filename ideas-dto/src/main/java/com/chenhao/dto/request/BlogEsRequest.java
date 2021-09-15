package com.chenhao.dto.request;

import com.chenhao.dto.BaseEsIndexRequest;
import lombok.Data;

/**
 * @description:
 * @author: chenhao
 * @date: 2021-9-1 14:57
 */
@Data
public class BlogEsRequest extends BaseEsIndexRequest {
    private long id;
    private String title;
    private String authorName;
    private String createDate;
    private String updateDate;
    private String textContent;
}
