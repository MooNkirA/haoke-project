package com.moon.haoke.dubbo.api.controller;

import com.moon.haoke.dubbo.api.service.PicUploadFileSystemService;
import com.moon.haoke.dubbo.api.service.PicUploadOSSService;
import com.moon.haoke.dubbo.api.vo.PicUploadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 图片文件上传控制器
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2020-10-4 16:13
 * @description
 */
@RestController
@RequestMapping("pic/upload")
public class PicUploadController {

    // 注入上传阿里云oss服务业务处理类
    @Autowired
    private PicUploadOSSService picUploadOSSService;

    // 注入上传本地文件存储系统业务处理类
    @Autowired
    private PicUploadFileSystemService picUploadFileSystemService;

    /**
     * 上传到本地文件存储系统
     *
     * @param multipartFile
     * @return
     */
    @PostMapping("aliyun")
    public PicUploadResult upload(@RequestParam("file") MultipartFile multipartFile) {
        return this.picUploadOSSService.upload(multipartFile);
    }

    /**
     * 上传到本地存储
     *
     * @param multipartFile
     * @return
     */
    @PostMapping
    public PicUploadResult uploadToLocal(@RequestParam("file") MultipartFile multipartFile) {
        return this.picUploadFileSystemService.upload(multipartFile);
    }

}
