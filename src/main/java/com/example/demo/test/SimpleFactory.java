package com.example.demo.test;

public class SimpleFactory {
    static IProduct makeProduct(String productName){
        if("ProductA".equals(productName)){
            return new ProductA();
        }else if( "ProductB".equals(productName)){
            return new ProductB();
        }else {
            return null;
        }
    }
}
