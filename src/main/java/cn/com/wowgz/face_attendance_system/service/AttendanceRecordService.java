package cn.com.wowgz.face_attendance_system.service;

import cn.com.wowgz.face_attendance_system.entitiy.AttendanceRecordInfo;
import cn.com.wowgz.face_attendance_system.entitiy.AttendanceRecordInfoInTable;

import java.util.List;
import java.util.Map;

/**
 * Author: WowGz
 * Date: 2020/4/20/020
 * FileName: AttendanceRecordService
 * Description:
 */
public interface AttendanceRecordService {

    int addAttendanceRecord(AttendanceRecordInfo record);

    List<AttendanceRecordInfoInTable> selectTableInfoByCondition(Map<String, Object> condition);

}
