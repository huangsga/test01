package com.infotools.system.ServiceImpl;

import com.infotools.system.Entity.AllInfo;
import com.infotools.system.Mapper.AllInfoMapper;
import com.infotools.system.Service.AllInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllInfoServiceImpl implements AllInfoService {
    @Autowired
    private AllInfoMapper allInfoMapper;
    @Override
    public List<AllInfo> findAllAll() { return allInfoMapper.findAllAllInfo(); }

    @Override
    public Integer insertAllInfo(AllInfo all) { return allInfoMapper.insertAllInfo(all); }

    @Override
    public Integer deleteAllByID(Integer sys_id) { return allInfoMapper.deleteAllByID(sys_id); }



    @Override
    public AllInfo findAllByAllId(Integer sys_id) { return allInfoMapper.findAllByAllId(sys_id); }

    @Override
    public Integer updateByAllId(AllInfo allInfo){return allInfoMapper.updateByAllId(allInfo);}

    @Override
    public List<AllInfo> findAllInfoByAllName(String sys_name) {return allInfoMapper.findAllInfoByAllName(sys_name);}




}