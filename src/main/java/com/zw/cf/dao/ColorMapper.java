package com.zw.cf.dao;

import com.zw.cf.model.Color;
import com.zw.cf.model.ColorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ColorMapper {
    long countByExample(ColorExample example);

    int deleteByExample(ColorExample example);

    int deleteByPrimaryKey(String id);

    int insert(Color record);

    int insertSelective(Color record);

    List<Color> selectByExample(ColorExample example);

    Color selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Color record, @Param("example") ColorExample example);

    int updateByExample(@Param("record") Color record, @Param("example") ColorExample example);

    int updateByPrimaryKeySelective(Color record);

    int updateByPrimaryKey(Color record);
}