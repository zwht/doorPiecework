package com.zw.cf.dao;

import com.zw.cf.model.Line;
import com.zw.cf.model.LineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LineMapper {
    long countByExample(LineExample example);

    int deleteByExample(LineExample example);

    int deleteByPrimaryKey(String id);

    int insert(Line record);

    int insertSelective(Line record);

    List<Line> selectByExample(LineExample example);

    Line selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Line record, @Param("example") LineExample example);

    int updateByExample(@Param("record") Line record, @Param("example") LineExample example);

    int updateByPrimaryKeySelective(Line record);

    int updateByPrimaryKey(Line record);
}