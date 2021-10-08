package com.infotools.system.ServiceImpl;

import com.infotools.system.Entity.AllInfo1;
import com.infotools.system.Entity.EventInfo;
import com.infotools.system.Mapper.AllInfo1Mapper;
//import com.infotools.system.Mapper.EventInfoMapper;
import com.infotools.system.Service.AllInfo1Service;
import com.infotools.system.Service.EventDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AllInfo1ServiceImpl implements AllInfo1Service {
    @Autowired
    private AllInfo1Mapper AllInfo1Mapper;
    @Override
    public List<AllInfo1> findAllInfo1() {
        return AllInfo1Mapper.findAllInfo1();
    }
}