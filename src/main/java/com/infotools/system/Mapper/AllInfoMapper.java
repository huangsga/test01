package com.infotools.system.Mapper;

import com.infotools.system.Entity.AllInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AllInfoMapper {
    @Select("SELECT * FROM all_info")
     List<AllInfo> findAllAllInfo();
    @Insert("insert into all_info(sys_id,name,category,sys_abstract,details,advice,img_url)  VALUES(#{sys_id},#{name},#{category},#{sys_abstract},#{details},#{advice},#{img_url})")
    Integer insertAllInfo(AllInfo all);

    @Delete("delete from all_info where sys_id=#{sys_id}")
    Integer deleteAllByID(Integer sys_id);

    @Update("update all_info set sys_id=#{sys_id},name=#{name},category=#{category},sys_abstract=#{sys_abstract},details=#{details},advice=#{advice},img_url=#{img_url} where sys_id=#{sys_id}")
    Integer updateByAllId(AllInfo allInfo);

    @Select("select * from all_info where sys_id=#{sys_id}")
    AllInfo findAllByAllId(Integer sys_id);

    @Select("select si.* from all_info si where si.name like '%${name}%'")
    List<AllInfo> findAllInfoByAllName(String name);
}