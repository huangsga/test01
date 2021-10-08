package com.infotools.system.Service;

import com.github.pagehelper.PageInfo;
import com.infotools.system.Entity.UserDoubt;

import java.util.List;

public interface UserDoubtService {
    List<UserDoubt> findAllDoubt();

    PageInfo<UserDoubt> findAllUserDoubt(Integer pageIndex, Integer pageSize);

    Integer insertUserDoubt(UserDoubt userDoubt);

    UserDoubt findUserDoubtById(Integer mess_id);
    Integer updateUserDoubtById(UserDoubt userDoubt);
    Integer deleteUserDoubtByID(Integer mess_id);
}
