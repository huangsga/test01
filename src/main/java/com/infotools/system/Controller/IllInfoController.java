package com.infotools.system.Controller;


import com.github.pagehelper.PageInfo;
import com.infotools.system.Entity.IllInfo;
import com.infotools.system.Entity.UserInfo;
import com.infotools.system.Service.IllInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("stu")
public class IllInfoController {
    @Autowired
    private IllInfoService illInfoService;
    @GetMapping("add")
    public  String addPage() {
        return "IIadd";
    }
    @PostMapping("add")
    public String addPage(IllInfo ill){
        illInfoService.insertIllInfo(ill);
        return "redirect:/stu/web";
    }
    @GetMapping("/delete/{id}")
    public String deleteUserInfo(@PathVariable("id") Integer ill_id){
        illInfoService.deleteIllByID(ill_id);
        return "redirect:/stu/web";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer ill_id,Model model){
        IllInfo ill = illInfoService.findIllByIllId(ill_id);
        model.addAttribute("ill",ill);
        return "IIupdate";
    }
    @PostMapping("/update")
    public String update(IllInfo illInfo){
        illInfoService.updateByIllId(illInfo);
        return "redirect:/stu/web";
    }
    //后端详情
    @GetMapping("/xq/{id}")
    public String xq(@PathVariable("id") Integer ill_id,Model model){
        IllInfo ill = illInfoService.findIllByIllId(ill_id);
        model.addAttribute("ill",ill);
        return "IIxq";
    }
    @PostMapping("/xq")
    public String xq(IllInfo illInfo){
        illInfoService.updateByIllId(illInfo);
        return "redirect:/stu/web";
    }
    @RequestMapping("/web")   //Get/Post请求都可以接受
    public String indexPage(@RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,
                            @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
            @RequestParam(value = "ill_name",defaultValue = "") String ill_name, Model model){
        PageInfo<IllInfo> listInfo=null;
        if(ill_name.isEmpty()){
            listInfo= illInfoService.findAllIll(pageIndex, pageSize);
        } else {
            listInfo= illInfoService.findIllInfoByIllName(pageIndex,pageSize,ill_name);
        }
        /*model.addAttribute("Illinfo",lists);*/
        /*List<IllInfo> illInfos = illInfoService.findAllIll();*/
        model.addAttribute("stus", listInfo);
        model.addAttribute("ill_name",ill_name);
        return "IIindex"; //index.html
    }

    @RequestMapping("/sc")   //Get/Post请求都可以接受
    public String SC(@RequestParam(value = "cname",defaultValue = "1") Integer ill_id,
                     String cstage, Model model, HttpSession session,
                     String cage){
        //添加model到menu，显示退出登录按钮
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
        if (userInfo != null) {
            model.addAttribute("userLoginUserName",userInfo.getUser_name());
        }

       List<IllInfo> listsinfo = illInfoService.findAllIllcstage(cstage);
        List<IllInfo> listsc = illInfoService.findAllIllcage(cage);
        List<IllInfo> lists;
        if(ill_id == null){
            lists=illInfoService.findAllIllcstage(cstage);
        }
        else{
            lists=illInfoService.findAllIllcid(ill_id);
        }
        model.addAttribute("cage",listsc);

        model.addAttribute("ill_id",ill_id);
        model.addAttribute("cname",lists);

        model.addAttribute("cstage", listsinfo);
        return "stage-children";
    }

    @RequestMapping("/st")   //
    public String ST(@RequestParam(value = "tname",defaultValue = "10") Integer ill_id,
                     String tstage,Model model,HttpSession session,
                     String tage){
        //添加model到menu，显示退出登录按钮
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
        if (userInfo != null) {
            model.addAttribute("userLoginUserName",userInfo.getUser_name());
        }

        List<IllInfo> listtinfo = illInfoService.findAllIlltstage(tstage);
        List<IllInfo> listst = illInfoService.findAllIlltage(tage);
        List<IllInfo> lists;
        if(ill_id == null){
            lists=illInfoService.findAllIlltstage(tstage);
        }
        else{
            lists=illInfoService.findAllIlltid(ill_id);
        }
        model.addAttribute("tage",listst);

        model.addAttribute("ill_id",ill_id);
        model.addAttribute("tname",lists);

        model.addAttribute("tstage", listtinfo);
        return "stage-teenager";
    }

    @RequestMapping("/sm")   //Get/Post请求都可以接受
    public String SM(@RequestParam(value = "mname",defaultValue = "26") Integer ill_id,
                     String mstage,Model model,HttpSession session,
                     String mage){
        //添加model到menu，显示退出登录按钮
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
        if (userInfo != null) {
            model.addAttribute("userLoginUserName",userInfo.getUser_name());
        }

        List<IllInfo> listminfo = illInfoService.findAllIllmstage(mstage);
        List<IllInfo> listsm = illInfoService.findAllIllmage(mage);
        List<IllInfo> lists;
        if(ill_id == null){
            lists=illInfoService.findAllIllmstage(mstage);
        }
        else{
            lists=illInfoService.findAllIllmid(ill_id);
        }
        model.addAttribute("mage",listsm);

        model.addAttribute("ill_id",ill_id);
        model.addAttribute("mname",lists);

        model.addAttribute("mstage", listminfo);
        return "stage-middle";
    }

    @RequestMapping("/so")   //Get/Post请求都可以接受
    public String SO(@RequestParam(value = "oname",defaultValue = "31") Integer ill_id,
                     String ostage,Model model,HttpSession session,
                     String oage){
        //添加model到menu，显示退出登录按钮
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
        if (userInfo != null) {
            model.addAttribute("userLoginUserName",userInfo.getUser_name());
        }

        List<IllInfo> listoinfo = illInfoService.findAllIllostage(ostage);
        List<IllInfo> listso = illInfoService.findAllIlloage(oage);
        List<IllInfo> lists;
        if(ill_id == null){
            lists=illInfoService.findAllIllostage(ostage);
        }
        else{
            lists=illInfoService.findAllIlloid(ill_id);
        }
        model.addAttribute("oage",listso);
        
        model.addAttribute("ill_id",ill_id);
        model.addAttribute("oname",lists);

        model.addAttribute("ostage", listoinfo);
        return "stage-old";
    }
}