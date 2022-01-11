package com.chenhao.dao.plugin;

import org.apache.ibatis.session.RowBounds;

/**
 * @description:
 * @author: chenhao
 * @date: 2022-1-10 14:36
 */
public class DefaultRowBounds extends RowBounds {
    /**
     * 获取道德记录总数
     */
    private Long total;

    /**
     * 初始化原始分页的每页的数量和偏移量
     * @param offset
     * @param limit
     */
    public DefaultRowBounds(int offset,int limit){
        super(offset,limit);
    }
    public DefaultRowBounds(){

    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
