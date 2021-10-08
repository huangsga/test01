package com.infotools.system.Mapper;

import com.infotools.system.Entity.AllInfo1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface AllInfo1Mapper {
    @Select("SELECT details,advice from all_info")
    List<AllInfo1> findAllInfo1();
}