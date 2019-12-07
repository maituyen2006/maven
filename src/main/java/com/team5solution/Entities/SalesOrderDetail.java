package com.team5solution.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SalesOrderDetail")
public class SalesOrderDetail {
    private String detailId;
    private Double detailPriceBegin;
    private Double detailAdditionFee;
    private Double detailTotalPrice;
    private String deliveryFirstName;
    private String deliveryLastName;
    private String deliveryPhone;
    private String deliveryEmail;
    private String deliveryProvince;
    private String deliveryDistrict;
    private String deliveryTown;
    private String deliveryStreet;
    private String paymentFirstName;
    private String paymentLastName;
    private String paymentPhone;
    private String paymentEmail;
    private String paymentProvince;
    private String paymentDisctrict;
    private String paymentTown;
    private String paymentStreet;
    private String paymentMethod;
    private String paymentStatus;
    private String note;
    private Notify notifyId;
    private SalesOrder orderId;
    private Account accountId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NotifyId")
    public Notify getNotifyId() {
        return notifyId;
    }

    public void setNotifyId(Notify notifyId) {
        this.notifyId = notifyId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Account_Id")
    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }



    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderId")
    public SalesOrder getOrderId() {
        return orderId;
    }

    public void setOrderId(SalesOrder orderId) {
        this.orderId = orderId;
    }


    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "guid")
    @Column(name = "Detail_Id", nullable = false)
    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    @Basic
    @Column(name = "Detail_PriceBegin", nullable = true, precision = 0)
    public Double getDetailPriceBegin() {
        return detailPriceBegin;
    }

    public void setDetailPriceBegin(Double detailPriceBegin) {
        this.detailPriceBegin = detailPriceBegin;
    }

    @Basic
    @Column(name = "Detail_Addition_Fee", nullable = true, precision = 0)
    public Double getDetailAdditionFee() {
        return detailAdditionFee;
    }

    public void setDetailAdditionFee(Double detailAdditionFee) {
        this.detailAdditionFee = detailAdditionFee;
    }

    @Basic
    @Column(name = "Detail_TotalPrice", nullable = true, precision = 0)
    public Double getDetailTotalPrice() {
        return detailTotalPrice;
    }

    public void setDetailTotalPrice(Double detailTotalPrice) {
        this.detailTotalPrice = detailTotalPrice;
    }

    @Basic
    @Column(name = "Delivery_FirstName", nullable = true, length = 50)
    public String getDeliveryFirstName() {
        return deliveryFirstName;
    }

    public void setDeliveryFirstName(String deliveryFirstName) {
        this.deliveryFirstName = deliveryFirstName;
    }

    @Basic
    @Column(name = "Delivery_LastName", nullable = true, length = 50)
    public String getDeliveryLastName() {
        return deliveryLastName;
    }

    public void setDeliveryLastName(String deliveryLastName) {
        this.deliveryLastName = deliveryLastName;
    }

    @Basic
    @Column(name = "Delivery_Phone", nullable = true, length = 10)
    public String getDeliveryPhone() {
        return deliveryPhone;
    }

    public void setDeliveryPhone(String deliveryPhone) {
        this.deliveryPhone = deliveryPhone;
    }

    @Basic
    @Column(name = "Delivery_Email", nullable = true, length = 50)
    public String getDeliveryEmail() {
        return deliveryEmail;
    }

    public void setDeliveryEmail(String deliveryEmail) {
        this.deliveryEmail = deliveryEmail;
    }

    @Basic
    @Column(name = "Delivery_Province", nullable = true, length = 50)
    public String getDeliveryProvince() {
        return deliveryProvince;
    }

    public void setDeliveryProvince(String deliveryProvince) {
        this.deliveryProvince = deliveryProvince;
    }

    @Basic
    @Column(name = "Delivery_District", nullable = true, length = 50)
    public String getDeliveryDistrict() {
        return deliveryDistrict;
    }

    public void setDeliveryDistrict(String deliveryDistrict) {
        this.deliveryDistrict = deliveryDistrict;
    }

    @Basic
    @Column(name = "Delivery_Town", nullable = true, length = 50)
    public String getDeliveryTown() {
        return deliveryTown;
    }

    public void setDeliveryTown(String deliveryTown) {
        this.deliveryTown = deliveryTown;
    }

    @Basic
    @Column(name = "Delivery_Street", nullable = true, length = 50)
    public String getDeliveryStreet() {
        return deliveryStreet;
    }

    public void setDeliveryStreet(String deliveryStreet) {
        this.deliveryStreet = deliveryStreet;
    }

    @Basic
    @Column(name = "Payment_FirstName", nullable = true, length = 50)
    public String getPaymentFirstName() {
        return paymentFirstName;
    }

    public void setPaymentFirstName(String paymentFirstName) {
        this.paymentFirstName = paymentFirstName;
    }

    @Basic
    @Column(name = "Payment_LastName", nullable = true, length = 50)
    public String getPaymentLastName() {
        return paymentLastName;
    }

    public void setPaymentLastName(String paymentLastName) {
        this.paymentLastName = paymentLastName;
    }

    @Basic
    @Column(name = "Payment_Phone", nullable = true, length = 10)
    public String getPaymentPhone() {
        return paymentPhone;
    }

    public void setPaymentPhone(String paymentPhone) {
        this.paymentPhone = paymentPhone;
    }

    @Basic
    @Column(name = "Payment_Email", nullable = true, length = 50)
    public String getPaymentEmail() {
        return paymentEmail;
    }

    public void setPaymentEmail(String paymentEmail) {
        this.paymentEmail = paymentEmail;
    }

    @Basic
    @Column(name = "Payment_Province", nullable = true, length = 50)
    public String getPaymentProvince() {
        return paymentProvince;
    }

    public void setPaymentProvince(String paymentProvince) {
        this.paymentProvince = paymentProvince;
    }

    @Basic
    @Column(name = "Payment_Disctrict", nullable = true, length = 50)
    public String getPaymentDisctrict() {
        return paymentDisctrict;
    }

    public void setPaymentDisctrict(String paymentDisctrict) {
        this.paymentDisctrict = paymentDisctrict;
    }

    @Basic
    @Column(name = "Payment_Town", nullable = true, length = 50)
    public String getPaymentTown() {
        return paymentTown;
    }

    public void setPaymentTown(String paymentTown) {
        this.paymentTown = paymentTown;
    }

    @Basic
    @Column(name = "Payment_Street", nullable = true, length = 50)
    public String getPaymentStreet() {
        return paymentStreet;
    }

    public void setPaymentStreet(String paymentStreet) {
        this.paymentStreet = paymentStreet;
    }

    @Basic
    @Column(name = "Payment_Method", nullable = true, length = 50)
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Basic
    @Column(name = "Payment_Status", nullable = true, length = 10)
    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Basic
    @Column(name = "Note", nullable = true, length = 2147483647)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesOrderDetail that = (SalesOrderDetail) o;
        return detailId == that.detailId &&
                Objects.equals(detailPriceBegin, that.detailPriceBegin) &&
                Objects.equals(detailAdditionFee, that.detailAdditionFee) &&
                Objects.equals(detailTotalPrice, that.detailTotalPrice) &&
                Objects.equals(deliveryFirstName, that.deliveryFirstName) &&
                Objects.equals(deliveryLastName, that.deliveryLastName) &&
                Objects.equals(deliveryPhone, that.deliveryPhone) &&
                Objects.equals(deliveryEmail, that.deliveryEmail) &&
                Objects.equals(deliveryProvince, that.deliveryProvince) &&
                Objects.equals(deliveryDistrict, that.deliveryDistrict) &&
                Objects.equals(deliveryTown, that.deliveryTown) &&
                Objects.equals(deliveryStreet, that.deliveryStreet) &&
                Objects.equals(paymentFirstName, that.paymentFirstName) &&
                Objects.equals(paymentLastName, that.paymentLastName) &&
                Objects.equals(paymentPhone, that.paymentPhone) &&
                Objects.equals(paymentEmail, that.paymentEmail) &&
                Objects.equals(paymentProvince, that.paymentProvince) &&
                Objects.equals(paymentDisctrict, that.paymentDisctrict) &&
                Objects.equals(paymentTown, that.paymentTown) &&
                Objects.equals(paymentStreet, that.paymentStreet) &&
                Objects.equals(paymentMethod, that.paymentMethod) &&
                Objects.equals(paymentStatus, that.paymentStatus) &&
                Objects.equals(note, that.note) &&
                Objects.equals(notifyId, that.notifyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(detailId, detailPriceBegin, detailAdditionFee, detailTotalPrice, deliveryFirstName, deliveryLastName, deliveryPhone, deliveryEmail, deliveryProvince, deliveryDistrict, deliveryTown, deliveryStreet, paymentFirstName, paymentLastName, paymentPhone, paymentEmail, paymentProvince, paymentDisctrict, paymentTown, paymentStreet, paymentMethod, paymentStatus, note, notifyId);
    }
}
