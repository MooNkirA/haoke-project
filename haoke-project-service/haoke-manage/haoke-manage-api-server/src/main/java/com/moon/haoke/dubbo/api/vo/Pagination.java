package com.moon.haoke.dubbo.api.vo;

import lombok.Data;

/**
 * 分页信息实体类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2020-10-5 10:14
 * @description
 */
@Data
public class Pagination {

    /**
     * 当前页
     */
    private Integer current;

    /**
     * 每页大小
     */
    private Integer pageSize;

    /**
     * 总记录数
     */
    private Integer total;

}
