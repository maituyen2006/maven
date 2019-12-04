package com.team5solution.Responses;

import com.team5solution.Ultilities.Pager;

import java.util.List;

public class ResponsePager {

    private Pager pager;
    private List items;

    public ResponsePager(Pager pager, List items) {
        this.pager = pager;
        this.items = items;
    }

    public ResponsePager() {
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }
}
