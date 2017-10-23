package com.zw.cf.dao;

import com.zw.cf.model.Code;
import com.zw.cf.model.CodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CodeMapper {
    long countByExample(CodeExample example);

    int deleteByExample(CodeExample example);

    int insert(Code record);

    int insertSelective(Code record);

    List<Code> selectByExampleWithBLOBs(CodeExample example);

    List<Code> selectByExample(CodeExample example);

    int updateByExampleSelective(@Param("record") Code record, @Param("example") CodeExample example);

    int updateByExampleWithBLOBs(@Param("record") Code record, @Param("example") CodeExample example);

    int updateByExample(@Param("record") Code record, @Param("example") CodeExample example);
}