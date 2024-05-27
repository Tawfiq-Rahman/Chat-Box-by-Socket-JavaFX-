package com.example.aoop_assignment;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost",8080);
        System.out.println("Connected");


        new Client_Read_Thread(socket);
        new Client_Write_Thread(socket);

    }
}