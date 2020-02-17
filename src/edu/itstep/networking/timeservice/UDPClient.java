/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itstep.networking.timeservice;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author user
 */
public class UDPClient {

    public static void main(String... arg) {
        String hostname = "localhost";
        int port = 124;
        try {
            InetAddress address = InetAddress.getByName(hostname);
            DatagramSocket socket = new DatagramSocket();

            byte[] buffer = new byte[512];

            DatagramPacket request = new DatagramPacket(buffer, buffer.length, address, port);
            System.out.println("request sent");
            socket.send(request);

            DatagramPacket response = new DatagramPacket(buffer, buffer.length);
            System.out.println("waiting response from server");
            socket.receive(response);

            String quote = new String(buffer, 0, response.getLength());
            
            System.out.println("Client received: " + quote);
            System.out.println("client closed");
        } catch (IOException io) {
            io.printStackTrace();
        }

    }
}
