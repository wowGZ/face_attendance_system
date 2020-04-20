package cn.com.wowgz.face_attendance_system.service;

import cn.com.wowgz.face_attendance_system.entitiy.CourseInfo;

import java.util.List;
import java.util.Map;

/**
 * Author: WowGz
 * Date: 2020/4/20/020
 * FileName: CourseService
 * Description:
 */
public interface CourseService {

    int addCourse(CourseInfo courseInfo);

    int deleteCourseByCourseNumber(String courseNumber);

    List<CourseInfo> selectByCondition(Map<String, Object> condition);

    CourseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseInfo courseInfo);
}
