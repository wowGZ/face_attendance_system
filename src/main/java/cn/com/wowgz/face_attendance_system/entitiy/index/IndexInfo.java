package cn.com.wowgz.face_attendance_system.entitiy.index;

import cn.com.wowgz.face_attendance_system.entitiy.index.menu.MenuInfo;

/**
 * Author: WowGz
 * Date: 2020/3/26/026
 * FileName: IndexInfo
 * Description: information for initializing my index page
 */
public class IndexInfo {
    private ClearInfo clearInfo;
    private HomeInfo homeInfo;
    private LogoInfo logoInfo;
    private MenuInfo menuInfo;

    public ClearInfo getClearInfo() {
        return clearInfo;
    }

    public void setClearInfo(ClearInfo clearInfo) {
        this.clearInfo = clearInfo;
    }

    public HomeInfo getHomeInfo() {
        return homeInfo;
    }

    public void setHomeInfo(HomeInfo homeInfo) {
        this.homeInfo = homeInfo;
    }

    public LogoInfo getLogoInfo() {
        return logoInfo;
    }

    public void setLogoInfo(LogoInfo logoInfo) {
        this.logoInfo = logoInfo;
    }

    public MenuInfo getMenuInfo() {
        return menuInfo;
    }

    public void setMenuInfo(MenuInfo menuInfo) {
        this.menuInfo = menuInfo;
    }
}
