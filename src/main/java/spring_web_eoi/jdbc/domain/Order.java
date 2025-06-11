package spring_web_eoi.jdbc.domain;

import java.time.LocalDate;
import java.util.Date;

public class Order {
    private int orderCode;
    private LocalDate orderDate;
    private LocalDate expectedDate;
    private LocalDate deliveryDate;
    private String status;
    private String comment;
    private int clientCode;

    public int orderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public LocalDate orderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate expectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(LocalDate expectedDate) {
        this.expectedDate = expectedDate;
    }

    public LocalDate deliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
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
