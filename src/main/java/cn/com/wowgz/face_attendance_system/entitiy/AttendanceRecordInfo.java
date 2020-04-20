package cn.com.wowgz.face_attendance_system.entitiy;

import java.io.Serializable;
import java.util.Date;


public class AttendanceRecordInfo implements Serializable {

    private Integer id;
    private String attendanceRecordNumber;
    private String stuNumber;
    private String classNumber;
    private String courseNumber;
    private Date attendanceTime;
    private static final long serialVersionUID = 1L;

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
        this.attendanceRecordNumber = attendanceRecordNumber == null ? null : attendanceRecordNumber.trim();
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber == null ? null : stuNumber.trim();
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber == null ? null : classNumber.trim();
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber == null ? null : courseNumber.trim();
    }

    public Date getAttendanceTime() {
        return attendanceTime;
    }

    public void setAttendanceTime(Date attendanceTime) {
        this.attendanceTime = attendanceTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", attendanceRecordNumber=").append(attendanceRecordNumber);
        sb.append(", stuNumber=").append(stuNumber);
        sb.append(", classNumber=").append(classNumber);
        sb.append(", courseNumber=").append(courseNumber);
        sb.append(", attendanceTime=").append(attendanceTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}