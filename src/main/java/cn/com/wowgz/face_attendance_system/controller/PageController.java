package cn.com.wowgz.face_attendance_system.controller;

import cn.com.wowgz.face_attendance_system.entitiy.CourseInfo;
import cn.com.wowgz.face_attendance_system.entitiy.StuInfo;
import cn.com.wowgz.face_attendance_system.service.impl.CourseServiceImpl;
import cn.com.wowgz.face_attendance_system.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Author: WowGz
 * Date: 2020/2/29/029
 * FileName: PageController
 * Description: controller to manage pages forward
 */
@Controller
@RequestMapping("/page")
public class PageController {

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private CourseServiceImpl courseService;

    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/toLoginError")
    public String toLoginError(Model model) {
        model.addAttribute("error", "用户名或密码错误！");
        return "login";
    }

    @RequestMapping("toIndex")
    public String toIndex() {
        return "index";
    }

    @RequestMapping("/welcome-1")
    public String toWelcome() {
        return "welcome";
    }

    @RequestMapping("/toClassInfoTable")
    public String toClassInfoTable() {
        return "classInfoTable";
    }

    @RequestMapping("/toCourseInfoTable")
    public String toCourseInfoTable() {
        return "courseInfoTable";
    }

    @RequestMapping("/toAttendanceInfoTable")
    public String toAttendanceInfoTable(){
        return "attendanceInfoTable";
    }

    @RequestMapping("/toAddStudent")
    public String toAddClass() {
        return "addStudent";
    }

    @RequestMapping("/toEditStudentInfo/{id}")
    public String toEditStudentInfo(@PathVariable("id") String id, Model model, HttpSession session) {

        Integer stuId = Integer.parseInt(id);
        StuInfo stuInfo = studentService.selectByPrimaryKey(stuId);

        session.setAttribute("studentId",stuInfo.getId());
        session.setAttribute("studentName", stuInfo.getStuName());
        session.setAttribute("studentSex", stuInfo.getStuSex());
        session.setAttribute("studentAge", stuInfo.getStuAge());
        session.setAttribute("studentMobile", stuInfo.getStuMobile());
        session.setAttribute("studentClassNumber", stuInfo.getStuClassNumber());
        session.setAttribute("studentNumber", stuInfo.getStuNumber());
        session.setAttribute("studentPassword", stuInfo.getStuPassword());

        return "redirect:/page/toEditStudentInfo";
//        return "editStudentInfo";
    }

    @RequestMapping("/toEditStudentInfo")
    public String toEditStudent(){
        return "editStudentInfo";
    }

    @RequestMapping("/toAddCourse")
    public String toAddCourse() {
        return "addCourse";
    }

    @RequestMapping("/toEditCourseInfo/{id}")
    public String toEditCourseInfo(@PathVariable("id") String id, HttpSession session){
        Integer courseId = Integer.parseInt(id);
        CourseInfo courseInfo = courseService.selectByPrimaryKey(courseId);

        session.setAttribute("course", courseInfo);
        session.setAttribute("courseId",courseInfo.getId());

        return "redirect:/page/toEditCourseInfo";
    }

    @RequestMapping("/toEditCourseInfo")
    public String toEditCourseInfo(){
        return "editCourseInfo";
    }

    @RequestMapping("/toAddAttendanceRecordInfo")
    public String toAddAttendanceRecordInfo(){
        return "addAttendanceRecordInfo";
    }
}
