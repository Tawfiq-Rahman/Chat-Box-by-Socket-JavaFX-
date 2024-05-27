package com.example.aoop_assignment;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Server_Write_Thread implements Runnable {
    ObjectOutputStream OOS;
    Socket socket;
    String name;
    String Smsg;
    public Server_Write_Thread(Socket socket, String  name,String msg){
        this.Smsg = msg;
        this.name=name;
        this.socket=socket;
        Thread thread= new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            OOS = new ObjectOutputStream(socket.getOutputStream());
            OOS.writeObject(Smsg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}