package cn.com.wowgz.face_attendance_system.controller;

import cn.com.wowgz.face_attendance_system.entitiy.StuInfo;
import cn.com.wowgz.face_attendance_system.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: WowGz
 * Date: 2020/4/11/011
 * FileName: ClassController
 * Description: CRUD for class information
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping("/addStudent")
    @ResponseBody
    public Map<String, Object> addStudent(StuInfo stuInfo) {
        int result = studentService.addStudent(stuInfo);

        Map<String, Object> map = new HashMap<>();
        if (result == 1) {
            map.put("result", "添加成功");
            return map;
        }
        return map;

    }

}
