package com.infotools.system.Mapper;

import com.infotools.system.Entity.EventData;
import com.infotools.system.Entity.EventData1;
import com.infotools.system.Service.EventData1Service;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
@Mapper
public interface EventData1Mapper {
    @Select("SELECT event_abstract,event_details,click_num,share_num,pub_time FROM event_data where event_id='1'")
    List<EventData1> findAllEventData1();
    @Select("SELECT event_abstract,event_details,click_num,share_num,pub_time FROM event_data where event_id='2'")
    List<EventData1> findAllEventData11();
    @Select("SELECT event_abstract,event_details,click_num,share_num,pub_time FROM event_data where event_id='3'")
    List<EventData1> findAllEventData111();
}