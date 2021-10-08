package com.infotools.system.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.infotools.system.Entity.BodyInfo;
import com.infotools.system.Entity.DetailTime;
import com.infotools.system.Entity.IllInfo;
import com.infotools.system.Mapper.BodyInfoMapper;
import com.infotools.system.Service.BodyInfoService;
import com.sun.xml.internal.ws.wsdl.writer.document.soap.Body;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BodyInfoServiceImpl implements BodyInfoService {

    @Autowired
    private BodyInfoMapper bodyInfoMapper;

    @Override
    public PageInfo<BodyInfo> findAllBodyInfo(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<BodyInfo> lists = bodyInfoMapper.findAllBodyInfo();
        PageInfo<BodyInfo> info = new PageInfo<BodyInfo>(lists);
        return info;
    }


    @Override
    public Integer insertBody(BodyInfo bodyinfo) {
        return bodyInfoMapper.insertBody(bodyinfo);
    }

    @Override
    public PageInfo<BodyInfo> findBodyBySystem(Integer pageIndex, Integer pageSize, String bodysystem) {
        PageHelper.startPage(pageIndex, pageSize);
        List<BodyInfo> lists = bodyInfoMapper.findBodyBySystem(bodysystem);
        PageInfo<BodyInfo> info = new PageInfo<BodyInfo>(lists);
        return info;
    }


    @Override
    public List<BodyInfo> findBodyById(Integer body_id) {
        return bodyInfoMapper.findBodyById(body_id);
    }

    @Override
    public Integer updateBodyByID(BodyInfo body) {
        return bodyInfoMapper.updateBodyByID(body);
    }

    @Override
    public Integer deleteBodyByID(Integer body_id) {
        return bodyInfoMapper.deleteBodyByID(body_id);
    }

    @Override
    public List<BodyInfo> findBodyInfoByyundong(String bodysystem) {
        return bodyInfoMapper.findBodyInfoByyundong(bodysystem);
    }

    @Override
    public List<BodyInfo> findBodyInfoByhuxi(String bodysystem) {
        return bodyInfoMapper.findBodyInfoByhuxi(bodysystem);
    }

    @Override
    public List<BodyInfo> findBodyInfoByxiaohua(String bodysystem) {
        return bodyInfoMapper.findBodyInfoByxiaohua(bodysystem);
    }

    @Override
    public List<BodyInfo> findBodyInfoByshenzhi(String bodysystem) {
        return bodyInfoMapper.findBodyInfoByshenzhi(bodysystem);
    }

    @Override
    public List<BodyInfo> findBodyInfoByminiao(String bodysystem) {
        return bodyInfoMapper.findBodyInfoByminiao(bodysystem);
    }

    @Override
    public List<BodyInfo> findBodyInfoByxunhuan(String bodysystem) {
        return bodyInfoMapper.findBodyInfoByxunhuan(bodysystem);
    }

    @Override
    public List<BodyInfo> findBodyInfoByshenjing(String bodysystem) {
        return bodyInfoMapper.findBodyInfoByshenzhi(bodysystem);
    }

    @Override
    public List<BodyInfo> findBodyInfoByneifenmi(String bodysystem) {
        return bodyInfoMapper.findBodyInfoByneifenmi(bodysystem);
    }

    @Override
    public List<BodyInfo> findIllByDetails(String ill_details) {
        return bodyInfoMapper.findIllByDetails(ill_details);
    }

    @Override
    public List<BodyInfo> findAllInfoByillname(Integer body_id) {
        return bodyInfoMapper.findAllInfoByillname(body_id);
    }

    @Override
    public List<DetailTime> findAllyaojianpan(String ill_name) {
        return bodyInfoMapper.findAllyaojianpan(ill_name);
    }

    @Override
    public List<DetailTime> findAllguanjie(String ill_name) {
        return bodyInfoMapper.findAllguanjie(ill_name);
    }

    @Override
    public List<DetailTime> findAlllanwei(String ill_name) {
        return bodyInfoMapper.findAlllanwei(ill_name);
    }

    @Override
    public List<DetailTime> findAllxiaochuan(String ill_name) {
        return bodyInfoMapper.findAllxiaochuan(ill_name);
    }

    @Override
    public List<DetailTime> findAllgongjin(String ill_name) {
        return bodyInfoMapper.findAllgongjin(ill_name);
    }

    @Override
    public List<DetailTime> findAlltangniao(String ill_name) {
        return bodyInfoMapper.findAlltangniao(ill_name);
    }

    @Override
    public List<DetailTime> findAllgaoya(String ill_name) {
        return bodyInfoMapper.findAllgaoya(ill_name);
    }

    @Override
    public List<DetailTime> findAllchidai(String ill_name) {
        return bodyInfoMapper.findAllchidai(ill_name);
    }

    @Override
    public List<DetailTime> findAlljieshi(String ill_name) {
        return bodyInfoMapper.findAlljieshi(ill_name);
    }

    @Override
    public List<DetailTime> findAlljiehe(String ill_name) {
        return bodyInfoMapper.findAlljiehe(ill_name);
    }

    @Override
    public List<DetailTime> findAlllpangguang(String ill_name) {
        return bodyInfoMapper.findAlllpangguang(ill_name);
    }

    @Override
    public List<DetailTime> findAllditang(String ill_name) {
        return bodyInfoMapper.findAllditang(ill_name);
    }

    @Override
    public List<DetailTime> findAllguanxin(String ill_name) {
        return bodyInfoMapper.findAllguanxin(ill_name);
    }

    @Override
    public List<DetailTime> findAllzuogu(String ill_name) {
        return bodyInfoMapper.findAllzuogu(ill_name);
    }

    @Override
    public List<DetailTime> findAllqianlie(String ill_name) {
        return bodyInfoMapper.findAllqianlie(ill_name);
    }

    @Override
    public List<DetailTime> findAllniaodu(String ill_name) {
        return bodyInfoMapper.findAllniaodu(ill_name);
    }


}
