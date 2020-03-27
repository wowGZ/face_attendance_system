package cn.com.wowgz.face_attendance_system.mapper;

import cn.com.wowgz.face_attendance_system.entitiy.ClassInfo;
import cn.com.wowgz.face_attendance_system.entitiy.CourseInfo;
import cn.com.wowgz.face_attendance_system.entitiy.TeacherInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TeacherInfo record);

    int insertSelective(TeacherInfo record);

    TeacherInfo selectByPrimaryKey(Integer id);

    TeacherInfo selectByNumber(String number);

    List<CourseInfo> selectCourseByTeacherNumber(String teacherNumber);

    List<CourseInfo> selectCourseByTeacherNumberAndClassNumber(@Param("teacherNumber") String teacherNumber, @Param("classNumber") String classNumber);

    List<ClassInfo> selectClassByTeacherNumber(String teacherNumber);

    int updateByPrimaryKeySelective(TeacherInfo record);

    int updateByPrimaryKey(TeacherInfo record);
}