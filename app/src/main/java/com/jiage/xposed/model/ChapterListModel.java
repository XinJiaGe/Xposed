package com.jiage.xposed.model;

/**
 * 作者：李忻佳
 * 日期：2019/6/5
 * 描述：
 */

public class ChapterListModel {
    /**
     * _id : 1
     * from_volume_id : 215698140
     * from_chapter_id : 215698140
     * chapter_name : 第一卷
     * add_time :
     * word_num : 0
     * price_status : 0
     * chapter_status : 1
     * chapter_level : 1
     */

    private int _id;
    private int from_volume_id;
    private int from_chapter_id;
    private String chapter_name;
    private String add_time;
    private int word_num;
    private int price_status;
    private int chapter_status;
    private int chapter_level;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getFrom_volume_id() {
        return from_volume_id;
    }

    public void setFrom_volume_id(int from_volume_id) {
        this.from_volume_id = from_volume_id;
    }

    public int getFrom_chapter_id() {
        return from_chapter_id;
    }

    public void setFrom_chapter_id(int from_chapter_id) {
        this.from_chapter_id = from_chapter_id;
    }

    public String getChapter_name() {
        return chapter_name;
    }

    public void setChapter_name(String chapter_name) {
        this.chapter_name = chapter_name;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public int getWord_num() {
        return word_num;
    }

    public void setWord_num(int word_num) {
        this.word_num = word_num;
    }

    public int getPrice_status() {
        return price_status;
    }

    public void setPrice_status(int price_status) {
        this.price_status = price_status;
    }

    public int getChapter_status() {
        return chapter_status;
    }

    public void setChapter_status(int chapter_status) {
        this.chapter_status = chapter_status;
    }

    public int getChapter_level() {
        return chapter_level;
    }

    public void setChapter_level(int chapter_level) {
        this.chapter_level = chapter_level;
    }
}
