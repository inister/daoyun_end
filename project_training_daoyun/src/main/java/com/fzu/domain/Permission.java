package com.fzu.domain;

import java.io.Serializable;

public class Permission implements Serializable {
    private int permId;
    private int parId;
    private String menuName;
    private boolean isPage;
    private String icon;
    private String link;

    public int getPermId() {
        return permId;
    }

    public void setPermId(int permId) {
        this.permId = permId;
    }

    public int getParId() {
        return parId;
    }

    public void setParId(int parId) {
        this.parId = parId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public boolean isPage() {
        return isPage;
    }

    public void setPage(boolean page) {
        isPage = page;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
