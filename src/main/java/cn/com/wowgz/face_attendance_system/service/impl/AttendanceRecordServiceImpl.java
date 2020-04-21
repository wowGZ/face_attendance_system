package cn.com.wowgz.face_attendance_system.service.impl;

import cn.com.wowgz.face_attendance_system.entitiy.AttendanceRecordInfo;
import cn.com.wowgz.face_attendance_system.entitiy.AttendanceRecordInfoInTable;
import cn.com.wowgz.face_attendance_system.mapper.AttendanceRecordInfoMapper;
import cn.com.wowgz.face_attendance_system.service.AttendanceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Author: WowGz
 * Date: 2020/4/20/020
 * FileName: AttendanceRecordServiceImpl
 * Description:
 */
@Service
public class AttendanceRecordServiceImpl implements AttendanceRecordService {

    @Autowired
    private AttendanceRecordInfoMapper attendanceRecordInfoMapper;

    @Override
    public int addAttendanceRecord(AttendanceRecordInfo record) {
        Date date = new Date();
        int random = (int) (Math.random() * (10000 - 1000) + 1000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        record.setAttendanceRecordNumber(dateFormat.format(date) + random);
        record.setAttendanceTime(date);

        return attendanceRecordInfoMapper.insertSelective(record);
    }

    @Override
    public List<AttendanceRecordInfoInTable> selectTableInfoByCondition(Map<String, Object> condition) {
        return attendanceRecordInfoMapper.selectTableInfoByCondition(condition);
    }

    @Override
    public int deleteAttendanceRecordByPrimaryKey(Integer id) {
        return attendanceRecordInfoMapper.deleteByPrimaryKey(id);
    }
}
