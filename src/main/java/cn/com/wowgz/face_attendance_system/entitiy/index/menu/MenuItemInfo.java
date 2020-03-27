package cn.com.wowgz.face_attendance_system.entitiy.index.menu;

import java.util.ArrayList;

/**
 * Author: WowGz
 * Date: 2020/3/26/026
 * FileName: MenuItemInfo
 * Description:
 */
public class MenuItemInfo {
    private String title;
    private String href;
    private String icon;
    private String target = "_self";
    private ArrayList<MenuItemInfo> child;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public ArrayList<MenuItemInfo> getChild() {
        return child;
    }

    public void setChild(ArrayList<MenuItemInfo> child) {
        this.child = child;
    }
}
