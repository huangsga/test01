package com.infotools.system.Controller;

import com.github.pagehelper.PageInfo;
import com.infotools.system.Entity.DoctorInfo;
import com.infotools.system.Entity.UserDoubt;
import com.infotools.system.Entity.UserInfo;
import com.infotools.system.Service.DoctorInfoService;
import com.infotools.system.Service.UserDoubtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/doc")
public class DoctorInfoController {
    @Autowired
    private DoctorInfoService doctorInfoService;

    @Autowired
    private UserDoubtService userDoubtService;

    @GetMapping("/add")
    public String addDoctor() {
        return "DIadd";
    }

    @PostMapping("/add")
    public String addDoctor(DoctorInfo doctorInfo) {
        doctorInfoService.insertDoctorInfo(doctorInfo);
        return "redirect:/doc/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteDoctorInfo(@PathVariable("id") Integer doc_id) {
        doctorInfoService.deleteDoctorByID(doc_id);
        return "redirect:/doc/list";
    }

    @GetMapping("/update/{id}")
    public String updateDocInfo(@PathVariable("id") Integer doc_id, Model model) {
        DoctorInfo doctorInfos = doctorInfoService.findDoctorByDocId(doc_id);
        model.addAttribute("docInfo", doctorInfos);
        return "DIupdate";
    }

    @PostMapping("/update")
    public String updateUserInfo(DoctorInfo doctorInfo) {
        doctorInfoService.updateByDocId(doctorInfo);
        return "redirect:/doc/list";
    }

    @GetMapping("/details/{id}")
    public String docInfoDetails(@PathVariable("id") Integer doc_id, Model model) {
        DoctorInfo doctorInfos = doctorInfoService.findDoctorByDocId(doc_id);
        model.addAttribute("docInfo", doctorInfos);
        return "DIdetails";
    }

    @PostMapping("/details")
    public String docInfoDetails(DoctorInfo doctorInfo) {
        doctorInfoService.updateByDocId(doctorInfo);
        return "redirect:/doc/list";
    }

    @RequestMapping("/list")   //Get/Post请求都可以接受
    public String doctorListPage(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                                 @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                 @RequestParam(value = "doc_category", defaultValue = "") String doc_category,
                                 Model model) {
        PageInfo<DoctorInfo> listInfo = null;
        if (doc_category.isEmpty()) {
            listInfo = doctorInfoService.findAllDocInfo(pageIndex,pageSize);
        } else {
            listInfo = doctorInfoService.findDoctorByDocCategory(pageIndex,pageSize,doc_category);
        }
        model.addAttribute("docInfo", listInfo);
        model.addAttribute("DocCategory", doc_category);
        return "DIlist"; //index.html
    }

    @GetMapping("/index")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/doctor")
    public String doctorPage(HttpSession session, Model model) {
        //添加model到menu，显示退出登录按钮
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
        if (userInfo != null) {
            model.addAttribute("userLoginUserName", userInfo.getUser_name());
        }

//        List<DoctorInfo> lists = doctorInfoService.findAllDocInfo(pageIndex,pageSize);
//        model.addAttribute("docInfo", lists);

        List<DoctorInfo> listsOne = doctorInfoService.findDocByCategoryOne();
        List<DoctorInfo> listsTwo = doctorInfoService.findDocByCategoryTwo();
        List<DoctorInfo> listsThree = doctorInfoService.findDocByCategoryThree();
        List<DoctorInfo> listsFour = doctorInfoService.findDocByCategoryFour();
        model.addAttribute("docInfoOne", listsOne);
        model.addAttribute("docInfoTwo", listsTwo);
        model.addAttribute("docInfoThree", listsThree);
        model.addAttribute("docInfoFour", listsFour);
        return "doctor";

    }

    @GetMapping("/passDoc_name/{id}")
    public String passDoc_name(@PathVariable("id") Integer doc_id,
                               Model model, UserDoubt userDoubt, HttpSession session) {
        //添加model到menu，显示退出登录按钮
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
        if (userInfo != null) {
            model.addAttribute("userLoginUserName", userInfo.getUser_name());
        }
        //这是找到的医生的信息
        DoctorInfo doctorByDocId = doctorInfoService.findDoctorByDocId(doc_id);
//        System.out.println("id ==>" + doc_id);
//        System.out.println("doc_name = 1 ==> " + doctorByDocId.getDoc_name());
//userDoubtService.insertUserDoubt(userDoubt);
//映射路径有问题
        List<UserDoubt> lists;
        lists = userDoubtService.findAllDoubt();
        model.addAttribute("userDoubt", lists);
        model.addAttribute("passDocName", doctorByDocId.getDoc_name());
        session.setAttribute("doc_name", doctorByDocId.getDoc_name());
        return "user-doubt";

    }

    /**
     * 这是重医生页面跳转过来的，所以可以传递医生的信息，但是你用户的信息应该是seesion里面，所以我们应该通过session来取用户信息。
     * 获取到用户的信息之后，（这里需要注意的是，在用户登录的时候就应该把整个用户对象加入session里面，而不是单一的名字）
     * 然后像这个方法一样，我们就可以通过@RequestParam("user_name")的方式获取到前端的值，但是这里有一点医生信息们不能这样获取
     * 你应该用model.get方法获取。
     * 然后你就可以new 一个userDocbut对象，然后把这些获取到的值set进去
     * 然后调用service 的 insert方法，传入这个userdoubt对象。
     * 完成
     **/
    @PostMapping("/passDoc_name")
    public String passDoc_name(@RequestParam("user_doubt") String user_doubt,
                               Model model, HttpSession session) {
        UserDoubt userDoubt = new UserDoubt();//创建一个新的，空对象，来存储数据的。

        UserInfo userinfo = (UserInfo) session.getAttribute("userinfo");
        String userEmail = userinfo.getUser_email();
        String userName = userinfo.getUser_name();
        String docName = (String) session.getAttribute("doc_name");

        userDoubt.setUser_name(userName);
        userDoubt.setDoc_name(docName);
        userDoubt.setUser_email(userEmail);
        userDoubt.setUser_doubt(user_doubt);

        Integer integer = userDoubtService.insertUserDoubt(userDoubt);
        return "user-doubt";

    }
}
