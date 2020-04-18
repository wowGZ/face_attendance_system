package cn.com.wowgz.face_attendance_system.service.impl;

import cn.com.wowgz.face_attendance_system.entitiy.StuInfo;
import cn.com.wowgz.face_attendance_system.mapper.StuInfoMapper;
import cn.com.wowgz.face_attendance_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: WowGz
 * Date: 2020/3/29/029
 * FileName: StudentServiceImpl
 * Description:
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StuInfoMapper stuInfoMapper;

    @Override
    public List<StuInfo> selectByClassNumber(String classNumber) {
        return stuInfoMapper.selectByClassNumber(classNumber);
    }

    @Override
    public int addStudent(StuInfo stuInfo) {
        return stuInfoMapper.insertSelective(stuInfo);
    }

    @Override
    public int deleteStudentByStuNumber(String stuNumber) {
        return stuInfoMapper.deleteByStudentNumber(stuNumber);
    }
}
