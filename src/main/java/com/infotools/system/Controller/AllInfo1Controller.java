package com.infotools.system.Controller;

import com.infotools.system.Entity.*;

import com.infotools.system.Service.AllInfo1Service;

import com.infotools.system.Service.EventData1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("xinguan")
public class AllInfo1Controller {
    @Autowired
    private AllInfo1Service allInfo1Service;
    @Autowired
    private com.infotools.system.Service.EventInfo1Service EventInfo1Service;
    @Autowired
    private com.infotools.system.Service.EventData1Service EventData1Service;

    @GetMapping("/zhuanti")
    public String indexPage(Model model, HttpSession session) {
        List<AllInfo1> lists = allInfo1Service.findAllInfo1();
        model.addAttribute("allinfo1", lists);
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
        if (userInfo != null) {
            model.addAttribute("userLoginUserName", userInfo.getUser_name());
        }
        //List<EventInfo1> list = EventInfo1Service.findAllEvent1();
        //model.addAttribute("eventinfo1", list);

        //List<EventData1> list1= EventData1Service.findAllEvent2();
        // model.addAttribute("eventdata1",list1);
        return "xinguan-details";
    }

    @GetMapping("/zhuanti1")
    public String index1Page(Model model) {
        List<EventData1> list1 = EventData1Service.findAllEvent2();
        model.addAttribute("eventdata1", list1);

        List<EventData1> list11 = EventData1Service.findAllEvent22();
        model.addAttribute("eventdata11", list11);

        List<EventData1> list111 = EventData1Service.findAllEvent222();
        model.addAttribute("eventdata111", list111);
        return "details";
    }

    @RequestMapping("/timeline")   //Get/Post请求都可以接受
    public String indexPage(@RequestParam(value = "date_time", defaultValue = "") String date_time,
                            Model model, HttpSession session) {
//新冠时间轴页面获取登录信息
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
        if (userInfo != null) {
            model.addAttribute("userLoginUserName", userInfo.getUser_name());
        }
        date_time = date_time.trim();

        List<EventInfo1> lists = null;
        if (date_time == null) {
            lists = EventInfo1Service.findAllEvent1();
            System.out.println("222=" + lists.size());
        } else {
            lists = EventInfo1Service.findEventInfo1Bydate_time(date_time);
            System.out.println("333=" + lists.size());
        }
        model.addAttribute("eventinfo2", lists);
        model.addAttribute("EventID", date_time);
        return "timeline";
    }
}