package com.infotools.system.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.infotools.system.Entity.EventInfo;
import com.infotools.system.Mapper.EventDataMapper;
import com.infotools.system.Mapper.EventInfoMapper;
import com.infotools.system.Service.EventInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class EventInfoServiceImpl implements EventInfoService {
    @Autowired
    private EventInfoMapper EventInfoMapper;
    // @Override
    //public List<EventInfo> findAllEvent() {
    //   return EventInfoMapper.findAllEventInfo();
    //}

    @Override
    public List<EventInfo> findAllEvent() {
        return EventInfoMapper.findAllEventInfo();
    }

    @Override
    public PageInfo<EventInfo> findAllEvent(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<EventInfo> lists=EventInfoMapper.findAllEventInfo();
        PageInfo<EventInfo> info=new PageInfo<EventInfo>(lists);
        return info;
    }

    @Override
    public PageInfo<EventInfo> findEventInfoByevent_title(Integer pageIndex, Integer pageSize, String date_time) {
        PageHelper.startPage(pageIndex,pageSize);
        List<EventInfo> lists=EventInfoMapper.findEventInfoByevent_title(date_time);
        PageInfo<EventInfo> info=new PageInfo<EventInfo>(lists);
        return info;
    }

    //@Override
    //public PageInfo<EventInfo> findAllEvent(Integer pageIndex,Integer pageSize) {
    //   PageHelper.startPage(1,5);
    //    List<EventInfo> lists=EventInfoMapper.findAllEventInfo();
    //    PageInfo<EventInfo> a=new PageInfo<EventInfo>(lists);
    //    return a;

    // }

    @Override
    public Integer insertEventInfo(EventInfo event) {
        return EventInfoMapper.insertEventInfo(event);
    }

    @Override
    public EventInfo findByEventID(Integer event_id) {
        return EventInfoMapper.findByEventID(event_id);
    }

    @Override
    public Integer updateByEventID(EventInfo eventInfo) {
        return EventInfoMapper.updateByEventID(eventInfo);
    }

    @Override
    public Integer deleteByEventID(Integer event_id) {
        return EventInfoMapper.deleteByEventID(event_id);
    }

    @Override
    public List<EventInfo> findEventInfoByevent_id(String date_time) {
        return EventInfoMapper.findEventInfoByevent_title(date_time);
    }

    @Override
    public EventInfo findByEventID1(Integer event_id) {
        return EventInfoMapper.findByEventID1(event_id);
    }

    @Override
    public Integer updateByEventID1(EventInfo eventInfo1) {
        return EventInfoMapper.updateByEventID1(eventInfo1);
    }

}