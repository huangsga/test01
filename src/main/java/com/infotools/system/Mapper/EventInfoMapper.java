package com.infotools.system.Mapper;

import com.infotools.system.Entity.EventData;
import com.infotools.system.Entity.EventInfo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EventInfoMapper {
    @Select("SELECT event_id,event_title,event_details,event_address,date_time,dead_num,cure_num,confirmed_num,event_abstract FROM event_info")
    List<EventInfo> findAllEventInfo();
    @Insert("\n"+
            "insert into event_info(event_id,event_title,event_details,event_address,date_time,dead_num,cure_num,confirmed_num,event_abstract) \n" +
            "values(#{event_id},#{event_title},#{event_details},#{event_address},#{date_time},#{dead_num},#{cure_num},#{confirmed_num},#{event_abstract})")
    Integer insertEventInfo(EventInfo event);
    @Select("SELECT * FROM event_info where event_id=#{event_id}")
    EventInfo findByEventID(Integer event_id);
    @Update("update event_info set event_id=#{event_id},event_title=#{event_title},event_details=#{event_details},event_address=#{event_address},date_time=#{date_time},dead_num=#{dead_num},cure_num=#{cure_num},confirmed_num=#{confirmed_num},event_abstract=#{event_abstract} where event_id=#{event_id}")
    Integer updateByEventID(EventInfo eventdata);
    @Delete("delete  from event_info where event_id=#{event_id}")
    Integer deleteByEventID(Integer event_id);
    @Select("select * from event_info  where date_time like '%${date_time}%'")
    List<EventInfo> findEventInfoByevent_title(String date_time);

    @Select("SELECT * FROM event_info where event_id=#{event_id}")
    EventInfo findByEventID1(Integer event_id);
    @Update("update event_info set event_id=#{event_id},event_title=#{event_title},event_details=#{event_details},event_address=#{event_address},date_time=#{date_time},dead_num=#{dead_num},cure_num=#{cure_num},confirmed_num=#{confirmed_num},event_abstract=#{event_abstract} where event_id=#{event_id}")
    Integer updateByEventID1(EventInfo eventdata1);


    //@Select("select * from event_info where event_id=#{event_info}")
    // EventInfo find
}