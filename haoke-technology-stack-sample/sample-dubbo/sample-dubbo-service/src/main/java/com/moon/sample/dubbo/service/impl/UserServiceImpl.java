package com.moon.sample.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.moon.sample.dubbo.pojo.User;
import com.moon.sample.dubbo.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户接口实现类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2020-10-1 16:42
 * @description
 */
/*
 * 声明这是一个dubbo服务实现。
 *   注：此@Service注解是dubbo框架的，非spring框架
 *   此version属性用来标识接口实现的版本号，一个接口有多个不同版本的实现，
 *   方便消费者调用不同的版本的实现
 */
@Service(version = "${dubbo.service.version}")
public class UserServiceImpl implements UserService {

    /**
     * 实现查询，这里做模拟实现，不做具体的数据库查询
     *
     * @return
     */
    @Override
    public List<User> queryAll() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setAge(10 + i);
            user.setId(Long.valueOf(i + 1));
            user.setPassword("123456");
            user.setUsername("username_" + i);
            list.add(user);
        }
        System.out.println("---------提供者1：UserServiceImpl.queryAll()方法执行------------");
        return list;
    }

}
