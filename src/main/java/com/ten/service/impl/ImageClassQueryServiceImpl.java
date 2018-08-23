package com.ten.service.impl;

import com.ten.bean.entity.ImageDO;
import com.ten.bean.vo.AlbumClassVO;
import com.ten.bean.vo.ImageVO;
import com.ten.constant.Page;
import com.ten.service.ImageClassQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 图片分类查询
 *
 * TODO 模拟查询，使用项目中现有图片
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
        int userId = Integer.parseInt(req.getParameter("userId"));

        String mockUrl = "http://localhost:8080/lifecatweb/pics/";

        List<AlbumClassVO> albumClassList = new ArrayList<>(3);

        for (int i = 0; i < 3; i++) {
            AlbumClassVO albumClassVO = new AlbumClassVO(userId, i);
            for (int j = 0; j < 50; j++) {
                String url = mockUrl + "1" + "/image" + j + ".jpg";
                ImageVO imageVO = new ImageVO(j);
                imageVO.imagePath(url);
                imageVO.imageText("mock image" + j);
                imageVO.imageClassId(i);
                albumClassVO.addImage(imageVO);
            }
            albumClassList.add(albumClassVO);
        }

        req.getSession().setAttribute("AlbumClassList", albumClassList);
        return new ServiceResult.Builder(true).page(Page.PAGE_USERHOME).build();
    }

    @Override
    public List<ImageDO> queryImageByClass(int userId, int classId) {
        return null;
    }
}
