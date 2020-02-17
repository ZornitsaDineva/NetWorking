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
import java.net.Socket;

/**
 *
 * @author user
 */
public class TimeClient {
    public static void main(String...arg){
         InputStream is = null;
         OutputStream out = null;
  
        try(Socket socket = new Socket("172.201.131.199", 123)){
            is = socket.getInputStream();
            out = socket.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            PrintWriter pw = new PrintWriter(out, true);
            pw.println("time");//send time command to server
           
            String time = br.readLine();
            System.out.println(time);
            pw.println("end");
          
            br.close();
            pw.close();
            socket.close();
        }catch(IOException io){
            io.printStackTrace();
        }
    }
}
