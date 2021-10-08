package com.infotools.system.Service;

import com.infotools.system.Entity.EventData;

import java.util.List;

public interface EventDataService {
    List<EventData> findAllEvent();
    Integer insertEventData(EventData event);
    Integer deleteByEventID(Integer event_id);
    EventData findByEventID(Integer event_id);
    Integer updateByEventID(EventData eventdata);
    List<EventData> findEventDataByevent_id(String pub_time);

    EventData findByEventID1(Integer event_id);
    Integer updateByEventID1(EventData eventdata1);
}