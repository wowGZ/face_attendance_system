package cn.com.wowgz.face_attendance_system.entitiy;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: WowGz
 * Date: 2020/3/11/011
 * FileName: TableInfo
 * Description: to record information of table that I need
 */
public class TableInfo <T> {
    private int code = 0;
    private String msg = "";
    private int count = 1000;
    private List<T> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
