package com.moon.haoke.dubbo.api.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.moon.haoke.dubbo.api.vo.Pagination;
import com.moon.haoke.dubbo.api.vo.TableResult;
import com.moon.haoke.dubbo.server.api.ApiHouseResourcesService;
import com.moon.haoke.dubbo.server.pojo.HouseResources;
import com.moon.haoke.dubbo.server.vo.PageInfo;
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

    /**
     * 查询房源分页列表
     *
     * @param houseResources 查询条件
     * @param currentPage    当前页
     * @param pageSize       每页大小
     * @return 查询列表结果
     */
    public TableResult<HouseResources> queryList(HouseResources houseResources, Integer currentPage, Integer pageSize) {
        // 调用房源dubbo服务提供的接口，查询分页列表数据
        PageInfo<HouseResources> pageInfo = this.apiHouseResourcesService.queryHouseResourcesList(currentPage, pageSize, houseResources);

        // 创建分页信息对象
        Pagination pagination = new Pagination();
        pagination.setCurrent(currentPage);
        pagination.setPageSize(pageSize);
        pagination.setTotal(pageInfo.getTotal());

        // 创建返回列表对象
        TableResult<HouseResources> tableResult = new TableResult<>();
        tableResult.setList(pageInfo.getRecords());
        tableResult.setPagination(pagination);

        return tableResult;
    }
}
