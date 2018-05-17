package com.wang.dao;

public class ImageTypeDAO implements DAO{
     private ImageTypeDAO() {
    }

    static DAO newImageTypeDAO() {
        return new ImageTypeDAO();
    }

}
