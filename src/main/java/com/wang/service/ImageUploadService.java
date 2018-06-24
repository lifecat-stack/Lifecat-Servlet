package com.wang.service;

import com.wang.bean.doo.ImageDO;
import com.wang.service.util.Service;

/**
 * 图片上传
 * <p>
 * 失败 Page.PAGE_UPIMAGE
 * 成功 Page.PAGE_USERHOME
 *
 * @date 2018/5/24
 * @auther ten
 */
public interface ImageUploadService extends Service {
    void uploadImage(ImageDO imageDO);
}
