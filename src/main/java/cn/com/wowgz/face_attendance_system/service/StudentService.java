package cn.com.wowgz.face_attendance_system.service;

import cn.com.wowgz.face_attendance_system.entitiy.StuInfo;

import java.util.List;
import java.util.Map;

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

    StuInfo selectByStudentNumber(String stuNumber);

    StuInfo selectByPrimaryKey(Integer id);

    List<StuInfo> selectByCondition(Map<String, Object> condition);

    int updateByPrimaryKeySelective(StuInfo stuInfo);

}
