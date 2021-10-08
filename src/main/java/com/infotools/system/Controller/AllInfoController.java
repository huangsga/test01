package com.infotools.system.Controller;



import com.infotools.system.Entity.AllInfo;
import com.infotools.system.Service.AllInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("stu")
public class AllInfoController {
    @Autowired
    private AllInfoService allInfoService;
    @GetMapping("/we" )
    public String BlankPage(Model moedl){
        List<AllInfo> lists = allInfoService.findAllAll();
        moedl.addAttribute("Allinfo",lists);
        return "AIindex";
    }
    @GetMapping("/d")
    public  String addPage() {
        return "AIadd";
    }
    @PostMapping("d")
    public String addPage(AllInfo all){
        allInfoService.insertAllInfo(all);
        return "redirect:/stu/we";
    }
    @GetMapping("/de/{id}")
    public String deleteUserInfo(@PathVariable("id") Integer sys_id){
        allInfoService.deleteAllByID(sys_id);
        return "redirect:/stu/we";
    }
   @GetMapping("/up/{id}")
    public String update(@PathVariable("id") Integer sys_id,Model model){
        AllInfo all = allInfoService.findAllByAllId(sys_id);
        List<AllInfo> allInfos = allInfoService.findAllAll();
        model.addAttribute("ll", allInfos);
        model.addAttribute("all",all);
        return "AIupdate";
   }
    @PostMapping("/up")
    public String update(AllInfo allInfo){
        allInfoService.updateByAllId(allInfo);
        return "redirect:/stu/we";
    }
    @RequestMapping("/we")   //Get/Post请求都可以接受
    public String indexPage(@RequestParam(value = "name",defaultValue = "") String name, Model model){
        List<AllInfo> lists;
        if(name.isEmpty()){
            lists= allInfoService.findAllAll();
        } else {
            lists= allInfoService.findAllInfoByAllName(name);
        }
        model.addAttribute("Allinfo",lists);
        List<AllInfo> allInfos = allInfoService.findAllAll();
        model.addAttribute("cls", allInfos);
        model.addAttribute("name",name);
        return "AIindex"; //index.html
    }

}