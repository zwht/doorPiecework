package com.zw.cf.dao;

import com.zw.cf.model.User1;
import com.zw.cf.model.User1Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface User1Mapper {
    long countByExample(User1Example example);

    int deleteByExample(User1Example example);

    int deleteByPrimaryKey(String id);

    int insert(User1 record);

    int insertSelective(User1 record);

    List<User1> selectByExample(User1Example example);

    User1 selectByPrimaryKey(String id);
    User1 selectByUserName(String userName);

    int updateByExampleSelective(@Param("record") User1 record, @Param("example") User1Example example);

    int updateByExample(@Param("record") User1 record, @Param("example") User1Example example);

    int updateByPrimaryKeySelective(User1 record);

    int updateByPrimaryKey(User1 record);
}