package com.moon.haoke.dubbo.server.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * 分页列表结果对象
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2020-10-5 09:07
 * @description
 */
@Data
// @AllArgsConstructor
public class PageInfo<T> implements java.io.Serializable {

    private static final long serialVersionUID = -3263793888384196557L;

    /**
     * 总记录数
     */
    private Integer total;

    /**
     * 当前页
     */
    private Integer pageNum;

    /**
     * 一页显示的大小
     */
    private Integer pageSize;

    /**
     * 数据列表
     */
    private List<T> records = Collections.emptyList();

}
