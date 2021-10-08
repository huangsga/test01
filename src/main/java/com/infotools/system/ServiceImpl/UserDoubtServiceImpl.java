package com.infotools.system.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.infotools.system.Entity.UserDoubt;
import com.infotools.system.Mapper.UserDoubtMapper;
import com.infotools.system.Service.UserDoubtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDoubtServiceImpl implements UserDoubtService {
    @Autowired
    public UserDoubtMapper userDoubtMapper;

    @Override
    public List<UserDoubt> findAllDoubt() {
        return userDoubtMapper.findAllDoubt();
    }

    @Override
    public PageInfo<UserDoubt> findAllUserDoubt(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);  //一个设置
        PageInfo<UserDoubt> userDoubtPageInfo = new PageInfo<UserDoubt>(userDoubtMapper.findAllUserDoubt());
        return userDoubtPageInfo;
    }

    @Override
    public Integer insertUserDoubt(UserDoubt userDoubt) {
        return userDoubtMapper.insertUserDoubt(userDoubt);
    }

    @Override
    public UserDoubt findUserDoubtById(Integer mess_id) {
        return userDoubtMapper.findUserDoubtById(mess_id);
    }

    @Override
    public Integer updateUserDoubtById(UserDoubt userDoubt) {
        return userDoubtMapper.updateUserDoubtById(userDoubt);
    }

    @Override
    public Integer deleteUserDoubtByID(Integer mess_id) {
        return userDoubtMapper.deleteUserDoubtByID(mess_id);
    }


}
