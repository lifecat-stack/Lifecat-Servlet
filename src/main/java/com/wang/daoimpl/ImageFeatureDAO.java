package com.wang.daoimpl;

import com.wang.dao.DAO;

public class ImageFeatureDAO implements DAO {
    private ImageFeatureDAO() {
    }

    static DAO newImageFeatureDAO() {
        return new ImageFeatureDAO();
    }
}
