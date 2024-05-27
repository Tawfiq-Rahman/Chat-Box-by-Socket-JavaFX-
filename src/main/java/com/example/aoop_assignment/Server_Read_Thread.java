package com.example.aoop_assignment;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

public class Server_Read_Thread implements Runnable{
    ObjectInputStream OIS;
    ObjectOutputStream OOS;
    Socket socket;
    String  name;
    String Smsg;
    public Server_Read_Thread(Socket socket, String  name){
        this.name = name;
        this.socket=socket;
        Thread thread= new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while(true){
            try {
                OIS = new ObjectInputStream(socket.getInputStream());
                Smsg = (String)OIS.readObject();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            for(Socket socket0 :Server.clientInfo.keySet()){

                if(socket0!=socket){
                    try {
                        OOS=new ObjectOutputStream(socket0.getOutputStream());
                        OOS.writeObject(name+": "+Smsg);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            System.out.println(name+" says: "+Smsg);

        }

    }
}