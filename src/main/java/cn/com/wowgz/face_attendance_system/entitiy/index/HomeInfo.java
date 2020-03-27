package cn.com.wowgz.face_attendance_system.entitiy.index;

/**
 * Author: WowGz
 * Date: 2020/3/26/026
 * FileName: HomeInfo
 * Description:
 */
public class HomeInfo {
    private String title = "首页";
    private String icon = "fa fa-home";
    private String href = "/page/welcome-1";

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

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
