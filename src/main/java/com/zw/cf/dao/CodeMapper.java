package com.zw.cf.dao;

import com.zw.cf.model.Code;
import com.zw.cf.model.CodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CodeMapper {
    long countByExample(CodeExample example);

    int deleteByExample(CodeExample example);

    int deleteByPrimaryKey(String id);

    int insert(Code record);

    int insertSelective(Code record);

    List<Code> selectByExample(CodeExample example);

    Code selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Code record, @Param("example") CodeExample example);

    int updateByExample(@Param("record") Code record, @Param("example") CodeExample example);

    int updateByPrimaryKeySelective(Code record);

    int updateByPrimaryKey(Code record);
}