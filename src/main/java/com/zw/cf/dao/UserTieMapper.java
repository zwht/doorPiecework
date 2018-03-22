package com.zw.cf.dao;

import com.zw.cf.model.UserTie;
import com.zw.cf.model.UserTieExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTieMapper {
    long countByExample(UserTieExample example);

    int deleteByExample(UserTieExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserTie record);

    int insertSelective(UserTie record);

    List<UserTie> selectByExample(UserTieExample example);

    UserTie selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserTie record, @Param("example") UserTieExample example);

    int updateByExample(@Param("record") UserTie record, @Param("example") UserTieExample example);

    int updateByPrimaryKeySelective(UserTie record);

    int updateByPrimaryKey(UserTie record);
}