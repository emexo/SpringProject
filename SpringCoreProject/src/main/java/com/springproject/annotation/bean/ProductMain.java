package com.emexo.annotation.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.emexo.annotation.bean");

        Product product = context.getBean("product", Product.class);

        product.getProductDetails();
    }
}
