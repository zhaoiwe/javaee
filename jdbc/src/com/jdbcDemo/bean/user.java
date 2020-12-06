/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: user
 * Author:   zhaowei
 * Date:     2020/12/5 14:45
 * Description: 用户实体
 * History:
 *
 */
package com.jdbcDemo.bean;


import java.io.Serializable;

/**
 * 接收数据表user的实体类
 * 〈用户实体〉
 *
 * @author zhaowei
 * @create 2020/12/5
 * @since 1.0.0
 */
public class user implements Serializable{


    private int id;
    private String username;
    private String password;
    private String nickname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
