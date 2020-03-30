package cn.com.wowgz.face_attendance_system.controller;

import cn.com.wowgz.face_attendance_system.service.TeacherService;
import cn.com.wowgz.face_attendance_system.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Author: WowGz
 * Date: 2020/2/29/029
 * FileName: LoginController
 * Description: controller to login for the system
 */
@Controller
public class LoginController {

    @Autowired
    private TeacherService teacherService;


    /**
     * 后台登录验证
     *
     * @param userName 用户名，即登录教师的工号
     * @param password 密码
     * @return 返回后台管理的主页@PathVariable("userName") @PathVariable("password")
     */
    @RequestMapping("/login/{userName}/{password}")
    public String login(@PathVariable("userName") String userName,
                        @PathVariable("password") String password, HttpSession session) {
        if (!teacherService.teacherLogin(userName, password)) {
            return "redirect:/page/toLoginError";
        }
        session.setAttribute("teacher", teacherService.selectTeacherByNumber(userName));
        session.setAttribute("teacherNumber", teacherService.selectTeacherByNumber(userName).getTeacherNumber());
        session.setAttribute("teacherName",teacherService.selectTeacherByNumber(userName).getTeacherName());
        return "redirect:/page/toIndex";
    }

}
