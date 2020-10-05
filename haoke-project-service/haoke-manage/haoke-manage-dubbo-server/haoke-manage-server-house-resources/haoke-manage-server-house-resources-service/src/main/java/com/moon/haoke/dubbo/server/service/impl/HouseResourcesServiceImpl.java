package com.moon.haoke.dubbo.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.moon.haoke.dubbo.server.pojo.HouseResources;
import com.moon.haoke.dubbo.server.service.HouseResourcesService;
import com.moon.haoke.dubbo.server.vo.PageInfo;
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
        // 创建条件查询器
        QueryWrapper<HouseResources> queryWrapper = new QueryWrapper<>();
        // 设置根据数据的更新时间倒序排序
        queryWrapper.orderByDesc("updated");

        // 调用条件分页查询方法
        IPage<HouseResources> iPage = super.queryPageList(queryWrapper, page, pageSize);

        // 创建返回分页结果对象
        PageInfo<HouseResources> pageInfo = new PageInfo<>();
        pageInfo.setPageNum(page);
        pageInfo.setPageSize(pageSize);
        pageInfo.setRecords(iPage.getRecords());
        pageInfo.setTotal(Integer.parseInt(String.valueOf(iPage.getTotal())));

        return pageInfo;
    }

}
