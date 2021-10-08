package com.infotools.system.Mapper;

import com.infotools.system.Entity.EventData;
import com.infotools.system.Entity.EventInfo;
import com.infotools.system.Entity.EventInfo1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
@Mapper
public interface EventInfo1Mapper {
    @Select("SELECT date_time,event_abstract,event_address,event_details FROM event_info")
    List<EventInfo1> findAllEventInfo1();
    @Select("select * from event_info  where date_time like '%${date_time}%'")
    List<EventInfo1> findEventInfo1Bydate_time(String date_time);
}