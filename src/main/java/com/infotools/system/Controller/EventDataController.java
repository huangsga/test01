package com.infotools.system.Controller;

import com.infotools.system.Entity.EventData;
import com.infotools.system.Entity.ViewEventData;
import com.infotools.system.Service.EventDataService;
import com.infotools.system.Utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("event")
public class EventDataController {
    @Autowired
    private EventDataService EventDataService;
    @GetMapping("/EDadd")
    public String indexadd(){
        return "EDadd";
    }

    @PostMapping("/EDadd")
    public String addList(EventData event) {
//        String fileName= file.getOriginalFilename();
//        String filePath= FileUtil.getUpLoadFilePath();
//        fileName=System.currentTimeMillis()+fileName;
//
//        try {
//            FileUtil.uploadFile(file.getBytes(),filePath,fileName);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        event.setEvent_img_url(fileName);
        EventDataService.insertEventData(event);

        return "redirect:/event/abc";
    }

    @GetMapping("/delete/{id}")
    public String indexDelete(@PathVariable("id") Integer EventID){
        EventDataService.deleteByEventID(EventID);
        return "redirect:/event/abc";
    }

    @GetMapping("/EDupdate/{id}")
    public String updateEventData(@PathVariable("id") Integer event_id,Model model){
        EventData event=EventDataService.findByEventID(event_id);
        List<EventData> even=EventDataService.findAllEvent();
        model.addAttribute("event",event);
        model.addAttribute("even",even);
        return "EDupdate";
    }

    @PostMapping("/EDupdate")
    public String updateEventData(EventData eventdata){
        EventDataService.updateByEventID(eventdata);
        return "redirect:/event/abc";
    }

    @RequestMapping("/abc")   //Get/Post请求都可以接受
    public String indexPage(@RequestParam(value = "pub_time",defaultValue = "") String  pub_time, Model model){
        List<EventData> lists=null;
        if(pub_time==null){
            lists=EventDataService.findAllEvent();
        } else {
            lists=EventDataService.findEventDataByevent_id(pub_time);
        }
        model.addAttribute("eventdata",lists);
        model.addAttribute("EventID",pub_time);
        return "EDlist"; //EDlist.html
    }

    @GetMapping("/EDdetails/{id}")
    public String detailsEventData(@PathVariable("id") Integer event_id,Model model){
        EventData event1=EventDataService.findByEventID1(event_id);
        List<EventData> even=EventDataService.findAllEvent();
        model.addAttribute("event",event1);
        model.addAttribute("even",even);
        return "EDdetails";
    }

    @PostMapping("/EDdetails")
    public String detailsEventData(EventData eventdata1){
        EventDataService.updateByEventID1(eventdata1);
        return "redirect:/event/abc";
    }
}