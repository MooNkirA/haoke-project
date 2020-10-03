package com.moon.sample.dubbo;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Dubbo服务提供者启动类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2020-10-1 17:10
 * @description
 */
@SpringBootApplication
public class DubboProvider {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DubboProvider.class)
                .web(WebApplicationType.NONE) // 配置非web应用
                .run(args);
    }

}
