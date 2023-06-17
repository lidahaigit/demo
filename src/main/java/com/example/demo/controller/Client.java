package com.example.demo.controller;

import org.springframework.aop.ThrowsAdvice;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    private Socket socket;

    public Client(){

        try {
            System.out.println("正在连接服务器端");
            socket = new Socket("localhost",8088);
            System.out.println("与服务器建立了连接“");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void start(){
        ServerHandler handler = new ServerHandler();
        Thread t = new Thread(handler);
        t.setDaemon(true);
        t.start();

        try {
            OutputStream outputStream = socket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter,true);


            Scanner scanner = new Scanner(System.in);
            while (true){
                String line = scanner.nextLine();
                if("exit".equals(line)){
                  break;
                }
                printWriter.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {
        Client client = new Client();
        //Socket socket = client.socket;
        client.start();
    }




    private class ServerHandler implements Runnable{

        @Override
        public void run() {
            try {
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader bf = new BufferedReader(isr);
                String message ;
                while ((message= bf.readLine())!=null){
                    System.out.println(message);
                    System.out.println(message);
                    System.out.println(message);
                    System.out.println(message);
                    System.out.println(message);
                    System.out.println(message);
                    System.out.println(message);
                    System.out.println(message);
                    System.out.println(message);
                    System.out.println(message);
                    System.out.println(message);
                    System.out.println(message+"顶顶顶顶");
                    System.out.println(message+"顶serererere");
                    System.out.println(message+"顶冲突冲突冲突");
                    System.out.println(message+"顶冲突冲突冲突");
                    System.out.println(message+"顶冲突冲突冲突");
                    System.out.println(message+"顶冲突冲突冲突");
                    System.out.println(message+"顶冲突冲突冲突");
                    System.out.println(message+"顶冲突冲突冲突");
                    System.out.println(message+"顶冲突冲突冲突");
                    System.out.println(message+"push冲突冲突");
                    System.out.println(message+"push冲突冲突");
                    System.out.println(message+"push冲突冲突");
                    System.out.println(message+"push冲突冲突");
                    System.out.println(message+"push冲突冲突");
                    System.out.println(message+"push冲突冲突");
                    System.out.println(message+"push冲突冲突");
                    System.out.println(message+"push冲突冲突");
                    System.out.println(message+"push冲突冲突");

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
