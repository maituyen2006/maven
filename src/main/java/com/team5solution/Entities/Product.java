package com.team5solution.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Product")
public class Product {
    private String productId;
    private String createdBy;
    private Date createdOn;
    private String name;
    private String brand;
    private String image;
    private String size;
    private String material;
    private String origin;
    private Double price;
    private String description;
    private Integer itemOnEquipment;
    private Integer itemInStock;
    private Boolean warehouseStatus;
    private Boolean shopStatus;
    private String comment;
    private Boolean productStatus;
    private String color;
    private String imageDetail;
    private Category categoryId;
//    private Comment comments;
    
    
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ProductId")
//    public Comment getComments() {
//        return comments;
//    }
//
//    public void setComments(Comment comments) {
//        this.comments = comments;
//    }
//    
//    
    
    
//    private SalesOrder orderId;

//    private List<SalesOrderItem> items;
//
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productId")
//    public List<SalesOrderItem> getItems() {
//        return items;
//    }
//
//    public void setItems(List<SalesOrderItem> items) {
//        this.items = items;
//    }

//    @ManyToOne(fetch = FetchType.LAZY)
//    public SalesOrder getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(SalesOrder orderId) {
//        this.orderId = orderId;
//    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CategoryId", referencedColumnName = "CategoryId")
    public Category getCategoryId() {
        return categoryId;
    }


    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "guid")
    @Column(name = "ProductId", nullable = false)
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Column(name = "CreatedBy", nullable = true, length = 50)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "CreatedOn", nullable = true)
    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Column(name = "Name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "Brand", nullable = true, length = 50)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Column(name = "Image", nullable = true, length = 2147483647)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name = "Size", nullable = true, length = 50)
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Column(name = "Material", nullable = true, length = 50)
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Column(name = "Origin", nullable = true, length = 20)
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Column(name = "Price", nullable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Column(name = "Description", nullable = true, length = 2147483647)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "ItemOnEquipment", nullable = true)
    public Integer getItemOnEquipment() {
        return itemOnEquipment;
    }

    public void setItemOnEquipment(Integer itemOnEquipment) {
        this.itemOnEquipment = itemOnEquipment;
    }

    @Column(name = "ItemInStock", nullable = true)
    public Integer getItemInStock() {
        return itemInStock;
    }

    public void setItemInStock(Integer itemInStock) {
        this.itemInStock = itemInStock;
    }

    @Column(name = "WarehouseStatus", nullable = true)
    public Boolean getWarehouseStatus() {
        return warehouseStatus;
    }

    public void setWarehouseStatus(Boolean warehouseStatus) {
        this.warehouseStatus = warehouseStatus;
    }

    @Column(name = "ShopStatus", nullable = true)
    public Boolean getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(Boolean shopStatus) {
        this.shopStatus = shopStatus;
    }

    @Column(name = "comment", nullable = true, length = 500)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @Column(name = "ImageDetail", nullable = true, length = 500)
    public String getImageDetail() {
        return imageDetail;
    }

    public void setImageDetail(String imageDetail) {
        this.imageDetail = imageDetail;
    }


    @Column(name = "Color", length = 50)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Column(name = "ProductStatus")
    public Boolean getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Boolean productStatus) {
        this.productStatus = productStatus;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId &&
                Objects.equals(createdBy, product.createdBy) &&
                Objects.equals(createdOn, product.createdOn) &&
                Objects.equals(name, product.name) &&
                Objects.equals(brand, product.brand) &&
                Objects.equals(image, product.image) &&
                Objects.equals(size, product.size) &&
                Objects.equals(material, product.material) &&
                Objects.equals(origin, product.origin) &&
                Objects.equals(price, product.price) &&
                Objects.equals(description, product.description) &&
                Objects.equals(itemOnEquipment, product.itemOnEquipment) &&
                Objects.equals(itemInStock, product.itemInStock) &&
                Objects.equals(warehouseStatus, product.warehouseStatus) &&
                Objects.equals(shopStatus, product.shopStatus) &&
                Objects.equals(comment, product.comment) &&
                Objects.equals(productStatus, product.productStatus) &&
                Objects.equals(imageDetail, product.imageDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, createdBy, createdOn, name, brand, image, size, material, origin, price, description, itemOnEquipment, itemInStock, warehouseStatus, shopStatus, comment, productStatus, imageDetail);
    }
}
