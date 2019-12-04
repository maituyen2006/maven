package com.team5solution.Responses;

import java.io.Serializable;
import java.util.Date;

public class ResponseAuth implements Serializable {

    private String username;
    private String fullname;
    private Boolean role;
    private String id;
    private String token;
    private Date expiredDate;

    public ResponseAuth(String username, String token, Date expiredDate) {
        this.username = username;
        this.token = token;
        this.expiredDate = expiredDate;
    }

    public ResponseAuth() {

    }

    public Boolean getRole() {
        return role;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }
}
