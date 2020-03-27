package cn.com.wowgz.face_attendance_system.controller;

import cn.com.wowgz.face_attendance_system.entitiy.CourseInfo;
import cn.com.wowgz.face_attendance_system.entitiy.TableInfo;
import cn.com.wowgz.face_attendance_system.entitiy.TeacherInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Copyright (C), 2017-2020
 * Author: WowGz
 * Date: 2020/2/16/016 15:45
 * FileName: TestController
 * Description: to test the controller
 */
@Controller
@RequestMapping("/test")
public class TestController {


    @RequestMapping("/hello")
    @ResponseBody
    public TableInfo hello() {
        CourseInfo courseInfo1 = new CourseInfo();
        courseInfo1.setCourseCredit("4");
        courseInfo1.setCourseName("Math");
        courseInfo1.setCourseNumber("16070841");
        courseInfo1.setId(1);

        CourseInfo courseInfo2 = new CourseInfo();
        courseInfo2.setCourseCredit("4");
        courseInfo2.setCourseName("English");
        courseInfo2.setCourseNumber("16070841");
        courseInfo2.setId(2);

        CourseInfo courseInfo3 = new CourseInfo();
        courseInfo3.setCourseCredit("4");
        courseInfo3.setCourseName("Chinese");
        courseInfo3.setCourseNumber("16070841");
        courseInfo3.setId(3);

        ArrayList<CourseInfo> courseInfoList = new ArrayList<>();
        courseInfoList.add(courseInfo1);
        courseInfoList.add(courseInfo2);
        courseInfoList.add(courseInfo3);

        TableInfo tableInfo = new TableInfo();
        tableInfo.setCode(0);
        tableInfo.setMsg("");
        tableInfo.setCount(1000);
        tableInfo.setData(courseInfoList);

        return tableInfo;
    }

    @RequestMapping("/login")
    public String test() {
        return "login";
    }
}
