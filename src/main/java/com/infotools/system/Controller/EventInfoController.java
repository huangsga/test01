package com.infotools.system.Controller;

import com.github.pagehelper.PageInfo;
import com.infotools.system.Entity.EventData;
import com.infotools.system.Entity.EventInfo;
import com.infotools.system.Mapper.EventInfoMapper;
import com.infotools.system.Service.EventDataService;
import com.infotools.system.Service.EventInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("event1")
public class EventInfoController {
    @Autowired
    private EventInfoService EventInfoService;

    @GetMapping("/EventInfoadd")
    public String indexadd(){
        return "EventInfoadd";
    }

    @PostMapping("/EventInfoadd")
    public String addList(EventInfo event) {
        EventInfoService.insertEventInfo(event);
        return "redirect:/event1/abc1";
    }

    @GetMapping("/EventInfoupdate/{id}")
    public String updateEventData(@PathVariable("id") Integer event_id,Model model){
        EventInfo event=EventInfoService.findByEventID(event_id);
        List<EventInfo> even=EventInfoService.findAllEvent();
        model.addAttribute("event",event);
        model.addAttribute("even",even);
        return "EventInfoupdate";
    }

    @PostMapping("/EventInfoupdate")
    public String updateEventData(EventInfo eventinfo){
        EventInfoService.updateByEventID(eventinfo);
        return "redirect:/event1/abc1";

    }
    @RequestMapping("/abc1")   //Get/Post请求都可以接受
    public String indexPage(@RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,
                            @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
                            @RequestParam(value = "date_time",defaultValue = "") String date_time,
                            Model model){
        //List<EventInfo> lists;
        PageInfo<EventInfo> listInfo=null;
        if(date_time==null){
            listInfo=EventInfoService.findAllEvent(pageIndex,pageSize);
            //lists=EventInfoService.findAllEvent();
        } else {
            listInfo=EventInfoService.findEventInfoByevent_title(pageIndex,pageSize,date_time);
        }
        // List<EventInfo> date_time=EventInfoService.findAllEvent();
        model.addAttribute("eventinfo",listInfo);
        model.addAttribute("EventID",date_time);
        return "EventInfolist";
    }

    @GetMapping("/EventInfodelete/{id}")
    public String indexDelete(@PathVariable("id") Integer EventID){
        EventInfoService.deleteByEventID(EventID);
        return "redirect:/event1/abc1";
    }

    @GetMapping("/EIdetails/{id}")
    public String detailsEventData(@PathVariable("id") Integer event_id,Model model){
        EventInfo event1=EventInfoService.findByEventID1(event_id);
        List<EventInfo> even=EventInfoService.findAllEvent();
        model.addAttribute("event",event1);
        model.addAttribute("even",even);
        return "EIdetails";
    }

    @PostMapping("/EIdetails")
    public String detailsEventData(EventInfo eventinfo1){
        EventInfoService.updateByEventID(eventinfo1);
        return "redirect:/event1/abc1";

    }
}