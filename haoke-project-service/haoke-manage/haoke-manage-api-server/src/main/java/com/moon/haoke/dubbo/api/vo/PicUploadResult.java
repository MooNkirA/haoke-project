package com.moon.haoke.dubbo.api.vo;

import lombok.Data;

/**
 * 图片上传响应结果
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2020-10-4 15:44
 * @description
 */
@Data
public class PicUploadResult {

    // 文件唯一标识
    private String uid;
    // 文件名
    private String name;
    // 状态有：uploading done error removed
    private String status;
    // 服务端响应内容，如：'{"status": "success"}'
    private String response;

}
