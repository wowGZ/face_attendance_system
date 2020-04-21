package cn.com.wowgz.face_attendance_system.entitiy;

import java.util.Date;

/**
 * Author: WowGz
 * Date: 2020/4/20/020
 * FileName: AttendanceRecordInfoInTable
 * Description:
 */
public class AttendanceRecordInfoInTable {
    private Integer id;
    private String attendanceRecordNumber;
    private String stuNumber;
    private String stuName;
    private String stuSex;
    private Date attendanceTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttendanceRecordNumber() {
        return attendanceRecordNumber;
    }

    public void setAttendanceRecordNumber(String attendanceRecordNumber) {
        this.attendanceRecordNumber = attendanceRecordNumber;
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public Date getAttendanceTime() {
        return attendanceTime;
    }

    public void setAttendanceTime(Date attendanceTime) {
        this.attendanceTime = attendanceTime;
    }
}
