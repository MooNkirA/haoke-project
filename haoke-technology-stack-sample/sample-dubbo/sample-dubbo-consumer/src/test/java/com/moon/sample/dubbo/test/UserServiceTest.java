package com.moon.sample.dubbo.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.moon.sample.dubbo.pojo.User;
import com.moon.sample.dubbo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 消费者调用接口测试
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2020-10-1 17:41
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    /*
     * 使用dubbo的@Reference注解注入提供方服务接口
     *  因为提供方的@Service注解中配置版本号，所以此处也指定版本号
     * 配置负载均衡属性loadbalance为轮询(roundrobin)
     */
    @Reference(version = "1.0.0")
    private UserService userService;

    @Test
    public void queryAllTest() {
        // 循环多次调用
        for (int i = 0; i < 30; i++) {
            System.out.println("开始调用远程服务 >>>>>" + i);
            List<User> users = this.userService.queryAll();
            for (User user : users) {
                System.out.println(user);
            }

            // 睡眠1秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
