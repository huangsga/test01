package com.infotools.system.Mapper;

import com.infotools.system.Entity.IllInfo;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IllInfoMapper {
    @Select("SELECT * FROM ill_info")
     List<IllInfo> findAllIllInfo();
    @Insert("insert into ill_info(stage,ill_name,age,ill_abstract,ill_reason,ill_details,ill_advice)  VALUES (#{stage},#{ill_name},#{age},#{ill_abstract},#{ill_reason},#{ill_details},#{ill_advice})")
    Integer insertIllInfo(IllInfo ill);

    @Delete("delete from ill_info where ill_id=#{ill_id}")
    Integer deleteIllByID(Integer il_id);

    @Update("update ill_info set stage=#{stage},ill_name=#{ill_name},age=#{age},ill_abstract=#{ill_abstract},ill_reason=#{ill_reason},ill_details=#{ill_details},ill_advice=#{ill_advice} where ill_id=#{ill_id}")
    Integer updateByIllId(IllInfo illInfo);

    @Select("select * from ill_info where ill_id=#{ill_id}")
    IllInfo findIllByIllId(Integer ill_id);

    @Select("select si.* from ill_info si where si.ill_name like '%${ill_name}%'")
    List<IllInfo> findIllInfoByIllName(String ill_name);

    @Select("select si.* from ill_info si where si.stage like '%婴幼儿%'")
    List<IllInfo> findAllIllcstage(String cstage);
    @Select("select * from ill_info where stage like '%婴幼儿%' and ill_id = '${ill_id}'")
    List<IllInfo> findAllIllcid(Integer ill_id);
    @Select("select count(age) as count,stage,age from ill_info where stage='婴幼儿'group by age")
    List<IllInfo> findAllIllcage(String cage);

    @Select("select si.* from ill_info si where si.stage like '%青少年%'")
    List<IllInfo> findAllIlltstage(String tstage);
    @Select("select * from ill_info where stage like '%青少年%' and ill_id = '${ill_id}'")
    List<IllInfo> findAllIlltid(Integer ill_id);
    @Select("select count(age) as count,stage,age from ill_info where stage='青少年'group by age")
    List<IllInfo> findAllIlltage(String tage);

    @Select("select si.* from ill_info si where si.stage like '%中年%'")
    List<IllInfo> findAllIllmstage(String mstage);
    @Select("select * from ill_info where stage like '%中年%' and ill_id = '${ill_id}'")
    List<IllInfo> findAllIllmid(Integer ill_id);
    @Select("select count(age) as count,stage,age from ill_info where stage='中年'group by age")
    List<IllInfo> findAllIllmage(String mage);

    @Select("select si.* from ill_info si where si.stage like '%老年%'")
    List<IllInfo> findAllIllostage(String ostage);
    @Select("select * from ill_info where stage like '%老年%' and ill_id = '${ill_id}'")
    List<IllInfo> findAllIlloid(Integer ill_id);
    @Select("select count(age) as count,stage,age from ill_info where stage='老年'group by age")
    List<IllInfo> findAllIlloage(String oage);



}