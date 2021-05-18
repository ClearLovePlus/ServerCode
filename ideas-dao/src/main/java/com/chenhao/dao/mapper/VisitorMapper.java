package com.chenhao.dao.mapper;

import com.chenhao.dao.entity.Visitor;
import com.chenhao.dao.entity.VisitorExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface VisitorMapper {
    long countByExample(VisitorExample example);

    int deleteByExample(VisitorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Visitor record);

    int insertSelective(Visitor record);

    List<Visitor> selectByExampleWithBLOBs(VisitorExample example);

    List<Visitor> selectByExample(VisitorExample example);

    Visitor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Visitor record, @Param("example") VisitorExample example);

    int updateByExampleWithBLOBs(@Param("record") Visitor record, @Param("example") VisitorExample example);

    int updateByExample(@Param("record") Visitor record, @Param("example") VisitorExample example);

    int updateByPrimaryKeySelective(Visitor record);

    int updateByPrimaryKeyWithBLOBs(Visitor record);

    int updateByPrimaryKey(Visitor record);
}