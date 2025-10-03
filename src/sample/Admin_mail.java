package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class Admin_mail implements Initializable {

    @FXML
    private TableView<Mail> customerMailTable;

    @FXML
    private TableColumn<Mail, String> message;

    @FXML
    private TableColumn<Mail, String> phnNo;

    @FXML
    private TableColumn<Mail, String> subject;

    @FXML
    void backBtn(ActionEvent event) throws Exception {
        Stage currentStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("deshboard.fxml"));
        Scene scene = new Scene(root);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        currentStage.close();
        newStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Mail> mailList = readDataFromFile("messages.csv");

        message.setCellValueFactory(data -> new ReadOnlyObjectWrapper<>(data.getValue().getMessage()));
        phnNo.setCellValueFactory(data -> new ReadOnlyObjectWrapper<>(data.getValue().getPhn_num()));
        subject.setCellValueFactory(data -> new ReadOnlyObjectWrapper<>(data.getValue().getSubject()));

        customerMailTable.getItems().addAll(mailList);
    }

    private List<Mail> readDataFromFile(String filePath) {
        List<Mail> mailList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) { // Check if the line has the correct number of fields
                    int id = Integer.parseInt(parts[0]);
                    String phn_num = parts[1];
                    String subject = parts[2];
                    String message = parts[3];
                    // You can parse and handle the date part (parts[4]) if needed

                    Mail mail = new Mail(id, phn_num, subject, message, null); // Replace null with actual date
                    mailList.add(mail);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mailList;
    }
}
