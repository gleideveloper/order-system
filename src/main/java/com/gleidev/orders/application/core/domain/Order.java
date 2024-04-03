package com.gleidev.orders.application.core.domain;

public class Order {
    private String id;
    private String status;
    private String description;

    private String orderMessage;

    public Order() {
    }

    public Order(String id, String status, String description, String orderMessage) {
        this.id = id;
        this.status = status;
        this.description = description;
        this.orderMessage = orderMessage;
    }

    public String getOrderMessage() {
        return orderMessage;
    }

    public void setOrderMessage(String orderMessage) {
        this.orderMessage = orderMessage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
