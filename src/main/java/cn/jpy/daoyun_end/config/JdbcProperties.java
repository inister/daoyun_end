package cn.jpy.daoyun_end.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ConfigurationProperties 从application配置文件读取配置项
 * prefix表示配置项的前缀
 * 配置项类中的类变量名必须与前缀保持松散绑定（相同）
 */
//@ConfigurationProperties(prefix = "jdbc")
public class JdbcProperties {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
