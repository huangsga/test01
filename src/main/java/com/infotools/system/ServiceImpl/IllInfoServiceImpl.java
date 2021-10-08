package com.infotools.system.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.infotools.system.Entity.IllInfo;
import com.infotools.system.Mapper.IllInfoMapper;
import com.infotools.system.Service.IllInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IllInfoServiceImpl implements IllInfoService {
    @Autowired
    private IllInfoMapper illInfoMapper;

    @Override
    public PageInfo<IllInfo> findAllIll(Integer pageIndex,Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<IllInfo>lists=illInfoMapper.findAllIllInfo();
        PageInfo<IllInfo> info=new PageInfo<IllInfo>(lists);
        return info;
    }

    @Override
    public Integer insertIllInfo(IllInfo ill) { return illInfoMapper.insertIllInfo(ill); }

    @Override
    public Integer deleteIllByID(Integer ill_id) { return illInfoMapper.deleteIllByID(ill_id); }



    @Override
    public IllInfo findIllByIllId(Integer ill_id) { return illInfoMapper.findIllByIllId(ill_id); }

    @Override
    public Integer updateByIllId(IllInfo illInfo){return illInfoMapper.updateByIllId(illInfo);}

    @Override
    public PageInfo<IllInfo> findIllInfoByIllName(Integer pageIndex,Integer pageSize,String ill_name) {
        PageHelper.startPage(pageIndex,pageSize);
        List<IllInfo>lists=illInfoMapper.findIllInfoByIllName(ill_name);
        PageInfo<IllInfo> info=new PageInfo<IllInfo>(lists);
        return info; }




    @Override
    public List<IllInfo> findAllIllcstage(String cstage){return illInfoMapper.findAllIllcstage(cstage);}
    @Override
    public List<IllInfo> findAllIllcid(Integer ill_id) {
        return illInfoMapper.findAllIllcid(ill_id);
    }
    @Override
    public List<IllInfo> findAllIllcage(String cage){return illInfoMapper.findAllIllcage(cage);}


    @Override
    public List<IllInfo> findAllIlltstage(String tstage){return illInfoMapper.findAllIlltstage(tstage);}
    @Override
    public List<IllInfo> findAllIlltid(Integer ill_id) {
        return illInfoMapper.findAllIlltid(ill_id);
    }
    @Override
    public List<IllInfo> findAllIlltage(String tage){return illInfoMapper.findAllIlltage(tage);}


    @Override
    public List<IllInfo> findAllIllmstage(String mstage){return illInfoMapper.findAllIllmstage(mstage);}
    @Override
    public List<IllInfo> findAllIllmid(Integer ill_id) {
        return illInfoMapper.findAllIllmid(ill_id);
    }
    @Override
    public List<IllInfo> findAllIllmage(String mage){return illInfoMapper.findAllIllmage(mage);}


    @Override
    public List<IllInfo> findAllIllostage(String ostage){return illInfoMapper.findAllIllostage(ostage);}
    @Override
    public List<IllInfo> findAllIlloid(Integer ill_id) {
        return illInfoMapper.findAllIlloid(ill_id);
    }
    @Override
    public List<IllInfo> findAllIlloage(String oage){return illInfoMapper.findAllIlloage(oage);}

}