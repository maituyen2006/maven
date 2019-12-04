package com.team5solution.Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Discount {
    private String discountCode;
    private Date createdOn;
    private Date expredDate;
    private String name;
    private String description;
    private Integer value;

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "guid")
    @Column(name = "DiscountCode", nullable = false)
    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
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
    @Column(name = "ExpredDate", nullable = true)
    public Date getExpredDate() {
        return expredDate;
    }

    public void setExpredDate(Date expredDate) {
        this.expredDate = expredDate;
    }

    @Basic
    @Column(name = "Name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "Value", nullable = true)
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount = (Discount) o;
        return discountCode == discount.discountCode &&
                Objects.equals(createdOn, discount.createdOn) &&
                Objects.equals(expredDate, discount.expredDate) &&
                Objects.equals(name, discount.name) &&
                Objects.equals(description, discount.description) &&
                Objects.equals(value, discount.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountCode, createdOn, expredDate, name, description, value);
    }
}
