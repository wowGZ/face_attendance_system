package cn.com.wowgz.face_attendance_system.dao;

import cn.com.wowgz.face_attendance_system.entitiy.ClassInfo;

public interface ClassInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ClassInfo record);

    int insertSelective(ClassInfo record);

    ClassInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClassInfo record);

    int updateByPrimaryKey(ClassInfo record);
}