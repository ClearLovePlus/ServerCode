package com.chenhao.dao.mapper;

import com.chenhao.dao.entity.PrivateWord;
import com.chenhao.dao.entity.PrivateWordExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PrivateWordMapper {
    long countByExample(PrivateWordExample example);

    int deleteByExample(PrivateWordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PrivateWord record);

    int insertSelective(PrivateWord record);

    List<PrivateWord> selectByExample(PrivateWordExample example);

    PrivateWord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PrivateWord record, @Param("example") PrivateWordExample example);

    int updateByExample(@Param("record") PrivateWord record, @Param("example") PrivateWordExample example);

    int updateByPrimaryKeySelective(PrivateWord record);

    int updateByPrimaryKey(PrivateWord record);
}