package com.moon.sample.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 用户实体类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2020-10-3 07:52
 * @description
 */
@Data
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;

}
