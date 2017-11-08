package com.zw.cf.dao;

import com.zw.cf.model.Door;
import com.zw.cf.model.DoorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DoorMapper {
    long countByExample(DoorExample example);

    int deleteByExample(DoorExample example);

    int deleteByPrimaryKey(String id);

    int insert(Door record);

    int insertSelective(Door record);

    List<Door> selectByExampleWithBLOBs(DoorExample example);

    List<Door> selectByExample(DoorExample example);

    Door selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Door record, @Param("example") DoorExample example);

    int updateByExampleWithBLOBs(@Param("record") Door record, @Param("example") DoorExample example);

    int updateByExample(@Param("record") Door record, @Param("example") DoorExample example);

    int updateByPrimaryKeySelective(Door record);

    int updateByPrimaryKeyWithBLOBs(Door record);

    int updateByPrimaryKey(Door record);
}