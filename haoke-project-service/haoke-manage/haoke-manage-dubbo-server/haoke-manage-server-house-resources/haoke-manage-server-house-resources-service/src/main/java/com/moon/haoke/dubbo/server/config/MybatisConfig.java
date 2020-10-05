package com.moon.haoke.dubbo.server.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
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

    /**
     * MyBatis-puls分页插件，注册到ioc容器中
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
