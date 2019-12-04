package com.team5solution.Entities;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SalesOrderItem")
public class SalesOrderItem {
    private String itemId;
    private String itemQuantity;
    private String itemName;
    private String size;
    private String color;

    private Product productId;

    private SalesOrder orderId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "OrderId", referencedColumnName = "OrderId")
    public SalesOrder getOrderId() {
        return this.orderId;
    }

    public void setOrderId(SalesOrder orderId) {
        this.orderId = orderId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ProductId")
    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }


    @Column(name = "ItemQuantity")
    public String getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    @Column(name = "ItemName", length = 50)
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Column(name = "Size", length = 50)
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Column(name = "Color", length = 50)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @GeneratedValue(generator = "generate")
    @GenericGenerator(name = "generate", strategy = "guid")
    @Id
    @Column(name = "ItemId", nullable = false)
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof SalesOrderItem)) return false;
//        SalesOrderItem that = (SalesOrderItem) o;
//        return Objects.equals(getItemId(), that.getItemId()) &&
//                Objects.equals(getItemQuantity(), that.getItemQuantity()) &&
//                Objects.equals(getItemName(), that.getItemName()) &&
//                Objects.equals(getSize(), that.getSize()) &&
//                Objects.equals(getColor(), that.getColor()) &&
//                Objects.equals(getProductId(), that.getProductId()) &&
//                Objects.equals(getOrderId(), that.getOrderId());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getItemId(), getItemQuantity(), getItemName(), getSize(), getColor(), getProductId(), getOrderId());
//    }
}
