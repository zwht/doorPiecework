package com.zw.cf.dao;

import com.zw.cf.model.Gx;
import com.zw.cf.model.GxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GxMapper {
    long countByExample(GxExample example);

    int deleteByExample(GxExample example);

    int deleteByPrimaryKey(String id);

    int insert(Gx record);

    int insertSelective(Gx record);

    List<Gx> selectByExample(GxExample example);

    Gx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Gx record, @Param("example") GxExample example);

    int updateByExample(@Param("record") Gx record, @Param("example") GxExample example);

    int updateByPrimaryKeySelective(Gx record);

    int updateByPrimaryKey(Gx record);
}