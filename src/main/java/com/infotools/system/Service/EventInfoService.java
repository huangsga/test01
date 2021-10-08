package com.infotools.system.Service;

import com.github.pagehelper.PageInfo;
import com.infotools.system.Entity.EventData;
import com.infotools.system.Entity.EventInfo;


import java.util.List;

public interface EventInfoService {
    List<EventInfo> findAllEvent();
    PageInfo<EventInfo> findAllEvent(Integer pageIndex,Integer pageSize);
    PageInfo<EventInfo> findEventInfoByevent_title(Integer pageIndex,Integer pageSize,String date_time);
    Integer insertEventInfo(EventInfo event);
    EventInfo findByEventID(Integer event_id);
    Integer updateByEventID(EventInfo eventInfo);
    Integer deleteByEventID(Integer event_id);
    List<EventInfo> findEventInfoByevent_id(String date_time);

    EventInfo findByEventID1(Integer event_id);
    Integer updateByEventID1(EventInfo eventInfo1);
}