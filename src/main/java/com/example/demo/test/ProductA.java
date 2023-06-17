package com.example.demo.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductA implements IProduct{
    @Override
    public void doSomeThing() {
        log.debug("我是： productA");
    }
}
