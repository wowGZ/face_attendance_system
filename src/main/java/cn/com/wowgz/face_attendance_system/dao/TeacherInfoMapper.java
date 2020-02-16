package cn.com.wowgz.face_attendance_system.dao;

import cn.com.wowgz.face_attendance_system.entitiy.TeacherInfo;

public interface TeacherInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TeacherInfo record);

    int insertSelective(TeacherInfo record);

    TeacherInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeacherInfo record);

    int updateByPrimaryKey(TeacherInfo record);
}