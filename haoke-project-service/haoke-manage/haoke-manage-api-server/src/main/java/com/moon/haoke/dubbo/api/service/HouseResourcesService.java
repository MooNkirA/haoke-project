package com.moon.haoke.dubbo.api.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.moon.haoke.dubbo.server.api.ApiHouseResourcesService;
import com.moon.haoke.dubbo.server.pojo.HouseResources;
import org.springframework.stereotype.Service;

/**
 * 房源业务逻辑类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2020-10-4 07:35
 * @description
 */
@Service // 注：此@Service注解为spring框架，将此类由本程spring容器管理
public class HouseResourcesService {

    // 使用dubbo注解，引入远程服务接口
    @Reference(version = "1.0.0")
    private ApiHouseResourcesService apiHouseResourcesService;

    /**
     * 调用新增房源接口
     *
     * @param houseResources
     * @return
     */
    public boolean save(HouseResources houseResources) {
        int result = this.apiHouseResourcesService.saveHouseResources(houseResources);
        return result == 1;
    }

}
