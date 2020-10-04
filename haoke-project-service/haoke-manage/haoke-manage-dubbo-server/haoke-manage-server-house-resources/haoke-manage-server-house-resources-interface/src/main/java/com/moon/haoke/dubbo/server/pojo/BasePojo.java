package com.moon.haoke.dubbo.server.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 基础Pojo实体，用于抽取实体类公共属性
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2020-10-3 12:59
 * @description
 */
@Data
public class BasePojo implements java.io.Serializable {

    private Date created; // 数据的创建时间
    private Date updated; // 数据的修改时间

}
