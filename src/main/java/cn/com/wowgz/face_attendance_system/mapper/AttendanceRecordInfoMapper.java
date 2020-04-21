package cn.com.wowgz.face_attendance_system.mapper;

import cn.com.wowgz.face_attendance_system.entitiy.AttendanceRecordInfo;
import cn.com.wowgz.face_attendance_system.entitiy.AttendanceRecordInfoInTable;

import java.util.List;
import java.util.Map;

public interface AttendanceRecordInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(AttendanceRecordInfo record);

    int insertSelective(AttendanceRecordInfo record);

    AttendanceRecordInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AttendanceRecordInfo record);

    int updateByPrimaryKey(AttendanceRecordInfo record);

    List<AttendanceRecordInfoInTable> selectTableInfoByCondition(Map<String, Object> condition);
}