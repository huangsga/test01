package com.infotools.system.Service;
import com.github.pagehelper.PageInfo;
import com.infotools.system.Entity.IllInfo;
import com.infotools.system.Entity.UserInfo;

import java.util.List;

public interface IllInfoService {
    PageInfo<IllInfo> findAllIll(Integer pageIndex, Integer pageSize);

    Integer insertIllInfo(IllInfo ill);
    Integer deleteIllByID(Integer ill_id);
    IllInfo findIllByIllId(Integer ill_id);
    Integer updateByIllId(IllInfo illInfo);
    PageInfo<IllInfo> findIllInfoByIllName(Integer pageIndex,Integer pageSize,String ill_name);

    List<IllInfo> findAllIllcstage(String cstage);
    List<IllInfo> findAllIllcid(Integer ill_id);
    List<IllInfo> findAllIllcage(String cage);

    List<IllInfo> findAllIlltstage(String tstage);
    List<IllInfo> findAllIlltid(Integer ill_id);
    List<IllInfo> findAllIlltage(String tage);

    List<IllInfo> findAllIllmstage(String mstage);
    List<IllInfo> findAllIllmid(Integer ill_id);
    List<IllInfo> findAllIllmage(String mage);

    List<IllInfo> findAllIllostage(String ostage);
    List<IllInfo> findAllIlloid(Integer ill_id);
    List<IllInfo> findAllIlloage(String oage);

}

