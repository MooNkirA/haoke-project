package com.moon.haoke.dubbo.server.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis 的配置类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2020-10-3 22:14
 * @description
 */
// 配置扫描mapper接口
@MapperScan("com.moon.haoke.dubbo.server.mapper")
@Configuration
public class MybatisConfig {
}
