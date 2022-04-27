package com.zouquanguo.pojo;

import java.util.List;

public class Page<T> {
    private List<T> PageRows;
    private int totalPage;

    @Override
    public String toString() {
        return "Page{" +
                "PageRows=" + PageRows +
                ", totalPage=" + totalPage +
                '}';
    }

    public List<T> getPageRows() {
        return PageRows;
    }

    public void setPageRows(List<T> pageRows) {
        PageRows = pageRows;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public Page(List<T> pageRows, int totalPage) {
        PageRows = pageRows;
        this.totalPage = totalPage;
    }

    public Page() {
    }
}
