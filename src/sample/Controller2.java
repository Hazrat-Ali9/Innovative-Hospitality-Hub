package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;

public class Controller2 {
    @FXML
    TextField msgTextField;

    @FXML
    Button sendButton;
    @FXML
    TextArea allTextArea;

    private BufferedWriter writer;
    private BufferedReader reader;

    public Controller2(){
        String myName="client-2: ";

        try {
            Socket socket=new Socket("127.0.0.1",5000);

            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(socket.getOutputStream());
            writer=new BufferedWriter(outputStreamWriter);
            InputStreamReader r= new InputStreamReader(socket.getInputStream());
            reader= new BufferedReader(r);

            writer.write(myName +"\n");
            writer.flush();



            //Without multi threading we can't read and write msg at the same time
          /*  Thread T=new Thread(){
                public void run(){
                    try {
                        String line= reader.readLine()+ "\n";
                        while (line !=null){
                            allTextArea.appendText(line);
                            line=reader.readLine()+"\n";

                        }


                    }catch (IOException e){
                        e.printStackTrace();
                    }

                }
            };
            T.start();

        }catch (IOException e){
            e.printStackTrace();
        }
    }*/
            Thread t = new Thread(){
                public void run(){
                    try{
                        String line = reader.readLine() + "\n";
                        while (line != null){
                            allTextArea.appendText(line);
                            line = reader.readLine() + "\n";
                        }
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    @FXML
    void msgSend(){
        try {
            String msg= msgTextField.getText()+ "\n";
            msgTextField.setText("");
            writer.write(msg);
            writer.flush();


        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
