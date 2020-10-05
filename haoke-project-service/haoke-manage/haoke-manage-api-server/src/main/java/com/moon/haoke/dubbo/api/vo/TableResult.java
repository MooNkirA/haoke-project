package com.moon.haoke.dubbo.api.vo;

import lombok.Data;

import java.util.List;

/**
 * 列表查询结果对象
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2020-10-5 10:12
 * @description
 */
@Data
public class TableResult<T> {

    /**
     * 数据列表
     */
    private List<T> list;

    /**
     * 分页信息
     */
    private Pagination pagination;

}
