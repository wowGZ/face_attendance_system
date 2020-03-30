package cn.com.wowgz.face_attendance_system.controller;

import cn.com.wowgz.face_attendance_system.entitiy.StuInfo;
import cn.com.wowgz.face_attendance_system.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Author: WowGz
 * Date: 2020/3/29/029
 * FileName: MenuItemController
 * Description: to deal with the click of the menu item
 */
@Controller
@RequestMapping("/menu")
public class MenuItemController {
    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping("/classInfo/classNumber={classNumber}")
    public String toClassInfoTable(@PathVariable("classNumber") String classNumber, HttpSession session){
        session.setAttribute("classNumber", classNumber);
        return "redirect:/page/toClassInfoTable";
    }

}
