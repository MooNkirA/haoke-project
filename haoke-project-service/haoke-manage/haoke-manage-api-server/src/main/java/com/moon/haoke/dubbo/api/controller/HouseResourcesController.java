package com.moon.haoke.dubbo.api.controller;

import com.moon.haoke.dubbo.api.service.HouseResourcesService;
import com.moon.haoke.dubbo.server.pojo.HouseResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 房源Restful接口
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2020-10-4 07:46
 * @description
 */
@RestController
@RequestMapping("house/resources")
public class HouseResourcesController {

    // 注入业务层
    @Autowired
    private HouseResourcesService houseResourcesService;

    /**
     * 新增房源
     *
     * @param houseResources
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody HouseResources houseResources) {
        try {
            boolean bool = this.houseResourcesService.save(houseResources);
            if (bool) {
                // 返回spring框架提供的ResponseEntity请求响应工具类
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
