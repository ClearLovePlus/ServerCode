package com.chenhao.dao.mapper;

import com.chenhao.dao.entity.FriendLink;
import com.chenhao.dao.entity.FriendLinkExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FriendLinkMapper {
    long countByExample(FriendLinkExample example);

    int deleteByExample(FriendLinkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FriendLink record);

    int insertSelective(FriendLink record);

    List<FriendLink> selectByExample(FriendLinkExample example);

    FriendLink selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FriendLink record, @Param("example") FriendLinkExample example);

    int updateByExample(@Param("record") FriendLink record, @Param("example") FriendLinkExample example);

    int updateByPrimaryKeySelective(FriendLink record);

    int updateByPrimaryKey(FriendLink record);
}