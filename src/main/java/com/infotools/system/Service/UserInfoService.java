package com.infotools.system.Service;


import com.github.pagehelper.PageInfo;
import com.infotools.system.Entity.SysLog;
import com.infotools.system.Entity.UserInfo;

import java.util.List;

public interface UserInfoService {
    PageInfo<UserInfo> findAllUserInfo(Integer pageIndex, Integer pageSize);

    Integer insertUserInfo(UserInfo userInfo);

    Integer deleteUserByID(Integer user_id);

    UserInfo findUserByUserId(Integer user_id);

    Integer updateByUserId(UserInfo userInfo);

    PageInfo<UserInfo> findUserInfoByUserName(Integer pageIndex, Integer pageSize, String user_name);

    UserInfo UserLogin(String user_name, String password, Integer power);

    UserInfo findUserByEmail(String checkEmail, String user_name);

    //登录日志功能
    Integer InsertSysLog(SysLog log);
    PageInfo<SysLog> findAllSysLog(Integer pageIndex, Integer pageSize);

    List<UserInfo> findAllUserud(Integer ud);
    List<UserInfo> findAllUseruc(String uc);

    List<UserInfo> findAllUserus(Integer us);
}

