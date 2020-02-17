/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itstep.networking.timeservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author user
 */
public class TimeServer {

    public static final int PORT_NUMBER = 123;//const 

    public static void main(String... arg) {
        Thread manage = new Thread(new ServerManage(), "ThreadManage");
        manage.start();//start the thread
        try (ServerSocket ss = new ServerSocket()) {

            ss.bind(new InetSocketAddress("127.0.0.1", PORT_NUMBER));
            while(true){
                Socket socket = ss.accept();//listening state
                InputStream is = socket.getInputStream();//read by client
                OutputStream out = socket.getOutputStream();//write to client
                PrintWriter pw = new PrintWriter(out, true);//true makes autoflushable
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                TimeServerActivity tsa = new TimeServerActivity(pw, br);
                Thread clientSocket = new Thread(tsa, "ClientSocket");
                clientSocket.start();
            }//end 
        } catch (IOException io) {
            io.printStackTrace();
        }

    }
}
