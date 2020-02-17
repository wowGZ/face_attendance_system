package cn.com.wowgz.face_attendance_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Copyright (C), 2017-2020
 * Author: WowGz
 * Date: 2020/2/16/016 15:45
 * FileName: TestController
 * Description: to test the controller
 */
@Controller
public class TestController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello World!";
    }

    @RequestMapping("/test")
    public String test() {
        return "test";
    }
}
