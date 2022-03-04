package com.ycshang.web.brand.pojo;

import java.util.List;

/**
 * @program: java-web-learning
 * @description:
 * @author: ycshang
 * @create: 2022-03-04 16:53
 **/
public class PageBean<T> {
    //总记录数
    private int totalCount;
    //当前页数据
    private List<T> rows;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}