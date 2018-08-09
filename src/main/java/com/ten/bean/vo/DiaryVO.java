package com.ten.bean.vo;

/**
 * DTO :Diary图片对象
 * <p>
 * 构建了可变属性集，默认{名称,文本,日期}
 * 实现comparable接口，可根据上传日期date进行排序
 * 覆盖equals() hashCode()
 *
 * @auther ten
 */
public class DiaryVO implements Comparable<DiaryVO> {

    private Integer diaryId;
    private String diaryName;
    private String diaryText;
    private String diaryDate;

    /**
     * hashCode缓存
     */
    private volatile int hashCode;

    public DiaryVO(Integer diaryId, String diaryName, String diaryText, String diaryDate) {
        this.diaryId = diaryId;
        this.diaryName = diaryName;
        this.diaryText = diaryText;
        this.diaryDate = diaryDate;
    }

    /**
     * compareTo: Comparable
     * <p>
     * 根据diaryDate进行比较
     * <p>
     * 时间最近的更大
     * <p>
     * 1. 小于 负数
     * 2. 等于 零
     * 3. 大于 正数
     *
     * @param diary diary
     * @return this-other ? 负 : (this-other ? 0 : 正)
     */
    @Override
    public int compareTo(DiaryVO diary) {
        String date1 = this.diaryDate;
        String date2 = diary.diaryDate;
        for (int i = 0; i < date1.length(); i++) {
            if (date1.charAt(i) > date2.charAt(i)) {
                return 1;
            } else if (date1.charAt(i) < date2.charAt(i)) {
                return -1;
            }
        }
        return 0;
    }


    @Override
    public boolean equals(Object obj) {
        //引用检测
        if (obj == this) {
            return true;
        }
        //类型检测
        if (!(obj instanceof DiaryVO)) {
            return false;
        }
        //参数检测
        if (!this.diaryId.equals(((DiaryVO) obj).getDiaryId())) {
            return false;
        }
        if (!this.diaryName.equals(((DiaryVO) obj).getDiaryName())) {
            return false;
        }
        if (!this.diaryText.equals(((DiaryVO) obj).getDiaryText())) {
            return false;
        }
        if (!this.diaryDate.equals(((DiaryVO) obj).getDiaryDate())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 17;
            result = 31 * result + diaryId;
            result = 31 * result + diaryName.hashCode();
            result = 31 * result + diaryText.hashCode();
            result = 31 * result + diaryDate.hashCode();
            hashCode = result;
        }
        return result;
    }

    /**
     * Diary@1234{name:'',text:'',date:''}
     */
    @Override
    public String toString() {
        return "Diary@" + diaryId + "{name:" + diaryName + ",text:"
                + diaryText + ",date:" + diaryDate + "}";
    }

    /**
     * getter
     */
    public Integer getDiaryId() {
        return diaryId;
    }

    public String getDiaryName() {
        return diaryName;
    }

    public String getDiaryText() {
        return diaryText;
    }

    public String getDiaryDate() {
        return diaryDate;
    }

}
