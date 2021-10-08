package com.infotools.system.ServiceImpl;

import com.infotools.system.Entity.EventData;
import com.infotools.system.Entity.EventData1;
import com.infotools.system.Mapper.EventData1Mapper;
import com.infotools.system.Mapper.EventDataMapper;
import com.infotools.system.Service.EventData1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventData1Servicelmpl implements EventData1Service {
    @Autowired
    private EventData1Mapper EventData1Mapper;



    @Override
    public List<EventData1> findAllEvent2() {
        return EventData1Mapper.findAllEventData1();
    }

    @Override
    public List<EventData1> findAllEvent22() {
        return EventData1Mapper.findAllEventData11();
    }

    @Override
    public List<EventData1> findAllEvent222() {
        return EventData1Mapper.findAllEventData111();
    }
}