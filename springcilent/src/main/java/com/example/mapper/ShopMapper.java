package com.example.mapper;


import com.example.eneity.TblSafetyWork;
import org.apache.ibatis.annotations.*;

/**
 * 实现对于接口数据sql
 */
@Mapper
public interface ShopMapper {

    @Select("select * from tbl_safety_work WHERE id = #{id}")
    @Results(value = { @Result(id = true, column = "id", property = "id"),
           @Result(column = "work_name", property = "workName") })
 public TblSafetyWork getShop(@Param("id") int id);
}
