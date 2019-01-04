package com.ten.lifecat.servlet.service;

import com.ten.lifecat.servlet.service.util.Service;
import com.ten.service.util.Service;

public interface DiaryAllDeleteService extends Service {

    void deleteAllDiary(int userId);
}
