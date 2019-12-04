package com.team5solution.Ultilities;

public class Pager {
    private int displayPerPage = 1;
    private Integer currentPage;
    private int totalResult = 0;
    private String orderColumn = "";
    private String keyword = "";
    private boolean asc = true;

    public Pager() {
    }

    public int getDisplayPerPage() {
        return displayPerPage;
    }

    public void setDisplayPerPage(int displayPerPage) {
        this.displayPerPage = displayPerPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(Integer totalResult) {
        this.totalResult = totalResult;
    }

    public boolean getAsc() {
        return asc;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }

    public String getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    public int getTotalPage() {
        return totalResult % displayPerPage > 0 ? totalResult / displayPerPage + 1 : totalResult / displayPerPage;
    }

    public int getFirstResult() {
        return (currentPage - 1) * displayPerPage;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
