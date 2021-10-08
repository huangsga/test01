package com.infotools.system.Service;

import com.github.pagehelper.PageInfo;
import com.infotools.system.Entity.DoctorInfo;
import com.infotools.system.Entity.UserInfo;
import com.sun.corba.se.impl.interceptors.PICurrent;

import java.util.List;

public interface DoctorInfoService {
    PageInfo<DoctorInfo> findAllDocInfo(Integer pageIndex, Integer pageSize);

    Integer insertDoctorInfo(DoctorInfo doctorInfo);

    Integer deleteDoctorByID(Integer doc_id);

    DoctorInfo findDoctorByDocId(Integer doc_id);
    Integer updateByDocId(DoctorInfo doctorInfo);

    PageInfo<DoctorInfo> findDoctorByDocCategory(Integer pageIndex, Integer pageSize,String doc_category);

    List<DoctorInfo> findDocByCategoryOne();
    List<DoctorInfo> findDocByCategoryTwo();
    List<DoctorInfo> findDocByCategoryThree();
    List<DoctorInfo> findDocByCategoryFour();
}
