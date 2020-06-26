package com.blog.pojo;

import java.io.Serializable;

/**
 * @author Administrator
 * @Title: base
 * @ProjectName blog_service
 * @Description: TODO
 * @date 2020/6/2511:24
 */
public class Base implements Serializable {
    private String id;
    private String username;
    private String password;

    public Base() {
    }

    public Base(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
