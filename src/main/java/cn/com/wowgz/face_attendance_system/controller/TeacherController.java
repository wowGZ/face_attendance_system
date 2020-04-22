package cn.com.wowgz.face_attendance_system.controller;

import cn.com.wowgz.face_attendance_system.entitiy.TeacherInfo;
import cn.com.wowgz.face_attendance_system.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: WowGz
 * Date: 2020/4/22/022
 * FileName: TeacherController
 * Description:
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherServiceImpl teacherService;

    @RequestMapping("/updateTeacher")
    @ResponseBody
    public Map<String, Object> updateTeacher(TeacherInfo teacherInfo, HttpSession session){
        Map<String, Object> map = new HashMap<>();
        TeacherInfo teacherLogin = (TeacherInfo) session.getAttribute("teacher");
        teacherInfo.setId(teacherLogin.getId());
        int result = teacherService.updateTeacherByPrimaryKey(teacherInfo);
        if (result == 1){
            map.put("msg", "修改成功");
        } else {
            map.put("msg", "修改失败");
        }

        return map;
    }

    @RequestMapping("/updateTeacherPassword")
    @ResponseBody
    public Map<String, Object> updateTeacherPassword(String oldPassword, String newPassword, HttpSession session){
        Map<String, Object> map = new HashMap<>();
        TeacherInfo teacherLogin = (TeacherInfo) session.getAttribute("teacher");
        if (!teacherLogin.getTeacherPassword().equals(oldPassword)){
            map.put("msg", "旧密码填写错误！");
            return map;
        } else {
            teacherLogin.setTeacherPassword(newPassword);
            int result = teacherService.updateTeacherByPrimaryKey(teacherLogin);
            if (result == 1){
                map.put("msg", 200);
            } else {
                map.put("msg", 500);
            }
        }

        return map;
    }
}
