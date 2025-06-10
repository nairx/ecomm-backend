package com.mh.ecomm.controller;

public class OrderRequest {
    private String product;
    private String email;
     private Long qty;
      private Long price;
    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getQty() {
        return qty;
    }
    public void setQty(Long qty) {
        //testing
        this.qty = qty;
    }
    public Long getPrice() {
        return price;
    }
    public void setPrice(Long price) {
        this.price = price;
    }

    // Getters and setters
    
}

