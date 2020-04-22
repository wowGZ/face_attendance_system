package cn.com.wowgz.face_attendance_system.service;

import cn.com.wowgz.face_attendance_system.entitiy.ClassInfo;
import cn.com.wowgz.face_attendance_system.entitiy.CourseInfo;
import cn.com.wowgz.face_attendance_system.entitiy.TeacherInfo;

import java.util.List;

/**
 * Author: WowGz
 * Date: 2020/3/9/009
 * FileName: TeacherServiceImpl
 * Description:
 */
public interface TeacherService {

    boolean teacherLogin(String name, String password);

    int updateTeacherByPrimaryKey(TeacherInfo teacherInfo);

    TeacherInfo selectTeacherByNumber(String number);

    List<CourseInfo> selectCourseByTeacherNumber(String teacherNumber);

    List<CourseInfo> selectCourseByTeacherNumberAndClassNumber(String teacherNumber, String classNumber);

    List<ClassInfo> selectClassByTeacherNumber(String teacherNumber);
}
