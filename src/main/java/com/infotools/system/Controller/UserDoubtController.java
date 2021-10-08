package com.infotools.system.Controller;

import com.github.pagehelper.PageInfo;
import com.infotools.system.Entity.DoctorInfo;
import com.infotools.system.Entity.UserDoubt;
import com.infotools.system.Entity.UserInfo;
import com.infotools.system.Mapper.UserDoubtMapper;
import com.infotools.system.Service.UserDoubtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("doubt")
public class UserDoubtController {
    @Autowired
    private UserDoubtService userDoubtService;

    @GetMapping("/doubt-list")
    public String doubtListPage(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                Model model) {
        PageInfo<UserDoubt> listInfo = null;
//后端用户提问分页
        listInfo = userDoubtService.findAllUserDoubt(pageIndex, pageSize);
//        System.out.println("listInfo size ==> " + listInfo.getSize());
        model.addAttribute("userDoubt", listInfo);

        return "user-doubt-list";

    }

    @RequestMapping("/doubt-page")
    public String doubtPage(HttpSession session, Model model, UserDoubt userDoubt) {
        //添加model到menu，显示退出登录按钮
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
        if (userInfo != null) {
            model.addAttribute("userLoginUserName", userInfo.getUser_name());
        }

//        List <UserDoubt> lists;
//        lists = userDoubtService .findAllUserDoubt();
//        model.addAttribute("userDoubt",lists);
        userDoubtService.insertUserDoubt(userDoubt);
        return "redirect:/doubt/user-doubt";
    }

    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable("id") Integer mess_id, Model model) {
        UserDoubt userDoubtList = userDoubtService.findUserDoubtById(mess_id);
        model.addAttribute("userDoubt", userDoubtList);
        return "user-doubt-update";
    }

    @PostMapping("/update")
    public String updatePage(UserDoubt userDoubt) {
        //messID = 93  userDoubt.getMess_id()
        UserDoubt userDoubtFromDb = userDoubtService.findUserDoubtById(userDoubt.getMess_id());
        userDoubtFromDb.setAdmin_reply(new Date());
        userDoubtFromDb.setMess_details(userDoubt.getMess_details());
        userDoubtService.updateUserDoubtById(userDoubtFromDb);
        return "redirect:/doubt/doubt-list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserDoubt(@PathVariable("id") Integer mess_id) {
        userDoubtService.deleteUserDoubtByID(mess_id);
        return "redirect:/doubt/doubt-list";
    }
}
