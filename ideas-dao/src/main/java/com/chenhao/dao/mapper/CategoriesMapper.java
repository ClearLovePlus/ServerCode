package com.chenhao.dao.mapper;

import com.chenhao.dao.entity.Categories;
import com.chenhao.dao.entity.CategoriesExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoriesMapper {
    long countByExample(CategoriesExample example);

    int deleteByExample(CategoriesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Categories record);

    int insertSelective(Categories record);

    List<Categories> selectByExample(CategoriesExample example);

    Categories selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Categories record, @Param("example") CategoriesExample example);

    int updateByExample(@Param("record") Categories record, @Param("example") CategoriesExample example);

    int updateByPrimaryKeySelective(Categories record);

    int updateByPrimaryKey(Categories record);
}