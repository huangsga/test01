package com.infotools.system.Service;
import com.infotools.system.Entity.EventInfo1;
import java.util.List;

public interface EventInfo1Service {
    List<EventInfo1> findAllEvent1();
    List<EventInfo1> findEventInfo1Bydate_time(String date_time);
}