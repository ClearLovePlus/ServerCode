package com.chenhao.dao.mapper;

import com.chenhao.dao.entity.MBlog;
import com.chenhao.dao.entity.MBlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MBlogMapper {
    long countByExample(MBlogExample example);

    int deleteByExample(MBlogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MBlog record);

    int insertSelective(MBlog record);

    List<MBlog> selectByExampleWithBLOBs(MBlogExample example);

    List<MBlog> selectByExample(MBlogExample example);

    MBlog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MBlog record, @Param("example") MBlogExample example);

    int updateByExampleWithBLOBs(@Param("record") MBlog record, @Param("example") MBlogExample example);

    int updateByExample(@Param("record") MBlog record, @Param("example") MBlogExample example);

    int updateByPrimaryKeySelective(MBlog record);

    int updateByPrimaryKeyWithBLOBs(MBlog record);

    int updateByPrimaryKey(MBlog record);
}