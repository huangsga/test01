package com.infotools.system.Service;

import com.github.pagehelper.PageInfo;
import com.infotools.system.Entity.BodyInfo;
import com.infotools.system.Entity.DetailTime;
import com.infotools.system.Entity.IllInfo;
import com.sun.xml.internal.ws.wsdl.writer.document.soap.Body;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BodyInfoService {
    PageInfo<BodyInfo> findAllBodyInfo(Integer pageIndex, Integer pageSize);

    Integer insertBody(BodyInfo body);

    PageInfo<BodyInfo> findBodyBySystem(Integer pageIndex, Integer pageSize, String bodysystem);
    List<BodyInfo> findBodyById(Integer body_id);

    Integer updateBodyByID(BodyInfo body);

    Integer deleteBodyByID(Integer body_id);

    List<BodyInfo> findBodyInfoByyundong(String bodysystem);
    List<BodyInfo> findBodyInfoByhuxi(String bodysystem);
    List<BodyInfo> findBodyInfoByxiaohua(String bodysystem);
    List<BodyInfo> findBodyInfoByshenzhi(String bodysystem);
    List<BodyInfo> findBodyInfoByminiao(String bodysystem);
    List<BodyInfo> findBodyInfoByxunhuan(String bodysystem);
    List<BodyInfo> findBodyInfoByshenjing(String bodysystem);
    List<BodyInfo> findBodyInfoByneifenmi(String bodysystem);

    List<BodyInfo> findIllByDetails(String ill_details);

    List<BodyInfo> findAllInfoByillname(Integer body_id);

    List<DetailTime> findAllyaojianpan(String ill_name);
    List<DetailTime> findAllguanjie(String ill_name);
    List<DetailTime> findAlllanwei(String ill_name);
    List<DetailTime> findAllxiaochuan(String ill_name);
    List<DetailTime> findAllgongjin(String ill_name);
    List<DetailTime> findAlltangniao(String ill_name);
    List<DetailTime> findAllgaoya(String ill_name);
    List<DetailTime> findAllchidai(String ill_name);
    List<DetailTime> findAlljieshi(String ill_name);
    List<DetailTime> findAlljiehe(String ill_name);
    List<DetailTime> findAlllpangguang(String ill_name);
    List<DetailTime> findAllditang(String ill_name);
    List<DetailTime> findAllguanxin(String ill_name);
    List<DetailTime> findAllzuogu(String ill_name);
    List<DetailTime> findAllqianlie(String ill_name);
    List<DetailTime> findAllniaodu(String ill_name);
}
