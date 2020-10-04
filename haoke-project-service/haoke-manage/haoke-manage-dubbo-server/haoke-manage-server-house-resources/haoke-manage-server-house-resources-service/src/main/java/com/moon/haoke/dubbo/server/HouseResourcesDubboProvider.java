package com.moon.haoke.dubbo.server;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 房源服务工程启动类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2020-10-4 07:10
 * @description
 */
@SpringBootApplication
public class HouseResourcesDubboProvider {

    public static void main(String[] args) {
        new SpringApplicationBuilder(HouseResourcesDubboProvider.class)
                .web(WebApplicationType.NONE) // 配置非web项目
                .run();
    }

}
