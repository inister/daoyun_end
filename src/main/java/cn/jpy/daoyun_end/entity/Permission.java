package cn.jpy.daoyun_end.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer permId;
    private Integer parId;
    private String menuName;
    private Boolean isPage;
    private String icon;
    private String link;
    @ManyToMany
    @JoinTable(name = "rolePermission", joinColumns = @JoinColumn(name = "perm_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    public Permission() {
    }

    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }

    public Integer getParId() {
        return parId;
    }

    public void setParId(Integer parId) {
        this.parId = parId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Boolean getPage() {
        return isPage;
    }

    public void setPage(Boolean page) {
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
