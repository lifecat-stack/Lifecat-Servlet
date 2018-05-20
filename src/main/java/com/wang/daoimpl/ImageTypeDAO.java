package com.wang.daoimpl;

import com.wang.dao.DAO;

public class ImageTypeDAO implements DAO {
     private ImageTypeDAO() {
    }

    static DAO newImageTypeDAO() {
        return new ImageTypeDAO();
    }

}
