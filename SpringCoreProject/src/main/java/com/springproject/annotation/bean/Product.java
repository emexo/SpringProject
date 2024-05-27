package com.emexo.annotation.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Product {
    private static final Logger log = LogManager.getLogger(Product.class);

    private int productId;

    private String productName;

    private String productDesc;

    public Product() {
        this.productId = 1;
        this.productDesc = " Mobile phone";
        this.productName = "iPhone";
    }

    public void getProductDetails(){
        log.info("ProductId: {}, product Name: {}, product description: {}", productId, productName, productDesc);
    }
}
