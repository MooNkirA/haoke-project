package com.moon.sample.dubbo.service;

import com.moon.sample.dubbo.pojo.User;

import java.util.List;

/**
 * 用户业务服务接口
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2020-10-1 16:40
 * @description
 */
public interface UserService {

    /**
     * 查询所有的用户数据
     *
     * @return
     */
    List<User> queryAll();

}
