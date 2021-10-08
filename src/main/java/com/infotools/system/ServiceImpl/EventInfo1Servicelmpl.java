package com.infotools.system.ServiceImpl;
import com.infotools.system.Entity.EventInfo1;
import com.infotools.system.Service.EventInfo1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EventInfo1Servicelmpl implements EventInfo1Service {
    @Autowired
    private com.infotools.system.Mapper.EventInfo1Mapper EventInfo1Mapper;
    @Override
    public List<EventInfo1> findAllEvent1() {
        return EventInfo1Mapper.findAllEventInfo1();
    }

    @Override
    public List<EventInfo1> findEventInfo1Bydate_time(String date_time) {
        return EventInfo1Mapper.findEventInfo1Bydate_time(date_time);
    }
}