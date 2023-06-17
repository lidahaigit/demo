package com.example.demo.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductB implements IProduct {
    @Override
    public void doSomeThing() {
    log.info("我是 ProductB");
    }
}

