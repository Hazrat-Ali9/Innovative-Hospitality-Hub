package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;

public class CustRoomBookControll {
    BufferedReader reader;
    BufferedWriter writer;


    @FXML
    private TextField nameBox;
    @FXML
    private TextField dayBox;

    @FXML
    private TextField emailBox;

    @FXML
    private TextField idBox;

    @FXML
    private TextField depositeBox;

    @FXML
    private TextArea confirmArea;

    public CustRoomBookControll() {
        try {
            Socket socket = new Socket("127.0.0.1", 5678);

            OutputStreamWriter o = new OutputStreamWriter(socket.getOutputStream());
            writer = new BufferedWriter(o);

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(isr);


            // confirmArea.setText(res);
            // confirmArea.setText("");

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


    @FXML
    void cnlBTN(ActionEvent event) throws IOException{
        Platform.exit();
    }

    @FXML
    void sendBTN(ActionEvent event) {
        String name = nameBox.getText();
        String email = emailBox.getText();

        String id = idBox.getText();
        String deposit = depositeBox.getText();
        String day = dayBox.getText();

        try{
            writer.write("add\n");

            writer.write(name);
            writer.newLine();

            writer.write(email);
            writer.newLine();

            writer.write(id);
            writer.newLine();

            writer.write(deposit);
            writer.newLine();

            writer.write(day);
            writer.newLine();

            writer.flush();
            String r=reader.readLine();
            confirmArea.appendText(r);

            String r2=reader.readLine();
            confirmArea.setText(r2);

            reader.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }

}