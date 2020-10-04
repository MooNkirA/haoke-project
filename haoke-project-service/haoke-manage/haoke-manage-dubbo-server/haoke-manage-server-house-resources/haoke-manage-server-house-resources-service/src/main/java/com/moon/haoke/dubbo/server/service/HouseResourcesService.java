package com.moon.haoke.dubbo.server.service;

import com.moon.haoke.dubbo.server.pojo.HouseResources;

/**
 * 房源业务层接口
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2020-10-3 23:31
 * @description
 */
public interface HouseResourcesService {

    /**
     * 新增房源
     *
     * @param houseResources
     * @return -1:输入的参数不符合要求，0：数据插入数据库失败，1：成功
     */
    int saveHouseResources(HouseResources houseResources);
}
