package com.infotools.system.Controller;

import com.github.pagehelper.PageInfo;
import com.infotools.system.Entity.SysLog;
import com.infotools.system.Entity.UserInfo;
import com.infotools.system.Service.UserInfoService;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/add")
    public String addUser(HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
        return "register";
    }

    @PostMapping("/add")
    public String addUser(UserInfo userInfo) {
        userInfo.setPower(2);
        userInfoService.insertUserInfo(userInfo);
        return "redirect:/user/login";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserInfo(@PathVariable("id") Integer user_id) {
        userInfoService.deleteUserByID(user_id);
        return "redirect:/user/list";
    }

    @GetMapping("/update/{id}")
    public String updateUserInfo(@PathVariable("id") Integer user_id, Model model, HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
        UserInfo UserInfoList = userInfoService.findUserByUserId(user_id);
        model.addAttribute("userInfo", UserInfoList);
        return "UIupdate";
    }

    @PostMapping("/update")
    public String updateUserInfo(UserInfo userInfo) {
        userInfoService.updateByUserId(userInfo);
        return "redirect:/user/list";
    }

    @RequestMapping("/list")   //Get/Post?????????????????????
    public String userListPage(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                               @RequestParam(value = "user_name", defaultValue = "") String user_name,
                               Model model, HttpSession session) {
        //??????session???????????????????????????
        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
        //??????????????????????????????????????????????????????
        if (userInfo == null) {
            return "error-404";
        }
        PageInfo<UserInfo> listInfo = null;
        if (user_name.isEmpty()) {
            listInfo = userInfoService.findAllUserInfo(pageIndex, pageSize);
        } else {
            listInfo = userInfoService.findUserInfoByUserName(pageIndex, pageSize, user_name);
        }
        model.addAttribute("userInfo", listInfo);
        model.addAttribute("UserName", user_name);
        return "UIlist"; //index.html
    }

    @GetMapping("/login")
    private String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    private String loginInfo(@RequestParam("user_name") String UserName,
                             @RequestParam("password") String Password,
                             @RequestParam("power") Integer power,
                             HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model) {

        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.equals("0:0:0:0:0:0:0:1")) {
            ip = "127.0.0.1";
        }
        System.out.println("IP?????????" + ip);
        String agentStr = request.getHeader("user-agent");
        System.out.println(agentStr);
        UserAgent agent = UserAgent.parseUserAgentString(agentStr);
        //?????????
        Browser browser = agent.getBrowser();
        System.out.println("?????????" + browser.getBrowserType() +
                "\n?????????" + browser.getName() +
                "\n?????????" + browser.getManufacturer() +
                "\n???????????????" + browser.getGroup() +
                "\n?????????" + browser.getRenderingEngine());

        //???????????????
        Version version = agent.getBrowserVersion();
        System.out.println("=========================");
        System.out.println("????????????" + version.getMajorVersion() +
                "\n????????????" + version.getMajorVersion() +
                "\n???????????????" + version.getVersion());

        //????????????
        System.out.println("==========================");
        OperatingSystem os = agent.getOperatingSystem();
        System.out.println("?????????" + os.getName() +
                "\n???????????????" + os.getDeviceType() +
                "\n???????????????" + os.getGroup() +
                "\n???????????????" + os.getManufacturer());

        SysLog log = new SysLog();

        UserInfo userInfo = userInfoService.UserLogin(UserName, Password, power);
        if (userInfo != null) {
            log.setUserID(userInfo.getUser_id());
            log.setIP_address(ip);
            log.setOS(os.getName());
            log.setIE(browser.getName());
            log.setLog_content("????????????");
            log.setRemark("???");
            log.setUser_type(power);
            // ??????????????????
            Integer integer = userInfoService.InsertSysLog(log);
            //????????????session??????
            session.setAttribute("userinfo", userInfo);
            //??????????????????????????????????????????????????????
            if (userInfo.getPower() == 1) {
                return "redirect:/user/list";
            } else {
                return "redirect:/user/index";
            }
        } else {
            return "redirect:/user/login";
        }
    }
    @GetMapping("/sysLog")
    public String sysLogPage(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                             Model model){
        List<SysLog> lists=null;
        PageInfo<SysLog> listInfo=null;
        listInfo = userInfoService.findAllSysLog(pageIndex,pageSize);
        model.addAttribute("sysLog",listInfo);
        return "sysLog";
    }

    @GetMapping("/index")
    public String testPage(HttpSession session, Model model) {

        UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
        if (userInfo != null) {
            model.addAttribute("userLoginUserName", userInfo.getUser_name());
        }
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("userinfo");
        return "redirect:/user/login";
    }

    @GetMapping("/userLogout")
    public String userLogout(HttpSession session, Model model) {
        session.removeAttribute("userinfo");
        model.addAttribute("userLoginUserName", null);
        return "redirect:/user/index";
    }

    @GetMapping("/reset-password")
    public String resetPassword() {
        return "reset-password";
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam("user_name") String user_name,
                                @RequestParam("user_email") String checkEmail,
                                @RequestParam("password") String password) {
//        ???????????????email???????????????checkemail??????????????????
        UserInfo userByEmail = null;
        if (checkEmail != null && user_name != null && password != null) {
            //???????????????????????????????????????????????????userinfo???????????????
            userByEmail = userInfoService.findUserByEmail(checkEmail, user_name);
            //???????????????????????????????????????????????????????????????????????????email????????????????????????email?????????
            if (userByEmail == null) {
                return "error-404";
            }
        }
        //??????????????????????????????????????????,??????????????????????????????
        userByEmail.setPassword(password);
        userInfoService.updateByUserId(userByEmail);
        return "login";
    }

    @GetMapping("/us")
    public  String usePage(Integer ud,String uc,Integer us, Model model) {
        List<UserInfo> listsu = userInfoService.findAllUserud(ud);
        List<UserInfo> listsd = userInfoService.findAllUseruc(uc);
        List<UserInfo> listus = userInfoService.findAllUserus(us);
        model.addAttribute("ud",listsu);
        model.addAttribute("uc",listsd);
        model.addAttribute("us",listus);
        return "user";
    }
}