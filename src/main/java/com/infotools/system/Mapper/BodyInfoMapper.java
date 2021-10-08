package com.infotools.system.Mapper;

import com.infotools.system.Entity.BodyInfo;
import com.infotools.system.Entity.DetailTime;
import com.infotools.system.Entity.IllInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface BodyInfoMapper {
    @Select("SELECT * FROM body_info")
    List<BodyInfo> findAllBodyInfo();

    @Insert("\n"+
            "Insert into body_info (bodysystem,organ,ill_name,ill_reason,ill_details,ill_advice,ill_cure)\n" +
            "                   values(#{bodysystem},#{organ},#{ill_name},#{ill_reason},#{ill_details},#{ill_advice},#{ill_cure})")
    Integer insertBody(BodyInfo body);
    @Select("select * from body_info where bodysystem like '%${bodysystem}%'")
    List<BodyInfo> findBodyBySystem(String bodysystem);
    @Select("select * from body_info where body_id=#{body_id}")
    List<BodyInfo> findBodyById(Integer body_id);
    @Update("update body_info set bodysystem=#{bodysystem},organ=#{organ},ill_name=#{ill_name},ill_reason=#{ill_reason},ill_details=#{ill_details},ill_advice=#{ill_advice},ill_cure=#{ill_cure} where body_id=#{body_id}")
    Integer updateBodyByID(BodyInfo body);
    @Delete("delete from body_info where body_id=#{body_id}")
    Integer deleteBodyByID(Integer body_id);

    @Select("select ill_name,bodysystem from body_info;")
    List<BodyInfo> findBodyByname(String ill_name);

    @Select("select * from body_info where body_info.bodysystem = '运动系统' ")
    List<BodyInfo> findBodyInfoByyundong(String bodysystem);
    @Select("select * from body_info where body_info.bodysystem = '呼吸系统' ")
    List<BodyInfo> findBodyInfoByhuxi(String bodysystem);
    @Select("select * from body_info where body_info.bodysystem = '消化系统' limit 9 ")
    List<BodyInfo> findBodyInfoByxiaohua(String bodysystem);
    @Select("select * from body_info where body_info.bodysystem = '生殖系统' ")
    List<BodyInfo> findBodyInfoByshenzhi(String bodysystem);
    @Select("select * from body_info where body_info.bodysystem = '泌尿系统' ")
    List<BodyInfo> findBodyInfoByminiao(String bodysystem);
    @Select("select * from body_info where body_info.bodysystem = '循环系统' ")
    List<BodyInfo> findBodyInfoByxunhuan(String bodysystem);
    @Select("select * from body_info where body_info.bodysystem = '神经系统' ")
    List<BodyInfo> findBodyInfoByshenjing(String bodysystem);
    @Select("select * from body_info where body_info.bodysystem = '内分泌系统' ")
    List<BodyInfo> findBodyInfoByneifenmi(String bodysystem);
    @Select("select * from body_info where ill_details like '%${ill_details}%'")
    List<BodyInfo> findIllByDetails(String ill_details);
    @Select("select * from body_info where body_id=#{body_id}")
    List<BodyInfo> findAllInfoByillname(Integer body_id);

    @Select("select * from detailstime where ill_name='腰椎间盘突出'")
    List<DetailTime> findAllyaojianpan(String ill_name);
    @Select("select * from detailstime where ill_name='风湿性关节炎'")
    List<DetailTime> findAllguanjie(String ill_name);
    @Select("select * from detailstime where ill_name='慢性阑尾炎'")
    List<DetailTime> findAlllanwei(String ill_name);
    @Select("select * from detailstime where ill_name='哮喘'")
    List<DetailTime> findAllxiaochuan(String ill_name);
    @Select("select * from detailstime where ill_name='子宫宫颈癌'")
    List<DetailTime> findAllgongjin(String ill_name);
    @Select("select * from detailstime where ill_name='糖尿病'")
    List<DetailTime> findAlltangniao(String ill_name);
    @Select("select * from detailstime where ill_name='高血压'")
    List<DetailTime> findAllgaoya(String ill_name);
    @Select("select * from detailstime where ill_name='老年痴呆'")
    List<DetailTime> findAllchidai(String ill_name);
    @Select("select * from detailstime where ill_name='胆结石'")
    List<DetailTime> findAlljieshi(String ill_name);
    @Select("select * from detailstime where ill_name='肺结核'")
    List<DetailTime> findAlljiehe(String ill_name);
    @Select("select * from detailstime where ill_name='膀胱炎'")
    List<DetailTime> findAlllpangguang(String ill_name);
    @Select("select * from detailstime where ill_name='低血糖'")
    List<DetailTime> findAllditang(String ill_name);
    @Select("select * from detailstime where ill_name='冠心病'")
    List<DetailTime> findAllguanxin(String ill_name);
    @Select("select * from detailstime where ill_name='坐骨神经痛'")
    List<DetailTime> findAllzuogu(String ill_name);
    @Select("select * from detailstime where ill_name='前列腺癌'")
    List<DetailTime> findAllqianlie(String ill_name);
    @Select("select * from detailstime where ill_name='尿毒症'")
    List<DetailTime> findAllniaodu(String ill_name);

}
