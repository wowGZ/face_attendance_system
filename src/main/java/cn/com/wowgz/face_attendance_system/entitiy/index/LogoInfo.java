package cn.com.wowgz.face_attendance_system.entitiy.index;

/**
 * Author: WowGz
 * Date: 2020/3/26/026
 * FileName: LogoInfo
 * Description:
 */
public class LogoInfo {
    private String title = "WowGz";
    private String image = "../static/images/logo.png";
    private String href;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
