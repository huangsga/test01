package com.infotools.system.ServiceImpl;

import com.infotools.system.Entity.EventData;
import com.infotools.system.Mapper.EventDataMapper;
import com.infotools.system.Service.EventDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventDataServiceImpl implements EventDataService {

    @Autowired
    private EventDataMapper EventDataMapper;


    @Override
    public List<EventData> findAllEvent() {
        return EventDataMapper.findAllEventData();

    }

    @Override
    public Integer insertEventData(EventData event) {
        return EventDataMapper.insertEventData(event);
    }

    @Override
    public Integer deleteByEventID(Integer EventID) {
        return EventDataMapper.deleteByEventID(EventID);
    }

    @Override
    public EventData findByEventID(Integer event_id) {
        return EventDataMapper.findByEventID(event_id);
    }


    @Override
    public Integer updateByEventID(EventData eventdata) {
        return EventDataMapper.updateByEventID(eventdata);
    }

    @Override
    public List<EventData> findEventDataByevent_id(String  pub_time) {
        return EventDataMapper.findEventDataByevent_title(pub_time);
    }

    @Override
    public EventData findByEventID1(Integer event_id) {
        return EventDataMapper.findByEventID1(event_id);
    }

    @Override
    public Integer updateByEventID1(EventData eventdata1) {
        return EventDataMapper.updateByEventID1(eventdata1);
    }

    //@Override
    //public List<EventData> findEventDataByEventID(Integer EventID) {
    //    return EventDataMapper.findEventDataByEventID(EventID);
    //}

    //@Override
    //public EventData findByevent_title(String  event_title) {
    //    return EventDataMapper.findEventDataByevent_title(event_title);}

}
