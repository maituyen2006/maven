package com.team5solution.Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Supplier {
    private String supplierId;
    private String createdBy;
    private Date createdOn;
    private String company;
    private String address1;
    private String address2;
    private String city;
    private String telephone1;
    private String telephone2;
    private String firstName;
    private String lastName;
    private String email1;
    private String email2;
    private Boolean isBlackList;
    private String blockReason;


//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier")
//    private Set<PurchasesOrder> orderId=new HashSet<>();

//    public Set<PurchasesOrder> getOrder() {
//        return orderId;
//    }
//
//    public void setOrder(Set<PurchasesOrder> order) {
//        this.orderId = order;
//    }

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "guid")
    @Column(name = "SupplierId", nullable = false)
    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    @Basic
    @Column(name = "CreatedBy", nullable = true, length = 50)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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
    @Column(name = "Company", nullable = true, length = 500)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "Address1", nullable = true, length = 500)
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @Basic
    @Column(name = "Address2", nullable = true, length = 500)
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Basic
    @Column(name = "City", nullable = true, length = 50)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
    @Column(name = "Email1", nullable = true, length = 50)
    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    @Basic
    @Column(name = "Email2", nullable = true, length = 50)
    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    @Basic
    @Column(name = "isBlackList", nullable = true)
    public Boolean getBlackList() {
        return isBlackList;
    }

    public void setBlackList(Boolean blackList) {
        isBlackList = blackList;
    }

    @Basic
    @Column(name = "BlockReason", nullable = true, length = 500)
    public String getBlockReason() {
        return blockReason;
    }

    public void setBlockReason(String blockReason) {
        this.blockReason = blockReason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return supplierId == supplier.supplierId &&
                Objects.equals(createdBy, supplier.createdBy) &&
                Objects.equals(createdOn, supplier.createdOn) &&
                Objects.equals(company, supplier.company) &&
                Objects.equals(address1, supplier.address1) &&
                Objects.equals(address2, supplier.address2) &&
                Objects.equals(city, supplier.city) &&
                Objects.equals(telephone1, supplier.telephone1) &&
                Objects.equals(telephone2, supplier.telephone2) &&
                Objects.equals(firstName, supplier.firstName) &&
                Objects.equals(lastName, supplier.lastName) &&
                Objects.equals(email1, supplier.email1) &&
                Objects.equals(email2, supplier.email2) &&
                Objects.equals(isBlackList, supplier.isBlackList) &&
                Objects.equals(blockReason, supplier.blockReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierId, createdBy, createdOn, company, address1, address2, city, telephone1, telephone2, firstName, lastName, email1, email2, isBlackList, blockReason);
    }
}
