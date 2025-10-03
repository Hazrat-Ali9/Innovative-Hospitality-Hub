package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Customer_Support {

    @FXML
    private TextArea message;

    @FXML
    private TextField subject;

    @FXML
    private TextField phnNo;

    @FXML
    void back_btn(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Customer_Dashboard.fxml"));
        Scene scene = new Scene(root);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        currentStage.close();
        newStage.show();
    }

    @FXML
    void clear_btn(ActionEvent event) {
        phnNo.setText("");
        subject.setText("");
        message.setText("");
    }

    @FXML
    void send_btn(ActionEvent event) {
        String phn_num = phnNo.getText();
        String mailSubject = subject.getText();
        String mailText = message.getText();

        String serverIP = "127.0.0.1";
        int serverPort = 11115;

        Mail mailObject = new Mail(0, phn_num, mailSubject, mailText, null);

        // Create a new thread to handle the network operation
        Thread sendThread = new Thread(() -> {
            try (Socket clientSocket = new Socket(serverIP, serverPort);
                 ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream())) {
                oos.writeObject(mailObject);
                oos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        sendThread.start(); // Start the thread
    }
}
