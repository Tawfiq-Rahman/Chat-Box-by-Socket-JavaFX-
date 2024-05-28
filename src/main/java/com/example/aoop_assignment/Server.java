package com.example.aoop_assignment;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {


    public static HashMap<Socket,String>clientInfo =new HashMap<>();
    public static void main(String[] args) throws IOException {
        InetAddress localhost= InetAddress.getByName("localhost");
        ServerSocket serverSocket = new ServerSocket(8080,0,localhost );
        System.out.println("Server is started on ip: "+localhost.getHostAddress()+" and port: "+serverSocket.getLocalPort());

        int i=0;
        while (true){
            Socket socket = serverSocket.accept();

            String name= "Client-"+i;

            clientInfo.put(socket,name);
            System.out.println(name+" joined");

            ObjectOutputStream OOS = new ObjectOutputStream(socket.getOutputStream());
            OOS.writeObject("You are "+name);


            new Server_Read_Thread(socket,name);



            i++;
        }


    }
}