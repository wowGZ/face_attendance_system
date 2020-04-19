package cn.com.wowgz.face_attendance_system.mapper;

import cn.com.wowgz.face_attendance_system.entitiy.StuInfo;

import java.util.List;
import java.util.Map;

public interface StuInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int deleteByStudentNumber(String stuNumber);

    int insert(StuInfo record);

    int insertSelective(StuInfo record);

    StuInfo selectByPrimaryKey(Integer id);

    StuInfo selectByStudentNumber(String stuNumber);

    List<StuInfo> selectByClassNumber(String classNumber);

    List<StuInfo> selectByCondition(Map<String, Object> condition);

    int updateByPrimaryKeySelective(StuInfo record);

    int updateByPrimaryKey(StuInfo record);
}