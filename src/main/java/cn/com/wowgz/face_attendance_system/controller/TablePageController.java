package cn.com.wowgz.face_attendance_system.controller;

import cn.com.wowgz.face_attendance_system.entitiy.CourseInfo;
import cn.com.wowgz.face_attendance_system.entitiy.StuInfo;
import cn.com.wowgz.face_attendance_system.entitiy.TableInfo;
import cn.com.wowgz.face_attendance_system.service.impl.StudentServiceImpl;
import cn.com.wowgz.face_attendance_system.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.net.www.http.HttpCaptureInputStream;

import javax.servlet.http.HttpSession;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping("/studentInClass")
    public TableInfo<StuInfo> toInitStuInClass(HttpSession session, int page, int limit) {
        String classNumber = (String) session.getAttribute("classNumber");
//        session.removeAttribute("classNumber");

        TableInfo<StuInfo> classInfoTable = new TableInfo<>();
        classInfoTable.setCount(studentService.selectByClassNumber(classNumber).size());

        List<StuInfo> result = studentService.selectByClassNumber(classNumber);

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
    public TableInfo<CourseInfo> toInitCourses(HttpSession session, int page, int limit){
        String teacherNumber = (String) session.getAttribute("teacherNumber");

        TableInfo<CourseInfo> courseInfoTable = new TableInfo<>();
        courseInfoTable.setCount(teacherService.selectClassByTeacherNumber(teacherNumber).size());

        List<CourseInfo> result = teacherService.selectCourseByTeacherNumber(teacherNumber);
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
