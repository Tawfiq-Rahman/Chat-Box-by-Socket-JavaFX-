package com.example.aoop_assignment;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Client_Read_Thread implements Runnable {
    ObjectInputStream OIS;
    Socket socket;
    public Client_Read_Thread(Socket socket) throws InterruptedException {
        this.socket=socket;
        Thread t = new Thread(this);
        t.start();

    }
    @Override
    public void run() {
        while(true){
            try {
                OIS = new ObjectInputStream(socket.getInputStream());
                String Cmsg=(String)OIS.readObject();
                System.out.println(Cmsg);

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }
}