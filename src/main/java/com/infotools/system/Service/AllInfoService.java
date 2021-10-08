package com.infotools.system.Service;




import com.infotools.system.Entity.AllInfo;

import java.util.List;

public interface AllInfoService {
    List<AllInfo> findAllAll();
    Integer insertAllInfo(AllInfo all);
    Integer deleteAllByID(Integer sys_id);
    AllInfo findAllByAllId(Integer sys_id);
    Integer updateByAllId(AllInfo allInfo);
    List<AllInfo> findAllInfoByAllName(String name);
}

