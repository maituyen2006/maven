package com.team5solution.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.Valid;
import java.sql.Date;
import java.util.*;

@Entity
@Table(name = "SalesOrder")
public class SalesOrder {
    private String orderId;
    private String createdBy;
    private Date createdOn;
    private Integer itemsQuantity;
    private Double itemsTotalPrice;
    private String description;
    private String size;
    private String material;

    private Account accountId;

    private SalesOrderDetail detailId;

//    private List<Product> products;

    private List<SalesOrderItem> items;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderId")
    public List<SalesOrderItem> getItems() {
        return items;
    }

    public void setItems(List<SalesOrderItem> items) {
        this.items = items;
    }

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "items")
//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Detail_Id")
    public SalesOrderDetail getDetailId() {
        return detailId;
    }
    public void setDetailId(SalesOrderDetail detailId) {
        this.detailId = detailId;
    }



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Account_Id")
    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "guid")
    @Column(name = "OrderId", nullable = false)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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
    @Column(name = "ItemsQuantity", nullable = true)
    public Integer getItemsQuantity() {
        return itemsQuantity;
    }

    public void setItemsQuantity(Integer itemsQuantity) {
        this.itemsQuantity = itemsQuantity;
    }

    @Basic
    @Column(name = "ItemsTotalPrice", nullable = true, precision = 0)
    public Double getItemsTotalPrice() {
        return itemsTotalPrice;
    }

    public void setItemsTotalPrice(Double itemsTotalPrice) {
        this.itemsTotalPrice = itemsTotalPrice;
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
    @Column(name = "Size", nullable = true, length = 50)
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Basic
    @Column(name = "Material", nullable = true, length = 50)
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesOrder that = (SalesOrder) o;
        return orderId == that.orderId &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(createdOn, that.createdOn) &&
                Objects.equals(itemsQuantity, that.itemsQuantity) &&
                Objects.equals(itemsTotalPrice, that.itemsTotalPrice) &&
                Objects.equals(description, that.description) &&
                Objects.equals(size, that.size) &&
                Objects.equals(material, that.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, createdBy, createdOn, itemsQuantity, itemsTotalPrice, description, size, material);
    }
}
