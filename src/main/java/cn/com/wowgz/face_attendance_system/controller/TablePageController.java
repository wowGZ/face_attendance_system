package cn.com.wowgz.face_attendance_system.controller;

import cn.com.wowgz.face_attendance_system.entitiy.*;
import cn.com.wowgz.face_attendance_system.service.impl.CourseServiceImpl;
import cn.com.wowgz.face_attendance_system.service.impl.StudentServiceImpl;
import cn.com.wowgz.face_attendance_system.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.net.www.http.HttpCaptureInputStream;

import javax.servlet.http.HttpSession;
import java.awt.image.ImageProducer;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: WowGz
 * Date: 2020/3/30/030
 * FileName: TablePageController
 * Description: to init data for table page
 */
@Controller
@RequestMapping("/table")
@ResponseBody
public class TablePageController {

    @Autowired  
    private StudentServiceImpl studentService;
    @Autowired
    private TeacherServiceImpl teacherService;
    @Autowired
    private CourseServiceImpl courseService;

    @RequestMapping("/attendanceRecord")
    public TableInfo<AttendanceRecordInfoInTable> toInitAttendanceRecord(HttpSession session, int page, int limit,
                                                                         String stuNumber, String stuName){

        Map<String, Object> condition = new HashMap<>();
        condition.put("stuNumber", stuNumber);
        condition.put("stuName", stuName);

        TableInfo<AttendanceRecordInfoInTable> attendanceRecordInfoTable = new TableInfo<>();

        return new TableInfo<>();
    }

    @RequestMapping("/studentInClass")
    public TableInfo<StuInfo> toInitStuInClass(HttpSession session, int page , int limit,
                                               String stuNumber, String stuName, String stuSex,
                                               String stuAge, String stuMobile) {
        String classNumber = (String) session.getAttribute("classNumber");
//        session.removeAttribute("classNumber");

        Map<String, Object> condition = new HashMap<>();
        condition.put("stuNumber",stuNumber);
        condition.put("stuName",stuName);
        condition.put("stuSex",stuSex);
        condition.put("stuAge",stuAge);
        condition.put("stuMobile",stuMobile);
        condition.put("stuClassNumber", classNumber);

        TableInfo<StuInfo> classInfoTable = new TableInfo<>();
        classInfoTable.setCount(studentService.selectByCondition(condition).size());


        List<StuInfo> result = studentService.selectByCondition(condition);

        List<StuInfo> data = new ArrayList<>();

        if (page == 1 && page * limit <= classInfoTable.getCount()) {
            for (int i = 0; i < limit; i++) {
                data.add(result.get(i));
            }
        } else if (page == 1 && page * limit > classInfoTable.getCount()){
            for (int i = 0; i < classInfoTable.getCount(); i++) {
                data.add(result.get(i));
            }
        } else if (page * limit > classInfoTable.getCount()) {
            for (int i = (page - 1) * limit; i < classInfoTable.getCount(); i++) {
                data.add(result.get(i));
            }
        } else {
            for (int i = ((page - 1) * limit); i < page * limit; i++) {
                data.add(result.get(i));
            }
        }

        classInfoTable.setData(data);
        return classInfoTable;
    }

    @RequestMapping("/coursesTaughtByTeacher")
    public TableInfo<CourseInfo> toInitCourses(HttpSession session, int page, int limit,
                                               String courseNumber, String courseName, String courseCredit){
        String teacherNumber = (String) session.getAttribute("teacherNumber");

        Map<String, Object> condition = new HashMap<>();
        condition.put("courseNumber", courseNumber);
        condition.put("courseName", courseName);
        condition.put("courseCredit", courseCredit);

        TableInfo<CourseInfo> courseInfoTable = new TableInfo<>();
        courseInfoTable.setCount(courseService.selectByCondition(condition).size());

        List<CourseInfo> result = courseService.selectByCondition(condition);
        List<CourseInfo> data = new ArrayList<>();

        if (page == 1 && page * limit <= courseInfoTable.getCount()) {
            for (int i = 0; i < limit; i++) {
                data.add(result.get(i));
            }
        } else if (page == 1 && page * limit > courseInfoTable.getCount()){
            for (int i = 0; i < courseInfoTable.getCount(); i++) {
                data.add(result.get(i));
            }
        } else if (page * limit > courseInfoTable.getCount()) {
            for (int i = (page - 1) * limit; i < courseInfoTable.getCount(); i++) {
                data.add(result.get(i));
            }
        } else {
            for (int i = ((page - 1) * limit); i < page * limit; i++) {
                data.add(result.get(i));
            }
        }

        courseInfoTable.setData(data);
        return courseInfoTable;
    }
}
