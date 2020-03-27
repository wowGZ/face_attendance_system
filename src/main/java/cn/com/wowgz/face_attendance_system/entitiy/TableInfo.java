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
    private int code;
    private String msg;
    private int count;
    private ArrayList<T> data;

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

    public ArrayList<T> getData() {
        return data;
    }

    public void setData(ArrayList<T> data) {
        this.data = data;
    }
}
