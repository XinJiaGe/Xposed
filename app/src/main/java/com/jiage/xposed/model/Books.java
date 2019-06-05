package com.jiage.xposed.model;

import java.io.Serializable;
import java.util.List;

/**
 * 作者：李忻佳
 * 日期：2019/6/4
 * 描述：
 */

public class Books {
    public List<Book> result;

    public List<Book> rows;

    public static class Book implements Serializable {
        static final long serialVersionUID = -7529465430283206278L;

        public String author_name;

        public String banner_pic = "";

        public String banner_url = "";

        public String book_brief;

        public String book_cover;

        public long book_from_id = -1L;

        public int book_hot_num = -1;

        public int book_id = -1;

        public boolean book_is_action;

        public String book_name = "";

        public int book_position;

        public int book_read_num;

        public String book_shelf_describe = "";

        public String book_shelf_tags = "";

        public String book_shelf_title = "";

        public int book_shelf_type;

        public String book_subtitle;

        public int book_word_num = -1;

        public int category_category;

        public int category_id;

        public String category_name = "";

        public int chapter_count;

        public String chapter_list;

        public String chapter_new_name = "";

        public List<ChapterName> chapters;

        public String content;

        public int has_new = 0;

        public boolean is_delete;

        public int is_expire;

        public int is_recommend;

        public int jump_id;

        public int last_chapter;

        public String last_name;

        public long last_uptime;

        public long read_time = 0L;

        public int source_id;

        public int source_status;

        public int type_id;

        public int update_time = 0;

        public int weight;


        public static long getSerialVersionUID() {
            return serialVersionUID;
        }

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

        public long getBook_from_id() {
            return book_from_id;
        }

        public void setBook_from_id(long book_from_id) {
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

        public List<ChapterName> getChapters() {
            return chapters;
        }

        public void setChapters(List<ChapterName> chapters) {
            this.chapters = chapters;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
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

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public long getLast_uptime() {
            return last_uptime;
        }

        public void setLast_uptime(long last_uptime) {
            this.last_uptime = last_uptime;
        }

        public long getRead_time() {
            return read_time;
        }

        public void setRead_time(long read_time) {
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

        public Object getXBannerUrl() { return this.banner_pic; }

        public int hashCode() { return this.book_id; }
    }

    public class ChapterName implements Serializable {
        public int _id;

        public String chapter_name;
    }

    public class ShuJiaRecommendBook extends Book {}

    public List<Book> getResult() {
        return result;
    }

    public void setResult(List<Book> result) {
        this.result = result;
    }

    public List<Book> getRows() {
        return rows;
    }

    public void setRows(List<Book> rows) {
        this.rows = rows;
    }
}
