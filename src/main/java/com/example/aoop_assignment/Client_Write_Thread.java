package com.example.aoop_assignment;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client_Write_Thread implements Runnable {

    ObjectOutputStream OOS;
    Socket socket;
    public Client_Write_Thread(Socket socket) throws InterruptedException {
        this.socket=socket;
        Thread t = new Thread(this);
        t.start();

    }
    @Override
    public void run() {
        while(true){
            Scanner scanner= new Scanner(System.in);
            String msg=scanner.nextLine();
            try {
                OOS= new ObjectOutputStream(socket.getOutputStream());
                OOS.writeObject(msg);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}