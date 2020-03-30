package cn.com.wowgz.face_attendance_system.controller;

import cn.com.wowgz.face_attendance_system.entitiy.StuInfo;
import cn.com.wowgz.face_attendance_system.entitiy.TableInfo;
import cn.com.wowgz.face_attendance_system.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.net.www.http.HttpCaptureInputStream;

import javax.servlet.http.HttpSession;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: WowGz
 * Date: 2020/3/30/030
 * FileName: TablePageController
 * Description: to init data for table page
 */
@Controller
@RequestMapping("/table")
@ResponseBody
public class TablePageController {

    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping("/studentInClass")
    public TableInfo<StuInfo> toInitStuInClass(HttpSession session, int page, int limit) {
        String classNumber = (String) session.getAttribute("classNumber");
//        session.removeAttribute("classNumber");

        TableInfo<StuInfo> classInfoTable = new TableInfo<>();
        classInfoTable.setCount(studentService.selectByClassNumber(classNumber).size());

        List<StuInfo> result = studentService.selectByClassNumber(classNumber);

        List<StuInfo> data = new ArrayList<>();

        if (page == 1 && page * limit <= classInfoTable.getCount()) {
            for (int i = 0; i < limit; i++) {
                data.add(result.get(i));
            }
        } else if (page == 1 && page * limit > classInfoTable.getCount()){
            for (int i = 0; i < classInfoTable.getCount(); i++) {
                data.add(result.get(i));
            }
        } else if (page * limit > classInfoTable.getCount()) {
            for (int i = (page - 1) * limit; i < classInfoTable.getCount(); i++) {
                data.add(result.get(i));
            }
        } else {
            for (int i = ((page - 1) * limit); i < page * limit; i++) {
                data.add(result.get(i));
            }
        }

        classInfoTable.setData(data);
        return classInfoTable;
    }
}
