package com.infotools.system.Mapper;

import com.infotools.system.Entity.DoctorInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DoctorInfoMapper {
    @Select("select * from doctor_info")
    List<DoctorInfo> findAllDocInfo();

    @Insert("insert into doctor_info(doc_category,doc_hospital,doc_name,doc_awards,doc_details,doc_title) VALUES (#{doc_category},#{doc_hospital},#{doc_name},#{doc_awards},#{doc_details},#{doc_title})")
    Integer insertDoctorInfo(DoctorInfo doctorInfo);

    @Delete("delete from doctor_info where doc_id=#{doc_id}")
    Integer deleteDoctorByID(Integer doc_id);

    @Select("select * from doctor_info where doc_id=#{doc_id}")
    DoctorInfo findDoctorByDocId(Integer doc_id);

    @Update("update doctor_info set doc_category=#{doc_category},doc_hospital=#{doc_hospital},doc_name=#{doc_name},doc_awards=#{doc_awards},doc_details=#{doc_details},doc_title=#{doc_title} where doc_id=#{doc_id}")
    Integer updateByDocId(DoctorInfo doctorInfo);

    @Select("select * from doctor_info where doc_category like '%${doc_category}%'")
    List<DoctorInfo> findDoctorByDocCategory(String doc_category);

    @Select("select * from doctor_info where doc_category='心理精神科' limit 4")
    List<DoctorInfo> findDocByCategoryOne();
    @Select("select * from doctor_info where doc_category='妇产科' limit 3")
    List<DoctorInfo> findDocByCategoryTwo();
    @Select("select * from doctor_info where doc_category='内科' limit 4")
    List<DoctorInfo> findDocByCategoryThree();
    @Select("select * from doctor_info where doc_category='外科' limit 4")
    List<DoctorInfo> findDocByCategoryFour();


}


