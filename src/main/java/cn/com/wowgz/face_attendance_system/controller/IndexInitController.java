package cn.com.wowgz.face_attendance_system.controller;

import cn.com.wowgz.face_attendance_system.entitiy.ClassInfo;
import cn.com.wowgz.face_attendance_system.entitiy.CourseInfo;
import cn.com.wowgz.face_attendance_system.entitiy.TeacherInfo;
import cn.com.wowgz.face_attendance_system.entitiy.index.ClearInfo;
import cn.com.wowgz.face_attendance_system.entitiy.index.HomeInfo;
import cn.com.wowgz.face_attendance_system.entitiy.index.IndexInfo;
import cn.com.wowgz.face_attendance_system.entitiy.index.LogoInfo;
import cn.com.wowgz.face_attendance_system.entitiy.index.menu.CurrencyInfo;
import cn.com.wowgz.face_attendance_system.entitiy.index.menu.MenuInfo;
import cn.com.wowgz.face_attendance_system.entitiy.index.menu.MenuItemInfo;
import cn.com.wowgz.face_attendance_system.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: WowGz
 * Date: 2020/3/26/026
 * FileName: IndexInitController
 * Description: to init information in the index page
 */
@Controller
public class IndexInitController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/initIndex")
    @ResponseBody
    public IndexInfo toInitIndexPage(HttpSession session){
        TeacherInfo teacherInfo = (TeacherInfo) session.getAttribute("teacher");

        //初步初始化index页面所需要的数据
        IndexInfo indexInfo = new IndexInfo();
        indexInfo.setClearInfo(new ClearInfo());//记得设置clearURL
        indexInfo.setLogoInfo(new LogoInfo());
        indexInfo.setHomeInfo(new HomeInfo());

        //对菜单项进行初始化
        MenuInfo menuInfo = new MenuInfo();
        CurrencyInfo currencyInfo = new CurrencyInfo();
        menuInfo.setCurrency(currencyInfo);

        //菜单项：
        // 签到情况（班号为菜单子项，每个子项中根据课程再分子项，最后显示签到记录表的信息）
        // 班级信息（所带班级班号分为各个菜单子项）
        // 课程信息
        MenuItemInfo classMenuItem = new MenuItemInfo();
        MenuItemInfo courseMenuItem = new MenuItemInfo();
        MenuItemInfo attendanceMenuItem = new MenuItemInfo();

        //初始化课程菜单项，点击之后跳转该教师所带课程的表格页面
        courseMenuItem.setTitle("课程信息");
        courseMenuItem.setHref("");
        courseMenuItem.setIcon("");
        courseMenuItem.setChild(null);

        //初始化班级信息菜单项，该菜单项的子项为该教师所带班级的班号
        classMenuItem.setTitle("班级信息");
        classMenuItem.setHref("");
        classMenuItem.setIcon("fa fa-calendar");
        ArrayList<MenuItemInfo> classMenuItemChild = new ArrayList<>();
        List<ClassInfo> classInfoList =
                teacherService.selectClassByTeacherNumber(teacherInfo.getTeacherNumber());
        for (ClassInfo classInfo :
                classInfoList) {
            MenuItemInfo menuItemInfo = new MenuItemInfo();
            menuItemInfo.setTitle(classInfo.getClassNumber());
            menuItemInfo.setIcon("fa fa-list-alt");//随便设置一个图案
            menuItemInfo.setHref("");//针对班级，显示学生数据，专门设计一个url对这个进行处理就好
            menuItemInfo.setChild(null);

            classMenuItemChild.add(menuItemInfo);
        }
        classMenuItem.setChild(classMenuItemChild);

        //初始化签到信息菜单项，第一层子项为所带班级，第二层为该老师所带班级的课程
        // 再次点击之后跳转对应班级课程的学生签到情况
        attendanceMenuItem.setTitle("签到情况");
        attendanceMenuItem.setIcon("fa fa-window-maximize");
        attendanceMenuItem.setHref("");
        ArrayList<MenuItemInfo> attendanceMenuItemChild = new ArrayList<>();
        for (ClassInfo classInfo :
                classInfoList) {
            MenuItemInfo menuItemInfo = new MenuItemInfo();
            menuItemInfo.setTitle(classInfo.getClassNumber());
            menuItemInfo.setIcon("fa fa-list-alt");
            menuItemInfo.setHref("");
            ArrayList<MenuItemInfo> itemChild = new ArrayList<>();
            for (CourseInfo courseInfo :
                    teacherService.selectCourseByTeacherNumberAndClassNumber(teacherInfo.getTeacherNumber(),
                            classInfo.getClassNumber())) {
                MenuItemInfo itemInfo = new MenuItemInfo();
                itemInfo.setTitle(courseInfo.getCourseName());
                itemInfo.setIcon("");
                itemInfo.setHref("");//设置获取对应班级课程的所有签到记录

                itemChild.add(itemInfo);
            }
            menuItemInfo.setChild(itemChild);

            attendanceMenuItemChild.add(menuItemInfo);
        }
        attendanceMenuItem.setChild(attendanceMenuItemChild);

        ArrayList<MenuItemInfo> currencyChild = new ArrayList<>();
        currencyChild.add(attendanceMenuItem);
        currencyChild.add(classMenuItem);
        currencyChild.add(courseMenuItem);
        currencyInfo.setChild(currencyChild);

        indexInfo.setMenuInfo(menuInfo);
        return indexInfo;
    }
}
