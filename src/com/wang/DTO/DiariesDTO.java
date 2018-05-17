package com.wang.DTO;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO :Diaries集合，用户日记集
 *
 * @auther ten
 */
public class DiariesDTO {
    /**
     * List 引用不可变，值可变
     */
    private final List<DiaryDTO> diaryList;
    private final int userId;

    private DiariesDTO(int userId) {
        this.userId = userId;
        diaryList = new ArrayList<>();
    }

    public static DiariesDTO newDiaries(int userId) {
        return new DiariesDTO(userId);
    }

    /**
     * 向List添加DiaryDTO对象
     *
     * @param diary DiaryDTO对象
     */
    public void addDiary(DiaryDTO diary) {
        diaryList.add(diary);
    }

    /**
     * {@literal 获取List<DiaryDTO>}
     *
     * @return {@literal List<DiaryDTO>}
     */
    public List<DiaryDTO> getDiaryList() {
        return this.diaryList;
    }

    //Diaries@1234{size:size()}
    @Override
    public String toString() {
        return "Diaries@" + userId + "{size:" + diaryList.size() + "}";
    }
}
