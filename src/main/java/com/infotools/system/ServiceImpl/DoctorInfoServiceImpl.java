package com.infotools.system.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.infotools.system.Entity.DoctorInfo;
import com.infotools.system.Mapper.DoctorInfoMapper;
import com.infotools.system.Service.DoctorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorInfoServiceImpl implements DoctorInfoService {

    @Autowired
    private DoctorInfoMapper doctorInfoMapper;

    @Override
    public PageInfo<DoctorInfo> findAllDocInfo(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);  //一个设置
        PageInfo<DoctorInfo> doctorInfoPageInfo = new PageInfo<DoctorInfo>(doctorInfoMapper.findAllDocInfo());
        return doctorInfoPageInfo;
    }

    @Override
    public Integer insertDoctorInfo(DoctorInfo doctorInfo) {
        return doctorInfoMapper.insertDoctorInfo(doctorInfo);
    }

    @Override
    public Integer deleteDoctorByID(Integer doc_id) {
        return doctorInfoMapper.deleteDoctorByID(doc_id);
    }

    @Override
    public DoctorInfo findDoctorByDocId(Integer doc_id) {
        return doctorInfoMapper.findDoctorByDocId(doc_id);
    }

    @Override
    public Integer updateByDocId(DoctorInfo doctorInfo) {
        return doctorInfoMapper.updateByDocId(doctorInfo);
    }

    @Override
    public PageInfo<DoctorInfo> findDoctorByDocCategory(Integer pageIndex, Integer pageSize, String doc_category) {
        PageHelper.startPage(pageIndex, pageSize);  //一个设置
        List<DoctorInfo> lists = doctorInfoMapper.findDoctorByDocCategory(doc_category);
        PageInfo<DoctorInfo> doctorInfoPageInfo = new PageInfo<DoctorInfo>(lists);
        return doctorInfoPageInfo;
    }

    @Override
    public List<DoctorInfo> findDocByCategoryOne() {
        return doctorInfoMapper.findDocByCategoryOne();
    }

    @Override
    public List<DoctorInfo> findDocByCategoryTwo() {
        return doctorInfoMapper.findDocByCategoryTwo();
    }

    @Override
    public List<DoctorInfo> findDocByCategoryThree() {
        return doctorInfoMapper.findDocByCategoryThree();
    }

    @Override
    public List<DoctorInfo> findDocByCategoryFour() {
        return doctorInfoMapper.findDocByCategoryFour();
    }

}
