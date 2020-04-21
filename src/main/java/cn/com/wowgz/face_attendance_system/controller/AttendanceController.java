package cn.com.wowgz.face_attendance_system.controller;

import cn.com.wowgz.face_attendance_system.entitiy.AttendanceRecordInfo;
import cn.com.wowgz.face_attendance_system.service.impl.AttendanceRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: WowGz
 * Date: 2020/4/21/021
 * FileName: AttendanceController
 * Description:
 */
@Controller
@RequestMapping("/attendanceRecord")
public class AttendanceController {

    @Autowired
    private AttendanceRecordServiceImpl attendanceRecordService;

    @RequestMapping("/addAttendanceRecord")
    @ResponseBody
    public Map<String, Object> addAttendanceRecord(AttendanceRecordInfo attendanceRecordInfo){

        int result = attendanceRecordService.addAttendanceRecord(attendanceRecordInfo);

        Map<String, Object> map = new HashMap<>();
        if (result == 1) {
            map.put("result", "添加成功！");
            return map;
        }

        map.put("result","添加失败！");
        return map;
    }

    @RequestMapping("/deleteAttendanceRecord")
    @ResponseBody
    public Map<String, Object> deleteAttendanceRecord(Integer id){
        Map<String, Object> map = new HashMap<>();
        if (id == null || id.equals("")){
            map.put("msg", 500);
            return map;
        }

        int result = attendanceRecordService.deleteAttendanceRecordByPrimaryKey(id);
        if (result == 1){
            map.put("msg", 200);
        } else {
            map.put("msg", 500);
        }

        return map;
    }
}
