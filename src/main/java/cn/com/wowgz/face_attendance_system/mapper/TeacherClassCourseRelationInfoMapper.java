package cn.com.wowgz.face_attendance_system.mapper;

import cn.com.wowgz.face_attendance_system.entitiy.TeacherClassCourseRelationInfo;

public interface TeacherClassCourseRelationInfoMapper {

    int deleteByPrimaryKey(Integer id);
    int insert(TeacherClassCourseRelationInfo record);
    int insertSelective(TeacherClassCourseRelationInfo record);
    TeacherClassCourseRelationInfo selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(TeacherClassCourseRelationInfo record);
    int updateByPrimaryKey(TeacherClassCourseRelationInfo record);
}