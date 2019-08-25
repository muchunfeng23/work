package com.yl.work.common;

import java.io.Serializable;

public class ParentParamDto implements Serializable {
    private static final long serialVersionUID = -6671201512141600025L;
    private static final Integer DEFAULT_PAGE_NUM = 1;
    private static final Integer DEFAULT_PAGE_SIZE = 5;
    protected Integer pageNumber;
    protected Integer pageSize;
    private int pages;

    public ParentParamDto() {
    }

    public Integer getPageNumber() {
        return this.pageNumber != null && this.pageNumber >= 1 ? this.pageNumber : DEFAULT_PAGE_NUM;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return this.pageSize != null && this.pageSize >= 1 ? this.pageSize : DEFAULT_PAGE_SIZE;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
        return this.pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
