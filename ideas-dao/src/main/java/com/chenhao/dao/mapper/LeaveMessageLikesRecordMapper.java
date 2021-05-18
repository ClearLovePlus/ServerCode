package com.chenhao.dao.mapper;

import com.chenhao.dao.entity.LeaveMessageLikesRecord;
import com.chenhao.dao.entity.LeaveMessageLikesRecordExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LeaveMessageLikesRecordMapper {
    long countByExample(LeaveMessageLikesRecordExample example);

    int deleteByExample(LeaveMessageLikesRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LeaveMessageLikesRecord record);

    int insertSelective(LeaveMessageLikesRecord record);

    List<LeaveMessageLikesRecord> selectByExample(LeaveMessageLikesRecordExample example);

    LeaveMessageLikesRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LeaveMessageLikesRecord record, @Param("example") LeaveMessageLikesRecordExample example);

    int updateByExample(@Param("record") LeaveMessageLikesRecord record, @Param("example") LeaveMessageLikesRecordExample example);

    int updateByPrimaryKeySelective(LeaveMessageLikesRecord record);

    int updateByPrimaryKey(LeaveMessageLikesRecord record);
}