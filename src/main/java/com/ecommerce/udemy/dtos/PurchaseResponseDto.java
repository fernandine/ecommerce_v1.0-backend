package com.ecommerce.udemy.dtos;

public class PurchaseResponseDto {
    private String orderTrackingNumber;

    public PurchaseResponseDto(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }

    public void setOrderTrackingNumber(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }
}