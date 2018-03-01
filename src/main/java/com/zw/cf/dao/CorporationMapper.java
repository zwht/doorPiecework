package com.zw.cf.dao;

import com.zw.cf.model.Corporation;
import com.zw.cf.model.CorporationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CorporationMapper {
    long countByExample(CorporationExample example);

    int deleteByExample(CorporationExample example);

    int deleteByPrimaryKey(String id);

    int insert(Corporation record);

    int insertSelective(Corporation record);

    List<Corporation> selectByExample(CorporationExample example);

    Corporation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Corporation record, @Param("example") CorporationExample example);

    int updateByExample(@Param("record") Corporation record, @Param("example") CorporationExample example);

    int updateByPrimaryKeySelective(Corporation record);

    int updateByPrimaryKey(Corporation record);
}