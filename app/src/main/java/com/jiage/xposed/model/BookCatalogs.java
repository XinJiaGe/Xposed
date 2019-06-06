package com.jiage.xposed.model;

import java.io.Serializable;
import java.util.List;

/**
 * 作者：李忻佳
 * 日期：2019/6/6
 * 描述：
 */

public class BookCatalogs {
    public List<BookCatalog> result;

    public List<BookCatalog> getResult() {
        return result;
    }

    public void setResult(List<BookCatalog> result) {
        this.result = result;
    }

    public static class BookCatalog implements Serializable {
        public int _id = 0;

        public String add_time;

        public int chapter_level = 0;

        public String chapter_name;

        public int chapter_status = 0;

        public long from_chapter_id = 0L;

        public long from_volume_id = 0L;

        public Integer index;

        public Integer isvip;

        public Integer paymoney = (this.isvip = (this.index = Integer.valueOf(0)).valueOf(0)).valueOf(0);

        public int price_status = 0;

        public int word_num = 0;

        public int get_id() {
            return _id;
        }

        public void set_id(int _id) {
            this._id = _id;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public int getChapter_level() {
            return chapter_level;
        }

        public void setChapter_level(int chapter_level) {
            this.chapter_level = chapter_level;
        }

        public String getChapter_name() {
            return chapter_name;
        }

        public void setChapter_name(String chapter_name) {
            this.chapter_name = chapter_name;
        }

        public int getChapter_status() {
            return chapter_status;
        }

        public void setChapter_status(int chapter_status) {
            this.chapter_status = chapter_status;
        }

        public long getFrom_chapter_id() {
            return from_chapter_id;
        }

        public void setFrom_chapter_id(long from_chapter_id) {
            this.from_chapter_id = from_chapter_id;
        }

        public long getFrom_volume_id() {
            return from_volume_id;
        }

        public void setFrom_volume_id(long from_volume_id) {
            this.from_volume_id = from_volume_id;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public Integer getIsvip() {
            return isvip;
        }

        public void setIsvip(Integer isvip) {
            this.isvip = isvip;
        }

        public Integer getPaymoney() {
            return paymoney;
        }

        public void setPaymoney(Integer paymoney) {
            this.paymoney = paymoney;
        }

        public int getPrice_status() {
            return price_status;
        }

        public void setPrice_status(int price_status) {
            this.price_status = price_status;
        }

        public int getWord_num() {
            return word_num;
        }

        public void setWord_num(int word_num) {
            this.word_num = word_num;
        }
    }
}
