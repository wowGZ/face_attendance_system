package cn.com.wowgz.face_attendance_system.service;

import cn.com.wowgz.face_attendance_system.entitiy.StuInfo;

import java.util.List;

/**
 * Author: WowGz
 * Date: 2020/3/29/029
 * FileName: StudentService
 * Description:
 */
public interface StudentService {

    List<StuInfo> selectByClassNumber(String classNumber);

    int addStudent(StuInfo stuInfo);

    int deleteStudentByStuNumber(String stuNumber);

}
