package com.moon.sample.mybatisplus.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.moon.sample.mybatisplus.mapper.UserMapper;
import com.moon.sample.mybatisplus.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 用户mapper接口测试
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2020-10-3 08:15
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    // 注入测试的接口
    @Autowired
    private UserMapper userMapper;

    /* 基础的查询测试 */
    @Test
    public void selectTest() {
        List<User> users = this.userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }

    /* 新增操作 */
    @Test
    public void testSave() {
        User user = new User();
        user.setAge(25);
        user.setEmail("shiyuan@qq.com");
        user.setName("石原里美");
        int count = this.userMapper.insert(user);
        System.out.println("新增数据成功! count => " + count);
    }

    /* 根据id更新数据 */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(6L); // 设置需要更新数据的主键
        user.setName("新垣结衣"); // 设置修改的内容

        // 根据id更新，只会更新对象不为null的属性相应的字段
        int count = this.userMapper.updateById(user);
        System.out.println("修改成功! count => " + count);
    }

    /* 根据id删除数据 */
    @Test
    public void testDelete() {
        this.userMapper.deleteById(6L);
        System.out.println("删除成功!");
    }

    // ****************************************************
    //                    查询操作
    // ****************************************************
    /* 根据id查询 */
    @Test
    public void testSelectById() {
        User user = this.userMapper.selectById(3L);
        System.out.println(user);
    }

    /* 条件查询 - like查询 */
    @Test
    public void testSelectByLike() {
        // 创建条件构造器对象QueryWrapper
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 调用相应的方法，设置相应的查询条件
        wrapper.like("name", "o"); // 表示 name like '%o%'
        // 传入条件构造器，实现条件查询
        List<User> list = this.userMapper.selectList(wrapper);
        for (User user : list) {
            System.out.println(user);
        }
    }

    /* 条件查询 - 小于查询 */
    @Test
    public void testSelectByLe() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.le("age", 20);
        List<User> list = this.userMapper.selectList(wrapper);
        for (User user : list) {
            System.out.println(user);
        }
    }

    /* 分页查询 */
    @Test
    public void testSelectByPage() {
        // 调用有参构造创建分页对象，设置当前页与每页显示条数
        Page<User> page = new Page<>(1, 2);
        // 调用selectPage方法，传入分页对象进行分页查询
        IPage<User> userIPage = this.userMapper.selectPage(page, null);
        System.out.println("总条数 ------> " + userIPage.getTotal());
        System.out.println("当前页数 ------> " + userIPage.getCurrent());
        System.out.println("当前每页显示数 ------> " + userIPage.getSize());
        List<User> records = userIPage.getRecords();
        for (User user : records) {
            System.out.println(user);
        }
    }

}
