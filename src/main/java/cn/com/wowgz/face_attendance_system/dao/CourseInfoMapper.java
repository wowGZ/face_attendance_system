package cn.com.wowgz.face_attendance_system.dao;

import cn.com.wowgz.face_attendance_system.entitiy.CourseInfo;

public interface CourseInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(CourseInfo record);

    int insertSelective(CourseInfo record);

    CourseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseInfo record);

    int updateByPrimaryKey(CourseInfo record);
}