package cn.com.wowgz.face_attendance_system.mapper;

import cn.com.wowgz.face_attendance_system.entitiy.CourseInfo;

import java.util.List;
import java.util.Map;

public interface CourseInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int deleteByCourseNumber(String courseNumber);

    int insert(CourseInfo record);

    int insertSelective(CourseInfo record);

    CourseInfo selectByPrimaryKey(Integer id);

    List<CourseInfo> selectByCondition(Map<String, Object> condition);

    int updateByPrimaryKeySelective(CourseInfo record);

    int updateByPrimaryKey(CourseInfo record);
}