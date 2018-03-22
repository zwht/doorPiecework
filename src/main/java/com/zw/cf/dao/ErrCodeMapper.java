package com.zw.cf.dao;

import com.zw.cf.model.ErrCode;
import com.zw.cf.model.ErrCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErrCodeMapper {
    long countByExample(ErrCodeExample example);

    int deleteByExample(ErrCodeExample example);

    int deleteByPrimaryKey(String id);

    int insert(ErrCode record);

    int insertSelective(ErrCode record);

    List<ErrCode> selectByExample(ErrCodeExample example);

    ErrCode selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ErrCode record, @Param("example") ErrCodeExample example);

    int updateByExample(@Param("record") ErrCode record, @Param("example") ErrCodeExample example);

    int updateByPrimaryKeySelective(ErrCode record);

    int updateByPrimaryKey(ErrCode record);
}