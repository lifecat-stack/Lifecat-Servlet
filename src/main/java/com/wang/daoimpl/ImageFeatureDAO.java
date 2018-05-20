package com.wang.daoimpl;

public class ImageFeatureDAO implements DAO {
    private ImageFeatureDAO() {
    }

    static DAO newImageFeatureDAO() {
        return new ImageFeatureDAO();
    }
}
