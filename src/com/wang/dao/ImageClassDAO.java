package com.wang.dao;

public class ImageClassDAO implements DAO {

     private ImageClassDAO(){}

    static DAO newImageClassDAO() {
        return new ImageClassDAO();
    }
}
