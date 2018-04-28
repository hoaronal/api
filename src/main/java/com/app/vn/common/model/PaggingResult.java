package com.app.vn.common.model;


import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.inject.Named;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

@Named
public class PaggingResult {
    private long firstPage;
    private long lastPage;
    private long totalPage;
    private long totalItem;
    private List itemList;

    public long getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(long firstPage) {
        this.firstPage = firstPage;
    }

    public long getLastPage() {
        return lastPage;
    }

    public void setLastPage(long lastPage) {
        this.lastPage = lastPage;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(long totalItem) {
        this.totalItem = totalItem;
    }

    public List getItemList() {
        return itemList;
    }

    public void setItemList(List itemList) {
        this.itemList = itemList;
    }
}
