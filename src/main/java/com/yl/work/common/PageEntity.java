package com.yl.work.common;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.List;

public class PageEntity<T> implements Serializable {
    private static final long serialVersionUID = 5078490633100501436L;
    private Long total;
    private List<T> list;
    private int pageNum;
    private int pageSize;
    private int pages;
    private int size;

    public PageEntity(List<T> list) {
        if (list instanceof Page) {
            Page<T> page = (Page)list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.total = page.getTotal();
            this.pages = page.getPages();
            this.list = page;
            this.size = page.size();
        }

    }

    public Long getTotal() {
        return this.total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return this.list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
        return this.pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

