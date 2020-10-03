package com.moon.sample.dubbo.pojo;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * 用户实体类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2020-10-1 16:12
 * @description
 */
// 注：使用dubbo传输的对象要求必须实现序列化接口
public class User implements Serializable {

    private static final long serialVersionUID = -7786052938617694652L;

    private Long id;
    private String username;
    private String password;
    private Integer age;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("username='" + username + "'")
                .add("password='" + password + "'")
                .add("age=" + age)
                .toString();
    }
}
