package sample;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class SocketClass implements Runnable{
   /* public SocketClass() {

    }*/

    @Override
    public void run() {
        System.out.println("Waiting for connection");
        try {
            ServerSocket server = new ServerSocket(5000);
            ArrayList<Client> clients = new ArrayList<>();

            while (true) {
                try {
                    Socket socket = server.accept();

                    Client client = new Client(socket, clients);
                    clients.add(client);
                    Thread clientThread = new Thread(client);
                    clientThread.start();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }








    /*   public static void main(String[] args) {
       *//* try {
            //Creating a server which doesn't need any ip address for itself.
            ServerSocket server = new ServerSocket(5000);
           // System.out.println("Waiting for client");
            //Server will get request from client and with that we will make a socket object.
            Socket socket=server.accept();*//*
          *//*  System.out.println("Connected to client");
            //when client will set a massage we will read it using socket by InputStreamReader.
            *//**//*Here InputStreamReader object is creating with the help of socket class's communication channel
            * and InputStreamReader will return all the data that are coming from client
            * *//**//*
            InputStreamReader isr=new InputStreamReader(socket.getInputStream());

            *//**//*Now by using bufferReader we can read client's data*//**//*
            BufferedReader reader=new BufferedReader(isr);

            OutputStreamWriter o=new OutputStreamWriter(socket.getOutputStream());
            BufferedWriter writer=new BufferedWriter(o);

            String line=reader.readLine();
            while (line !=null){
                writer.write(line+" \n");
                writer.flush();
                System.out.println(line);
                line=reader.readLine();

            }*//*
        new SocketClass();

    }*/
}
