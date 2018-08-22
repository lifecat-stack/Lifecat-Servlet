package com.ten.service.impl;

import com.ten.bean.entity.ImageDO;
import com.ten.service.ImageClassQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 图片分类查询
 *
 * @date 2018/5/24
 * @auther ten
 */
public class ImageClassQueryServiceImpl implements ImageClassQueryService {
    private Logger logger = LoggerFactory.getLogger(ImageClassQueryServiceImpl.class);

    public ImageClassQueryServiceImpl() {
    }

    @Override
    public ServiceResult execute(HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }

    @Override
    public List<ImageDO> queryImageByClass(int userId, int classId) {
        return null;
    }
}
