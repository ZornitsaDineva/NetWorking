/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itstep.networking.timeservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author user
 */
public class ServerManage implements Runnable{
    @Override
    public void run(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("To stop server type exit");
        try{
        String exit = br.readLine();
        if(exit.equalsIgnoreCase("exit")) {
            
            System.out.println("Server is stoping...");
           
            System.exit(0);
        }
        }catch(IOException io){
            io.printStackTrace();
        }
    }
}
