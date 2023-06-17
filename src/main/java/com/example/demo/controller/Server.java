package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
@Slf4j
public class Server {
    private ServerSocket serverSocket;
    private List<PrintWriter> allout  = Collections.synchronizedList(new ArrayList<PrintWriter>());

    public  static void main(String[] ar){
        Server server = new Server();
        server.start();
    }





    public Server(){


        try {
            log.debug("正在启动服务端.......");
            serverSocket = new ServerSocket(8088);
            log.debug("服务端启动完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start(){
        try {
            while (true ){
                log.debug("等待客户端的连接");
                Socket socket = serverSocket.accept();
                log.debug("一个客户端连接了");
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread t  = new Thread(clientHandler);
                t.start();

            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    private class ClientHandler implements Runnable{
        private Socket socket;
        private  String host;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            host = socket.getInetAddress().getHostAddress();
        }

        @Override
        public void run() {
            PrintWriter pw =null;
            try {
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);

                OutputStream out = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
                BufferedWriter bw = new BufferedWriter(osw);
                pw = new PrintWriter(bw, true);
                boolean add = allout.add(pw);
                sendMessage(host+"上线了，当前在线人数"+ allout.size());


                String message;
                while ((message=br.readLine())!=null){
                    sendMessage(host +"说"+message);

                }


            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                allout.remove(pw);
                sendMessage(host +"下线了，当前在线人数"+allout.size());
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


        }
    }


    private void sendMessage(String line){
        log.debug(line);
        allout.forEach(p->p.println(line));

    }


}
