package com.jiage.xposed.model;

import java.io.Serializable;
import java.util.List;

/**
 * 作者：李忻佳
 * 日期：2019/6/5
 * 描述：
 */

public class Book implements Serializable{

    /**
     * author_name : 月下吟
     * banner_pic :
     * banner_url :
     * book_brief : 超级兵王秦渊，卸甲归田重回都市，将当年的谜题一一解开！曾经扬名世界的兵王，让所有人为之折服！
     * book_cover : http://zr-pic-cdn.zrjhwenhua.com/bookcover/20190310/2aa3a00a3e9b3ed4b9ac60977b025df0.jpg
     * book_from_id : 205848639
     * book_hot_num : 0
     * book_id : 14354
     * book_is_action : true
     * book_name : 近身兵王
     * book_position : 0
     * book_read_num : 86798
     * book_shelf_describe :
     * book_shelf_tags :
     * book_shelf_title :
     * book_shelf_type : 0
     * book_subtitle :
     * book_word_num : 8572496
     * category_category : 1
     * category_id : 15
     * category_name : 都市
     * chapter_count : 2560
     * chapter_list : http://zr-cpt-cdn.zrjhwenhua.com/book_4%2F14354%2Flist.txt?OSSAccessKeyId=LTAIGyykPxSXIFXf&Expires=1559720870&Signature=yTtBnLAloEjU4MSM3fNvhr8ZnGM%3D
     * chapter_new_name : 第2559章 轮回
     * chapters : [{"_id":2,"chapter_name":"第1章 男儿泪"},{"_id":3,"chapter_name":"第2章 我是你的女人"}]
     * has_new : 0
     * is_delete : false
     * is_expire : 0
     * is_recommend : 0
     * jump_id : 0
     * last_chapter : 0
     * read_time : 0
     * source_id : 1
     * source_status : 1
     * type_id : 0
     * update_time : 1554779427
     * weight : 0
     * xBannerUrl :
     */

    private String author_name;
    private String banner_pic;
    private String banner_url;
    private String book_brief;
    private String book_cover;
    private int book_from_id;
    private int book_hot_num;
    private int book_id;
    private boolean book_is_action;
    private String book_name;
    private int book_position;
    private int book_read_num;
    private String book_shelf_describe;
    private String book_shelf_tags;
    private String book_shelf_title;
    private int book_shelf_type;
    private String book_subtitle;
    private int book_word_num;
    private int category_category;
    private int category_id;
    private String category_name;
    private int chapter_count;
    private String chapter_list;
    private String chapter_new_name;
    private int has_new;
    private boolean is_delete;
    private int is_expire;
    private int is_recommend;
    private int jump_id;
    private int last_chapter;
    private int read_time;
    private int source_id;
    private int source_status;
    private int type_id;
    private int update_time;
    private int weight;
    private String xBannerUrl;
    private List<ChaptersBean> chapters;

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getBanner_pic() {
        return banner_pic;
    }

    public void setBanner_pic(String banner_pic) {
        this.banner_pic = banner_pic;
    }

    public String getBanner_url() {
        return banner_url;
    }

    public void setBanner_url(String banner_url) {
        this.banner_url = banner_url;
    }

    public String getBook_brief() {
        return book_brief;
    }

    public void setBook_brief(String book_brief) {
        this.book_brief = book_brief;
    }

    public String getBook_cover() {
        return book_cover;
    }

    public void setBook_cover(String book_cover) {
        this.book_cover = book_cover;
    }

    public int getBook_from_id() {
        return book_from_id;
    }

    public void setBook_from_id(int book_from_id) {
        this.book_from_id = book_from_id;
    }

    public int getBook_hot_num() {
        return book_hot_num;
    }

    public void setBook_hot_num(int book_hot_num) {
        this.book_hot_num = book_hot_num;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public boolean isBook_is_action() {
        return book_is_action;
    }

    public void setBook_is_action(boolean book_is_action) {
        this.book_is_action = book_is_action;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public int getBook_position() {
        return book_position;
    }

    public void setBook_position(int book_position) {
        this.book_position = book_position;
    }

    public int getBook_read_num() {
        return book_read_num;
    }

    public void setBook_read_num(int book_read_num) {
        this.book_read_num = book_read_num;
    }

    public String getBook_shelf_describe() {
        return book_shelf_describe;
    }

    public void setBook_shelf_describe(String book_shelf_describe) {
        this.book_shelf_describe = book_shelf_describe;
    }

    public String getBook_shelf_tags() {
        return book_shelf_tags;
    }

    public void setBook_shelf_tags(String book_shelf_tags) {
        this.book_shelf_tags = book_shelf_tags;
    }

    public String getBook_shelf_title() {
        return book_shelf_title;
    }

    public void setBook_shelf_title(String book_shelf_title) {
        this.book_shelf_title = book_shelf_title;
    }

    public int getBook_shelf_type() {
        return book_shelf_type;
    }

    public void setBook_shelf_type(int book_shelf_type) {
        this.book_shelf_type = book_shelf_type;
    }

    public String getBook_subtitle() {
        return book_subtitle;
    }

    public void setBook_subtitle(String book_subtitle) {
        this.book_subtitle = book_subtitle;
    }

    public int getBook_word_num() {
        return book_word_num;
    }

    public void setBook_word_num(int book_word_num) {
        this.book_word_num = book_word_num;
    }

    public int getCategory_category() {
        return category_category;
    }

    public void setCategory_category(int category_category) {
        this.category_category = category_category;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getChapter_count() {
        return chapter_count;
    }

    public void setChapter_count(int chapter_count) {
        this.chapter_count = chapter_count;
    }

    public String getChapter_list() {
        return chapter_list;
    }

    public void setChapter_list(String chapter_list) {
        this.chapter_list = chapter_list;
    }

    public String getChapter_new_name() {
        return chapter_new_name;
    }

    public void setChapter_new_name(String chapter_new_name) {
        this.chapter_new_name = chapter_new_name;
    }

    public int getHas_new() {
        return has_new;
    }

    public void setHas_new(int has_new) {
        this.has_new = has_new;
    }

    public boolean isIs_delete() {
        return is_delete;
    }

    public void setIs_delete(boolean is_delete) {
        this.is_delete = is_delete;
    }

    public int getIs_expire() {
        return is_expire;
    }

    public void setIs_expire(int is_expire) {
        this.is_expire = is_expire;
    }

    public int getIs_recommend() {
        return is_recommend;
    }

    public void setIs_recommend(int is_recommend) {
        this.is_recommend = is_recommend;
    }

    public int getJump_id() {
        return jump_id;
    }

    public void setJump_id(int jump_id) {
        this.jump_id = jump_id;
    }

    public int getLast_chapter() {
        return last_chapter;
    }

    public void setLast_chapter(int last_chapter) {
        this.last_chapter = last_chapter;
    }

    public int getRead_time() {
        return read_time;
    }

    public void setRead_time(int read_time) {
        this.read_time = read_time;
    }

    public int getSource_id() {
        return source_id;
    }

    public void setSource_id(int source_id) {
        this.source_id = source_id;
    }

    public int getSource_status() {
        return source_status;
    }

    public void setSource_status(int source_status) {
        this.source_status = source_status;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(int update_time) {
        this.update_time = update_time;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getXBannerUrl() {
        return xBannerUrl;
    }

    public void setXBannerUrl(String xBannerUrl) {
        this.xBannerUrl = xBannerUrl;
    }

    public List<ChaptersBean> getChapters() {
        return chapters;
    }

    public void setChapters(List<ChaptersBean> chapters) {
        this.chapters = chapters;
    }

    public static class ChaptersBean  implements Serializable{
        /**
         * _id : 2
         * chapter_name : 第1章 男儿泪
         */

        private int _id;
        private String chapter_name;

        public int get_id() {
            return _id;
        }

        public void set_id(int _id) {
            this._id = _id;
        }

        public String getChapter_name() {
            return chapter_name;
        }

        public void setChapter_name(String chapter_name) {
            this.chapter_name = chapter_name;
        }
    }
}
