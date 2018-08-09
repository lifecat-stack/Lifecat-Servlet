package com.ten.service;

import com.ten.bean.entity.ImageDO;
import com.ten.service.util.Service;

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
