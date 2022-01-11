package com.chenhao.dao.mapper;

import com.chenhao.dao.entity.ActMyFlow;
import com.chenhao.dao.entity.ActMyFlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ActMyFlowMapper {
    long countByExample(ActMyFlowExample example);

    int deleteByExample(ActMyFlowExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ActMyFlow record);

    int insertSelective(ActMyFlow record);

    List<ActMyFlow> selectByExampleWithRowbounds(ActMyFlowExample example, RowBounds rowBounds);

    List<ActMyFlow> selectByExample(ActMyFlowExample example);

    ActMyFlow selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ActMyFlow record, @Param("example") ActMyFlowExample example);

    int updateByExample(@Param("record") ActMyFlow record, @Param("example") ActMyFlowExample example);

    int updateByPrimaryKeySelective(ActMyFlow record);

    int updateByPrimaryKey(ActMyFlow record);
}