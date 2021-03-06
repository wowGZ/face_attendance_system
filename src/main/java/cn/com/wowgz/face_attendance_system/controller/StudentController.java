package cn.com.wowgz.face_attendance_system.controller;

import cn.com.wowgz.face_attendance_system.entitiy.StuInfo;
import cn.com.wowgz.face_attendance_system.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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
            map.put("result", "添加成功！");
            return map;
        }
        map.put("result","添加失败！");
        return map;

    }

    @RequestMapping("/deleteStudent")
    @ResponseBody
    public Map<String, Object> deleteStudent(String stuNumber){

        Map<String, Object> map = new HashMap<>();
        if (stuNumber == null || stuNumber.equals("")){
            map.put("msg", 500);
            return map;
        }

        int result = studentService.deleteStudentByStuNumber(stuNumber);
        if (result == 1){
            map.put("msg", 200);
        } else {
            map.put("msg", 500);
        }

        return map;
    }

    @RequestMapping("/updateStudent")
    @ResponseBody
    public Map<String, Object> updateStudent(StuInfo stuInfo, HttpSession session){

        Map<String, Object> map = new HashMap<>();

        stuInfo.setId((Integer) session.getAttribute("studentId"));
        int result = studentService.updateByPrimaryKeySelective(stuInfo);
        if (result == 1){
            map.put("msg", "修改成功");
        } else {
            map.put("msg", "修改失败");
        }

        return map;
    }

}
