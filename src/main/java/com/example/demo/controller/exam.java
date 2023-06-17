package com.example.demo.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class exam {
    public static void main(String[] args) throws IOException {
        FileInputStream fis  = new FileInputStream("./mvnw.cmd");
        int len;
        byte[] data = new byte[1024*10];
        long l = System.currentTimeMillis();
        while ((len= fis.read(data))!=-1){



        }
    }


}
