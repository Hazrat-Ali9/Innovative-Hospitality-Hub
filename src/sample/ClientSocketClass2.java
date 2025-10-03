package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class ClientSocketClass2 extends Application {
    @Override
    public void start(Stage primaryStage244) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("socketServer2.fxml"));
        primaryStage244.setTitle("Second Client");
        primaryStage244.setScene(new Scene(root, 500, 475));
        primaryStage244.show();
    }
    public static void main(String[] args) {
        launch(args);
      /*  try {
            Socket socket=new Socket("127.0.0.1",9999);
            //Server make a connection with client socket after getting the socket object

            *//*Sending Data through socket object*//*
            OutputStreamWriter osw=new OutputStreamWriter(socket.getOutputStream());
            *//*Writing msg to send*//*
            BufferedWriter writer=new BufferedWriter(osw);

            writer.write("Hello World \n");
            //We could use close(), but that would close the writer
            writer.flush();

            writer.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }*/




    }


}
