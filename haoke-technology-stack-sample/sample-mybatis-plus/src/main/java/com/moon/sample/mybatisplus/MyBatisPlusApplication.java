package com.moon.sample.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * SpringBoot启动类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2020-10-3 08:11
 * @description
 */
// 设置mybatis框架对mapper接口的扫描包路径
@MapperScan("com.moon.sample.mybatisplus.mapper")
@SpringBootApplication
public class MyBatisPlusApplication {

    /**
     * 创建MyBatis-Plus的分页插件，注册到spring ioc容器中
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    public static void main(String[] args) {
        SpringApplication.run(MyBatisPlusApplication.class, args);
    }

}
