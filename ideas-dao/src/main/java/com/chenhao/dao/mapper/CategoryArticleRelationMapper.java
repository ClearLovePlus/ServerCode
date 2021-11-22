package com.chenhao.dao.mapper;

import com.chenhao.dao.entity.CategoryArticleRelation;
import com.chenhao.dao.entity.CategoryArticleRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CategoryArticleRelationMapper {
    long countByExample(CategoryArticleRelationExample example);

    int deleteByExample(CategoryArticleRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CategoryArticleRelation record);

    int insertSelective(CategoryArticleRelation record);

    List<CategoryArticleRelation> selectByExampleWithRowbounds(CategoryArticleRelationExample example, RowBounds rowBounds);

    List<CategoryArticleRelation> selectByExample(CategoryArticleRelationExample example);

    CategoryArticleRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CategoryArticleRelation record, @Param("example") CategoryArticleRelationExample example);

    int updateByExample(@Param("record") CategoryArticleRelation record, @Param("example") CategoryArticleRelationExample example);

    int updateByPrimaryKeySelective(CategoryArticleRelation record);

    int updateByPrimaryKey(CategoryArticleRelation record);
}