package com.jiage.xposed.model;

import java.io.Serializable;
import java.util.List;

/**
 * 作者：李忻佳
 * 日期：2019/6/4
 * 描述：
 */

public class BookCatalogs {
    public List<BookCatalog> result;

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
    }
}
