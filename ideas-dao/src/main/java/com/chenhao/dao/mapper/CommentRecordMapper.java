package com.chenhao.dao.mapper;

import com.chenhao.dao.entity.CommentDetail;
import com.chenhao.dao.entity.CommentRecord;
import com.chenhao.dao.entity.CommentRecordExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommentRecordMapper {
    long countByExample(CommentRecordExample example);

    int deleteByExample(CommentRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommentRecord record);

    int insertSelective(CommentRecord record);

    List<CommentRecord> selectByExampleWithBLOBs(CommentRecordExample example);

    List<CommentRecord> selectByExample(CommentRecordExample example);

    CommentRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommentRecord record, @Param("example") CommentRecordExample example);

    int updateByExampleWithBLOBs(@Param("record") CommentRecord record, @Param("example") CommentRecordExample example);

    int updateByExample(@Param("record") CommentRecord record, @Param("example") CommentRecordExample example);

    int updateByPrimaryKeySelective(CommentRecord record);

    int updateByPrimaryKeyWithBLOBs(CommentRecord record);

    int updateByPrimaryKey(CommentRecord record);

    /**
     * 查询评论详情
     * @param ids
     * @return
     */
    List<CommentDetail> selectCommentDetail(@Param("ids") List<Long> ids);

    /**
     * 查询点赞详情
     * @param userIds
     * @return
     */
    List<CommentDetail> selectLikeDetail(@Param("userIds") List<Long> userIds);
}
