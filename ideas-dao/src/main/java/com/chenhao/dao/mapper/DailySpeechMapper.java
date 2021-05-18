package com.chenhao.dao.mapper;

import com.chenhao.dao.entity.DailySpeech;
import com.chenhao.dao.entity.DailySpeechExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DailySpeechMapper {
    long countByExample(DailySpeechExample example);

    int deleteByExample(DailySpeechExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DailySpeech record);

    int insertSelective(DailySpeech record);

    List<DailySpeech> selectByExampleWithBLOBs(DailySpeechExample example);

    List<DailySpeech> selectByExample(DailySpeechExample example);

    DailySpeech selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DailySpeech record, @Param("example") DailySpeechExample example);

    int updateByExampleWithBLOBs(@Param("record") DailySpeech record, @Param("example") DailySpeechExample example);

    int updateByExample(@Param("record") DailySpeech record, @Param("example") DailySpeechExample example);

    int updateByPrimaryKeySelective(DailySpeech record);

    int updateByPrimaryKeyWithBLOBs(DailySpeech record);

    int updateByPrimaryKey(DailySpeech record);
}