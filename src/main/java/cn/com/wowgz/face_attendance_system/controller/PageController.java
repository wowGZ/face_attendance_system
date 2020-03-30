package cn.com.wowgz.face_attendance_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: WowGz
 * Date: 2020/2/29/029
 * FileName: PageController
 * Description: controller to manage pages forward
 */
@Controller
@RequestMapping("/page")
public class PageController {
    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/toLoginError")
    public String toLoginError(Model model){
        model.addAttribute("error","用户名或密码错误！");
        return "login";
    }

    @RequestMapping("toIndex")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("/welcome-1")
    public String toWelcome() {
        return "welcome";
    }

    @RequestMapping("/toClassInfoTable")
    public String toTable(Model model){

//        return "testTable";
        return "classInfoTable";
    }
}
