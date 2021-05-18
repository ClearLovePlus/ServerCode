package com.chenhao.dao.mapper;

import com.chenhao.dao.entity.CommentLikesRecord;
import com.chenhao.dao.entity.CommentLikesRecordExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommentLikesRecordMapper {
    long countByExample(CommentLikesRecordExample example);

    int deleteByExample(CommentLikesRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CommentLikesRecord record);

    int insertSelective(CommentLikesRecord record);

    List<CommentLikesRecord> selectByExample(CommentLikesRecordExample example);

    CommentLikesRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommentLikesRecord record, @Param("example") CommentLikesRecordExample example);

    int updateByExample(@Param("record") CommentLikesRecord record, @Param("example") CommentLikesRecordExample example);

    int updateByPrimaryKeySelective(CommentLikesRecord record);

    int updateByPrimaryKey(CommentLikesRecord record);
}