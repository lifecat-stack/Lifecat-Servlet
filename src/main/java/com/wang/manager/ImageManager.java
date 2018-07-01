package com.wang.manager;
/**
 * Image模块管理器 
 * 
 * @date 2018/6/29 
 * @auther ten
 */
public interface ImageManager  extends Manager{
    /**
     * Image上传到数据库
     * 
     * @param 
     * @throws 
     */
    public void imageUpload();
    /**
     * Image标志位置位删除
     * 
     * @param 
     * @throws 
     */
    public void imageDelete();
    /**
     * Image查询
     * 
     * @param 
     * @throws 
     */
    public void imageQuery();
    /**
     * 
     * 
     * @param 
     * @throws 
     */
    public void imageListQuery();

    public void imageClassQuery();

    public void imageTextUpdate();

    public void imageClassify();
}
