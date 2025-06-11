package spring_web_eoi.jdbc.domain;

import java.util.Date;

public class Order {
    private int orderCode;
    private Date orderDate;
    private Date expectedDate;
    private Date deliveryDate;
    private String status;
    private String comment;
    private int clientCode;

    public int orderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public Date orderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date expectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    public Date deliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String status() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String comment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int clientCode() {
        return clientCode;
    }

    public void setClientCode(int clientCode) {
        this.clientCode = clientCode;
    }
}
