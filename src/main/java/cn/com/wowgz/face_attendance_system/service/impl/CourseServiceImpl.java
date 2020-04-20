package cn.com.wowgz.face_attendance_system.service.impl;

import cn.com.wowgz.face_attendance_system.entitiy.CourseInfo;
import cn.com.wowgz.face_attendance_system.mapper.CourseInfoMapper;
import cn.com.wowgz.face_attendance_system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Author: WowGz
 * Date: 2020/4/20/020
 * FileName: CourseServiceImpl
 * Description:
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseInfoMapper courseInfoMapper;


    @Override
    public int addCourse(CourseInfo courseInfo) {
        return courseInfoMapper.insertSelective(courseInfo);
    }

    @Override
    public int deleteCourseByCourseNumber(String courseNumber) {
        return courseInfoMapper.deleteByCourseNumber(courseNumber);
    }

    @Override
    public List<CourseInfo> selectByCondition(Map<String, Object> condition) {
        return courseInfoMapper.selectByCondition(condition);
    }

    @Override
    public CourseInfo selectByPrimaryKey(Integer id) {
        return courseInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CourseInfo courseInfo) {
        return courseInfoMapper.updateByPrimaryKeySelective(courseInfo);
    }
}
