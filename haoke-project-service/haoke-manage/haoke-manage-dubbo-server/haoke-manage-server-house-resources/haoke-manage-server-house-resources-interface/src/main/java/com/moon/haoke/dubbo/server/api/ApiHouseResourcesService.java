package com.moon.haoke.dubbo.server.api;

import com.moon.haoke.dubbo.server.pojo.HouseResources;

/**
 * 房源模块，对外暴露的服务接口
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2020-10-3 21:49
 * @description
 */
public interface ApiHouseResourcesService {

    /**
     * 新增房源
     *
     * @param houseResources 房源对象
     * @return -1:输入的参数不符合要求，0：数据插入数据库失败，1：成功
     */
    int saveHouseResources(HouseResources houseResources);

}
