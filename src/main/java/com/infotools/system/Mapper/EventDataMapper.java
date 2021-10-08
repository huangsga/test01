package com.infotools.system.Mapper;

import com.infotools.system.Entity.EventData;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EventDataMapper {
    @Select("SELECT event_id,event_title,event_abstract,event_details,event_img_url,click_num,share_num,link,pub_time FROM event_data")
    List<EventData> findAllEventData();
    @Insert("\n"+
            "insert into event_data(event_id,event_title,event_abstract,event_details,click_num,share_num,link,pub_time) \n" +
            "values(#{event_id},#{event_title},#{event_abstract},#{event_details},#{click_num},#{share_num},#{link},#{pub_time})")
    Integer insertEventData(EventData event);
    @Delete("delete  from event_data where event_id=#{event_id}")
    Integer deleteByEventID(Integer event_id);

    @Select("SELECT * FROM event_data where event_id=#{event_id}")
    EventData findByEventID(Integer event_id);
    @Update("update event_data set event_id=#{event_id},event_title=#{event_title},event_abstract=#{event_abstract},event_details=#{event_details},event_img_url=#{event_img_url},click_num=#{click_num},share_num=#{share_num},link=#{link},pub_time=#{pub_time} where event_id=#{event_id}")
    Integer updateByEventID(EventData eventdata);
    @Select("select * from event_data  where pub_time like '%${pub_time}%'")
    List<EventData> findEventDataByevent_title(String pub_time);

    @Select("SELECT * FROM event_data where event_id=#{event_id}")
    EventData findByEventID1(Integer event_id);
    @Update("update event_data set event_id=#{event_id},event_title=#{event_title},event_abstract=#{event_abstract},event_details=#{event_details},event_img_url=#{event_img_url},click_num=#{click_num},share_num=#{share_num},link=#{link},pub_time=#{pub_time} where event_id=#{event_id}")
    Integer updateByEventID1(EventData eventdata1);
}
