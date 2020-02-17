/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itstep.networking.timeservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;

/**
 *
 * @author user
 */
public class TimeServerActivity extends Thread{
    private PrintWriter pw;
    private BufferedReader br;
    
    public TimeServerActivity(PrintWriter pw, BufferedReader br){
        this.pw = pw;
        this.br = br;
    }
    
    @Override
    public void run(){
        try{
        String  line = br.readLine();//read by client
        System.out.println("Request by client "+ line);
        while(!line.equalsIgnoreCase("end")){
                String date = new Date().toString();
                pw.println("answer is "+date);
                line = br.readLine();
              
        }
        System.out.println("Client disconected!");
        pw.close();
        br.close();
        
        }catch(IOException io){
            io.printStackTrace();
        }
    }
}
