package com.moon.haoke.dubbo.server.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.moon.haoke.dubbo.server.pojo.HouseResources;
import com.moon.haoke.dubbo.server.service.HouseResourcesService;
import com.moon.haoke.dubbo.server.vo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 房源的dubbo服务接口具体实现类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2020-10-4 06:55
 * @description
 */
// 此@Service注解为dubbo框架提供的，标识此类这是dubbo服务，对外进行暴露的具体实现
@Service(version = "1.0.0")
public class ApiHouseResourcesServiceImpl implements ApiHouseResourcesService {

    // 注入本工程的spring容器的管理的房源业务接口
    @Autowired
    private HouseResourcesService houseResourcesService;

    /**
     * 新增房源
     *
     * @param houseResources 房源对象
     * @return 操作结果标识
     */
    @Override
    public int saveHouseResources(HouseResources houseResources) {
        return houseResourcesService.saveHouseResources(houseResources);
    }

    /**
     * 分页查询房源列表
     *
     * @param page           当前页
     * @param pageSize       每页大小
     * @param queryCondition 查询条件
     * @return
     */
    @Override
    public PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize, HouseResources queryCondition) {
        return this.houseResourcesService.queryHouseResourcesList(page, pageSize, queryCondition);
    }

}
