package cn.com.wowgz.face_attendance_system.service.impl;

import cn.com.wowgz.face_attendance_system.entitiy.ClassInfo;
import cn.com.wowgz.face_attendance_system.entitiy.CourseInfo;
import cn.com.wowgz.face_attendance_system.entitiy.TeacherInfo;
import cn.com.wowgz.face_attendance_system.mapper.TeacherInfoMapper;
import cn.com.wowgz.face_attendance_system.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Author: WowGz
 * Date: 2020/3/9/009
 * FileName: TeacherService
 * Description: service about teacherInfo
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherInfoMapper teacherInfoMapper;


    @Override
    public boolean teacherLogin(String name, String password) {
        TeacherInfo teacherInfo = teacherInfoMapper.selectByNumber(name);
        if (StringUtils.isEmpty(teacherInfo)) {
            return false;
        } else {
            return teacherInfo.getTeacherPassword().equals(password);
        }
    }

    @Override
    public int updateTeacherByPrimaryKey(TeacherInfo teacherInfo) {
        return teacherInfoMapper.updateByPrimaryKeySelective(teacherInfo);
    }

    @Override
    public TeacherInfo selectTeacherByNumber(String number) {
        return teacherInfoMapper.selectByNumber(number);
    }

    @Override
    public List<CourseInfo> selectCourseByTeacherNumber(String teacherNumber) {
        return teacherInfoMapper.selectCourseByTeacherNumber(teacherNumber);
    }

    @Override
    public List<CourseInfo> selectCourseByTeacherNumberAndClassNumber(String teacherNumber, String classNumber) {
        return teacherInfoMapper.selectCourseByTeacherNumberAndClassNumber(teacherNumber,classNumber);
    }

    @Override
    public List<ClassInfo> selectClassByTeacherNumber(String teacherNumber) {
        return teacherInfoMapper.selectClassByTeacherNumber(teacherNumber);
    }
}
