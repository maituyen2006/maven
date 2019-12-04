package com.team5solution.Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Account {
    private String accountId;
    private Boolean role;
    private String username;
    private String password;
    private Date createdOn;
    private String firstName;
    private String lastName;
    private Integer age;
    private Boolean gender;
    private String email;
    private String telephone1;
    private String telephone2;
    private String address1;
    private String address2;
    private String company;
    private String avatar;
    private String description;
    private Boolean isActive;
    private Boolean isDeleted;
    private String cartJson;

    @Column(name = "CartJson")
    public String getCartJson() {
        return cartJson;
    }

    public void setCartJson(String cartJson) {
        this.cartJson = cartJson;
    }

    private List<SalesOrder> orders;

    private List<SalesOrderDetail> details;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "accountId")
    public List<SalesOrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<SalesOrderDetail> details) {
        this.details = details;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "accountId")
    public List<SalesOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<SalesOrder> orders) {
        this.orders = orders;
    }






    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "guid")
    @Column(name = "Account_Id", nullable = false)
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "Role")
    public Boolean getRole() {
        return role;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }

    @Basic
    @Column(name = "Username", nullable = true, length = 16)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "Password", nullable = true, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "CreatedOn", nullable = true)
    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Basic
    @Column(name = "FirstName", nullable = true, length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LastName", nullable = true, length = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "Age", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "Gender", nullable = true)
    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "Email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Telephone1", nullable = true, length = 10)
    public String getTelephone1() {
        return telephone1;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    @Basic
    @Column(name = "Telephone2", nullable = true, length = 10)
    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    @Basic
    @Column(name = "Address1", nullable = true, length = 2147483647)
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @Basic
    @Column(name = "Address2", nullable = true, length = 2147483647)
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Basic
    @Column(name = "Company", nullable = true, length = 50)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "Avatar", nullable = true, length = 2147483647)
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "Description", nullable = true, length = 2147483647)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "isActive", nullable = true)
    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Basic
    @Column(name = "isDeleted", nullable = true)
    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountId == account.accountId &&
                Objects.equals(role, account.role) &&
                Objects.equals(username, account.username) &&
                Objects.equals(password, account.password) &&
                Objects.equals(createdOn, account.createdOn) &&
                Objects.equals(firstName, account.firstName) &&
                Objects.equals(lastName, account.lastName) &&
                Objects.equals(age, account.age) &&
                Objects.equals(gender, account.gender) &&
                Objects.equals(email, account.email) &&
                Objects.equals(telephone1, account.telephone1) &&
                Objects.equals(telephone2, account.telephone2) &&
                Objects.equals(address1, account.address1) &&
                Objects.equals(address2, account.address2) &&
                Objects.equals(company, account.company) &&
                Objects.equals(avatar, account.avatar) &&
                Objects.equals(description, account.description) &&
                Objects.equals(isActive, account.isActive) &&
                Objects.equals(isDeleted, account.isDeleted);
    }


    @Override
    public int hashCode() {
        return Objects.hash(accountId, role, username, password, createdOn, firstName, lastName, age, gender, email, telephone1, telephone2, address1, address2, company, avatar, description, isActive, isDeleted);
    }
}
