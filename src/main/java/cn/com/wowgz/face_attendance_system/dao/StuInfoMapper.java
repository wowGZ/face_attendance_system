package cn.com.wowgz.face_attendance_system.dao;

import cn.com.wowgz.face_attendance_system.entitiy.StuInfo;

public interface StuInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(StuInfo record);

    int insertSelective(StuInfo record);

    StuInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StuInfo record);

    int updateByPrimaryKey(StuInfo record);
}