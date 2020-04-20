package cn.com.wowgz.face_attendance_system.controller;

import cn.com.wowgz.face_attendance_system.entitiy.CourseInfo;
import cn.com.wowgz.face_attendance_system.entitiy.StuInfo;
import cn.com.wowgz.face_attendance_system.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: WowGz
 * Date: 2020/4/20/020
 * FileName: CourseController
 * Description:
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseServiceImpl courseService;

    @RequestMapping("/addCourse")
    @ResponseBody
    public Map<String, Object> addCourse(CourseInfo courseInfo) {
        int result = courseService.addCourse(courseInfo);

        Map<String, Object> map = new HashMap<>();
        if (result == 1) {
            map.put("result", "添加成功！");
            return map;
        }
        map.put("result","添加失败！");
        return map;

    }

    @RequestMapping("/deleteCourse")
    @ResponseBody
    public Map<String, Object> deleteCourse(String courseNumber){

        Map<String, Object> map = new HashMap<>();
        if (courseNumber == null || courseNumber.equals("")){
            map.put("msg", 500);
            return map;
        }

        int result = courseService.deleteCourseByCourseNumber(courseNumber);
        if (result == 1){
            map.put("msg", 200);
        } else {
            map.put("msg", 500);
        }

        return map;
    }

    @RequestMapping("/updateCourse")
    @ResponseBody
    public Map<String, Object> updateStudent(CourseInfo courseInfo, HttpSession session){

        Map<String, Object> map = new HashMap<>();

        courseInfo.setId((Integer) session.getAttribute("courseId"));
        int result = courseService.updateByPrimaryKeySelective(courseInfo);
        if (result == 1){
            map.put("msg", "修改成功");
        } else {
            map.put("msg", "修改失败");
        }

        return map;
    }

}
