package com.example.demo.test;

public class Client {
    public static void main(String[] args) {
        IProduct product = SimpleFactory.makeProduct("ProductA");
        product.doSomeThing();
    }
}
