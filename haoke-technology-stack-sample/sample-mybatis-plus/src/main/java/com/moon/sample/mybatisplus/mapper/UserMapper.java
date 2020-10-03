package com.moon.sample.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.moon.sample.mybatisplus.pojo.User;

/**
 * 用户持久层操作对象
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2020-10-3 08:07
 * @description
 */
// 使用MyBatis-Plus插件，需要继承此工具框架提供的BaseMapper<T>接口，泛型为接口操作的数据库表相应的实体类
public interface UserMapper extends BaseMapper<User> {
}
