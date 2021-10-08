package com.infotools.system.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.infotools.system.Entity.SysLog;
import com.infotools.system.Entity.UserInfo;
import com.infotools.system.Mapper.UserInfoMapper;
import com.infotools.system.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public PageInfo<UserInfo> findAllUserInfo(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        PageInfo<UserInfo> userInfoPageInfo = new PageInfo<UserInfo>(userInfoMapper.findAllUserInfo());
        return userInfoPageInfo;
    }

    @Override
    public Integer insertUserInfo(UserInfo userInfo) {
        return userInfoMapper.insertUserInfo(userInfo);
    }

    @Override
    public Integer deleteUserByID(Integer user_id) {
        return userInfoMapper.deleteUserByID(user_id);
    }

    @Override
    public UserInfo findUserByUserId(Integer user_id) {
        return userInfoMapper.findUserByUserId(user_id);
    }

    @Override
    public Integer updateByUserId(UserInfo userInfo) {
        return userInfoMapper.updateByUserId(userInfo);
    }

    @Override
    public PageInfo<UserInfo> findUserInfoByUserName(Integer pageIndex, Integer pageSize, String user_name) {
        PageHelper.startPage(pageIndex, pageSize);
        PageInfo<UserInfo> userInfoPageInfo = new PageInfo<UserInfo>(userInfoMapper.findUserInfoByUserName(user_name));
        return userInfoPageInfo;
    }

    @Override
    public UserInfo UserLogin(String user_name, String password, Integer power) {
        return userInfoMapper.UserLogin(user_name, password, power);
    }

    @Override
    public UserInfo findUserByEmail(String checkEmail, String user_name) {
        return userInfoMapper.findUserInfoByEmail(checkEmail, user_name);
    }

    //插入登录日志
    @Override
    public Integer InsertSysLog(SysLog log) {
        return userInfoMapper.InsertSysLog(log);
    }
    //查询所有登录信息并显示在管理员端
    @Override
    public PageInfo<SysLog> findAllSysLog(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        PageInfo<SysLog> sysLogPageInfo = new PageInfo<SysLog>(userInfoMapper.findAllSysLog());
        return sysLogPageInfo;
    }

    @Override
    public List<UserInfo> findAllUserud(Integer ud){return userInfoMapper.findAllUserud(ud);}
    public List<UserInfo> findAllUseruc(String uc){return userInfoMapper.findAllUseruc(uc);}
    public List<UserInfo> findAllUserus(Integer us){return userInfoMapper.findAllUserus(us);}

}