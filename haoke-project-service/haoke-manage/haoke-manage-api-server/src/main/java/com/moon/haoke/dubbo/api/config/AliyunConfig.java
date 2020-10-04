package com.moon.haoke.dubbo.api.config;

import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 阿里云oss服务的相关配置类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2020-10-4 15:30
 * @description
 */
@Configuration
@PropertySource("classpath:aliyun.properties")
/*
 * 读取配置文件注入属性方式二：
 *  使用@ConfigurationProperties注解，定义属性prefix为读取的配置文件中的Key的前缀
 *  这种方式不需要再使用@Value注解注入值，但要求需要注入的属性必须提供setter方法
 */
// @ConfigurationProperties(prefix = "aliyun")
public class AliyunConfig {

    @Value("${aliyun.endpoint}")
    private String endpoint;
    @Value("${aliyun.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.accessKeySecret}")
    private String accessKeySecret;
    @Value("${aliyun.bucketName}")
    private String bucketName;
    @Value("${aliyun.urlPrefix}")
    private String urlPrefix;

    // 创建oSSClint
    @Bean
    public OSSClient oSSClient() {
        return new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

    public String getBucketName() {
        return bucketName;
    }

    public String getUrlPrefix() {
        return urlPrefix;
    }

}
