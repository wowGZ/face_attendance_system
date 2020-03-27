package cn.com.wowgz.face_attendance_system.entitiy.index.menu;

import java.util.ArrayList;

/**
 * Author: WowGz
 * Date: 2020/3/26/026
 * FileName: CurrencyInfo
 * Description:
 */
public class CurrencyInfo {
    private String title = "常规管理";
    private String icon = "fa fa-address-book";
    private ArrayList<MenuItemInfo> child;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public ArrayList<MenuItemInfo> getChild() {
        return child;
    }

    public void setChild(ArrayList<MenuItemInfo> child) {
        this.child = child;
    }
}
