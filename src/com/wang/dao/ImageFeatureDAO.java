package com.wang.dao;

public class ImageFeatureDAO implements DAO {
    private ImageFeatureDAO() {
    }

    static DAO newImageFeatureDAO() {
        return new ImageFeatureDAO();
    }
}
