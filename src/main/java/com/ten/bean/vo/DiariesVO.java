package com.ten.bean.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO :Diaries集合，用户日记集
 *
 * @auther ten
 */
public class DiariesVO {

    private final List<DiaryVO> diaryList;
    private final Integer userId;

    private DiariesVO(int userId) {
        this.userId = userId;
        diaryList = new ArrayList<>();
    }

    public static DiariesVO newDiaries(int userId) {
        return new DiariesVO(userId);
    }

    /**
     * 向List添加DiaryDTO对象
     *
     * @param diary DiaryDTO对象
     */
    public void addDiary(DiaryVO diary) {
        diaryList.add(diary);
    }

    /**
     * {@literal 获取List<DiaryVO>}
     *
     * @return {@literal List<DiaryVO>}
     */
    public List<DiaryVO> getDiaryList() {
        return this.diaryList;
    }

    /**
     * Diaries@1234{size:size()}
     */
    @Override
    public String toString() {
        return "Diaries@" + userId + "{size:" + diaryList.size() + "}";
    }
}
