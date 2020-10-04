package com.moon.haoke.dubbo.server.service.impl;

import com.moon.haoke.dubbo.server.pojo.HouseResources;
import com.moon.haoke.dubbo.server.service.HouseResourcesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 房源业务层实现
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2020-10-4 06:40
 * @description
 */
@Service // 注意：此@Service注解为spring框架的，此类由本工程的spring容器管理
@Transactional // 开启事务
public class HouseResourcesServiceImpl extends BaseServiceImpl<HouseResources> implements HouseResourcesService {

    /**
     * 新增房源
     *
     * @param houseResources
     * @return -1:输入的参数不符合要求，0：数据插入数据库失败，1：成功
     */
    @Override
    public int saveHouseResources(HouseResources houseResources) {
        // 此处模拟一些业务逻辑校验，校验不通过，则返回-1
        if (StringUtils.isBlank(houseResources.getTitle())) {
            return -1;
        }
        // 其他的业务逻辑处理....

        // 调用基础业务类BaseServiceImpl中定义的方法，保存数据，并返回
        return super.save(houseResources);
    }

}
