package cn.com.wowgz.face_attendance_system.dao;

import cn.com.wowgz.face_attendance_system.entitiy.AttendanceRecordInfo;

public interface AttendanceRecordInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(AttendanceRecordInfo record);

    int insertSelective(AttendanceRecordInfo record);

    AttendanceRecordInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AttendanceRecordInfo record);

    int updateByPrimaryKey(AttendanceRecordInfo record);
}