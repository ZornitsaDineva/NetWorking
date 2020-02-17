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
import java.net.SocketException;
import java.util.Date;


/**
 *
 * @author user
 */
public class UDPServer {
    public static void main(String...arg){
        byte[] buffer = new byte[256];
        try (DatagramSocket socket = new DatagramSocket(124)) {
            DatagramPacket request = new DatagramPacket(buffer, buffer.length);
            System.out.println("waiting for a UDP client...");
            socket.receive(request);//accept in tcp
            InetAddress clientAddress = request.getAddress();
            int clientPort = request.getPort();
            String data = new Date().toString();
            buffer = data.getBytes();
            DatagramPacket response = new DatagramPacket(buffer, buffer.length, clientAddress, clientPort);
            socket.send(response);
            System.out.println("UDP server closed");
        } catch (SocketException se) {
            se.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
