package com.infotools.system.Controller;

import com.github.pagehelper.PageInfo;
import com.infotools.system.Entity.BodyInfo;
import com.infotools.system.Entity.DetailTime;
import com.infotools.system.Entity.UserInfo;
import com.infotools.system.Service.BodyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("body")
public class BodyInfoController {
    @Autowired
    private BodyInfoService bodyInfoService;

    @RequestMapping("/bodylist")
    public String getBodyByID(@RequestParam(value="pageIndex",defaultValue ="1") Integer pageIndex,
                              @RequestParam(value="pageSize",defaultValue ="10") Integer pageSize,
                              @RequestParam(value="bodysystem",defaultValue ="")  String bodysystem,
                               Model model){
//        List<BodyInfo> lists;
        PageInfo<BodyInfo> listInfo=null;
        if(bodysystem.isEmpty()){
            listInfo=bodyInfoService.findAllBodyInfo(pageIndex,pageSize);
        }else{
            listInfo=bodyInfoService.findBodyBySystem(pageIndex,pageSize,bodysystem);
        }
        model.addAttribute("BodyInfo",listInfo);
        model.addAttribute("bodysystem",bodysystem);
        return "BIlist";
    }

    @GetMapping("/bodyadd")
    public String addBodyInfo()
//    @RequestParam(value="pageIndex",defaultValue ="1") Integer pageIndex,
//                              @RequestParam(value="pageSize",defaultValue ="10") Integer pageSize,
//            Model model
            {
       /* PageInfo<BodyInfo> lists=bodyInfoService.findAllBodyInfo(pageIndex,pageSize);
        model.addAttribute("body",lists);*/
        return "BIadd";
    }


    @PostMapping("/bodyadd")
    public String addInfo(BodyInfo body){
        bodyInfoService.insertBody(body);
        return "redirect:/body/bodylist";
    }

    @GetMapping("/bodyupdate/{id}")
    public String updateBody(@PathVariable("id") Integer body_id, Model model){
        List<BodyInfo> body=bodyInfoService.findBodyById(body_id);
//        System.out.println("body.get(0).getBody_id() =>"+body.get(0).getBody_id());
//        List<BodyInfo> lists=bodyInfoService.findAllBodyInfo();
        model.addAttribute("BodyInfo",body.get(0));
//        model.addAttribute("body_id",lists);
        return "BIupdate";
    }

    @PostMapping("/bodyupdate")
    public String updateBody(BodyInfo body){
        bodyInfoService.updateBodyByID(body);
        return "redirect:/body/bodylist";
//        return "index";
    }

    @GetMapping("/bodydelete/{id}")
    public String delBodyInfo(@PathVariable("id") Integer body_id){
        bodyInfoService.deleteBodyByID(body_id);
        return "redirect:/body/bodylist";
    }


    @RequestMapping("/ch")   //Get/Post请求都可以接受
    public String CH(@RequestParam(value = "bodysystem",defaultValue = "") String bodysystem, String ill_name,Integer body_id,Model model, HttpSession session){
        //添加model到menu，显示退出登录按钮
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
        if (userInfo != null) {
            model.addAttribute("userLoginUserName",userInfo.getUser_name());
        }

        List<BodyInfo> zhenzhuang=bodyInfoService.findBodyInfoByyundong(bodysystem);
        model.addAttribute("ill_name",zhenzhuang);
//        System.out.println("zhenzhuang.get(0).getBody_id() =>"+zhenzhuang.get(0).getBody_id());

        List<BodyInfo> huxi=bodyInfoService.findBodyInfoByhuxi(bodysystem);
        model.addAttribute("huxi",huxi);
        List<BodyInfo> xiaohua=bodyInfoService.findBodyInfoByxiaohua(bodysystem);
        model.addAttribute("xiaohua",xiaohua);
        List<BodyInfo> shenzhi=bodyInfoService.findBodyInfoByshenzhi(bodysystem);
        model.addAttribute("shenzhi",shenzhi);
        List<BodyInfo> miniao=bodyInfoService.findBodyInfoByminiao(bodysystem);
        model.addAttribute("miniao",miniao);
        List<BodyInfo> xunhuan=bodyInfoService.findBodyInfoByxunhuan(bodysystem);
        model.addAttribute("xunhuan",xunhuan);
        List<BodyInfo> shenjing=bodyInfoService.findBodyInfoByshenjing(bodysystem);
        model.addAttribute("shenjing",shenjing);
        List<BodyInfo> neifenmi=bodyInfoService.findBodyInfoByneifenmi(bodysystem);
        model.addAttribute("neifenmi",neifenmi);
        model.addAttribute("system",bodysystem);
        model.addAttribute("body_id",body_id);
        return "body-develop"; //index.html
    }
    @GetMapping("/bodydetails/{body_id}")
    public String findbodydetails(@PathVariable("body_id") Integer body_id, Model model){

        List<BodyInfo> details=bodyInfoService.findAllInfoByillname(body_id);
        model.addAttribute("details",details.get(0));
        return "body-details";
    }
    @RequestMapping("/bodetails")
    public String findbodydetails(@RequestParam(value = "ill_name",defaultValue = "腰椎间盘突出")String ill_name,Model model){
        List<DetailTime> yaojianpan=bodyInfoService.findAllyaojianpan(ill_name);
        model.addAttribute("yaojianpan",yaojianpan);
        List<DetailTime> guanjie=bodyInfoService.findAllguanjie(ill_name);
        model.addAttribute("guanjie",guanjie);
        List<DetailTime> lanwei=bodyInfoService.findAlllanwei(ill_name);
        model.addAttribute("lanwei",lanwei);
        List<DetailTime> xiaochuan=bodyInfoService.findAllxiaochuan(ill_name);
        model.addAttribute("xiaochuan",xiaochuan);
        List<DetailTime> niaodu=bodyInfoService.findAllniaodu(ill_name);
        model.addAttribute("niaodu",niaodu);
        List<DetailTime> gongjin=bodyInfoService.findAllgongjin(ill_name);
        model.addAttribute("gongjin",gongjin);
        List<DetailTime> tangniao=bodyInfoService.findAlltangniao(ill_name);
        model.addAttribute("tangniao",tangniao);
        List<DetailTime> gaoya=bodyInfoService.findAllgaoya(ill_name);
        model.addAttribute("gaoya",gaoya);
        List<DetailTime> chidai=bodyInfoService.findAllchidai(ill_name);
        model.addAttribute("chidai",chidai);
        List<DetailTime> jieshi=bodyInfoService.findAlljieshi(ill_name);
        model.addAttribute("jieshi",jieshi);
        List<DetailTime> jiehe=bodyInfoService.findAlljiehe(ill_name);
        model.addAttribute("jiehe",jiehe);
        List<DetailTime> pangguang=bodyInfoService.findAlllpangguang(ill_name);
        model.addAttribute("pangguang",pangguang);
        List<DetailTime> ditang=bodyInfoService.findAllditang(ill_name);
        model.addAttribute("ditang",ditang);
        List<DetailTime> guanxin=bodyInfoService.findAllguanxin(ill_name);
        model.addAttribute("guanxin",guanxin);
        List<DetailTime> zuogu=bodyInfoService.findAllzuogu(ill_name);
        model.addAttribute("zuogu",zuogu);
        List<DetailTime> qianlie=bodyInfoService.findAllqianlie(ill_name);
        model.addAttribute("qianlie",qianlie);
        model.addAttribute("ill_name",ill_name);
                return "body-dtime";

    }

//    @GetMapping("details/{id}")
//    public String BIdetailsPage(@PathVariable("id")Integer Id){
//
//        return "BIdetails";
//
//    }

    @GetMapping("/details/{id}")
    public String BIdetailsPage(@PathVariable("id") Integer body_id, Model model){
        List<BodyInfo> body=bodyInfoService.findBodyById(body_id);
//        System.out.println("body.get(0).getBody_id() =>"+body.get(0).getBody_id());
//        List<BodyInfo> lists=bodyInfoService.findAllBodyInfo();
        model.addAttribute("BodyInfo",body.get(0));
//        model.addAttribute("body_id",lists);
        return "BIdetails";
    }
}
