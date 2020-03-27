package cn.com.wowgz.face_attendance_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author WowGz
 */
@MapperScan("cn.com.wowgz.face_attendance_system.mapper")
//@ComponentScan("cn.com.wowgz.face_attendance_system.service")
@SpringBootApplication
public class FaceAttendanceSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(FaceAttendanceSystemApplication.class, args);
    }

}
