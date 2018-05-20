package com.wang.daoimpl;

import com.wang.dao.DAO;

public class ImageClassDAO implements DAO {

     private ImageClassDAO(){}

    static DAO newImageClassDAO() {
        return new ImageClassDAO();
    }
}
