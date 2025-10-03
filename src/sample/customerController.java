package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
public class customerController  implements Initializable {

    @FXML
    private Label nameId;

    @FXML
    private ComboBox<String> methodBox;

    @FXML
    private ComboBox<String> roomCombo;

    @FXML
    private TextField numberText;

    @FXML
    private TextField custName;

    @FXML
    private TextField custCountry;

    @FXML
    private TextField custCheckedIn;

    @FXML
    private TextField custDeposit;

    @FXML
    private RadioButton male;

    @FXML
    private RadioButton female;

    @FXML
    private Button addBTN;

    @FXML
    private Button backBTN;

    @FXML
    private Label showlabel;

    @FXML
    private Label showlabel1;

    @FXML
    private TextField custEmail;


    PreparedStatement pst=null;


    ObservableList<String> methodList = FXCollections.observableArrayList("Passport", "National Id", "Driving license");
    ObservableList<String> roomList = FXCollections.observableArrayList();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        methodBox.setItems(methodList);
        try {
            DatabaseConnection connectNow= new DatabaseConnection();
            Connection connectDB=connectNow.getConnection();
            String query = "SELECT `room_number` FROM `room` Where `availability`!='Occupied' ORDER BY `room_number` ASC";
            pst=connectDB.prepareStatement(query);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                roomList.add(rs.getString("room_number"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        roomCombo.setItems(roomList);

    }
    @FXML
    void RoomComboAction(ActionEvent event) {

    }


    @FXML
    void addAction(ActionEvent event) {
        String id = methodBox.getValue();
        String number = numberText.getText();
        String name = custName.getText();
        String email = custEmail.getText();
        String country = custCountry.getText();
        String roomNum = roomCombo.getValue();
        String checkIn = custCheckedIn.getText();
        String deposit = custDeposit.getText();
        String gender = null;

        if (male.isSelected()) {
            gender = "male";
        } else if (female.isSelected()) {
            gender = "female";
        }
        String status = "pending";

        String entry = id + "," + number + "," + name + "," + email + "," + country + "," +
                roomNum + "," + checkIn + "," + deposit + "," + gender + ","+status+ "\n";

        saveEntryToCSV(entry);
    }

    private void saveEntryToCSV(String entry) {
        String filePath = "customer_room_book_data.csv";

        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.append(entry);
            writer.flush();
            showInsertSuccessAlert("Insert Success","Data inserted successfully!");
            clear();
        } catch (IOException e) {
            showInsertSuccessAlert("Insert Failed!","Data inserted Failed!");
            e.printStackTrace();
        }
    }

    private void showInsertSuccessAlert(String title, String text) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }

    @FXML
    void clear() {
        numberText.setText("");
        custName.setText("");
        custEmail.setText("");
        custCountry.setText("");
        roomCombo.setValue(null);
        custCheckedIn.setText("");
        custDeposit.setText("");
        male.setSelected(false);
        female.setSelected(false);
    }

    @FXML
    void backAction(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Customer_Dashboard.fxml"));
        Scene scene = new Scene(root);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        currentStage.close();
        newStage.show();
    }

    @FXML
    void methodAction(ActionEvent event) {

    }

    public void bookingInfo() {
        String id = methodBox.getValue();
        String number = numberText.getText();
        String name = custName.getText();
        String email = custEmail.getText();
        String country = custCountry.getText();
        String roomNum = roomCombo.getValue();
        String checkIn = custCheckedIn.getText();
        String deposit = custDeposit.getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "male";

        } else if (female.isSelected()) {
            gender = "female";
        }

        System.out.println(id + " " + number + " " + name + " " + country + " " + checkIn + " " + deposit + " " + gender);

        /*Database part*/
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        if (name.isBlank() == false && number.isBlank() == false && country.isBlank() == false && checkIn.isBlank() == false && gender.isBlank() == false && deposit.isBlank() == false && gender.isBlank() == false) {
            String insertFields = "INSERT INTO `customer`(`id` ,`number`,`name`,`email`,`gender`,`country`,`room_number`,`status`,`deposit`) VALUES('";
            String insertValues = id + "','" + number + "','" + name + "','" + email + "','" + gender + "','" + country + "','" + roomNum + "','" + checkIn + "','" + deposit + "')";
            String insertToRegister = insertFields + insertValues;
            String updateRoom = "update `room` set `availability` = 'Occupied' where `room_number` = " + roomNum;

            try {
                Statement statement = connectDB.createStatement();
                statement.executeUpdate(insertToRegister);
                statement.executeUpdate(updateRoom);
                showlabel.setText("User has been registered!");
                // addBTN.setDisable(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            showlabel1.setText("Fill all the label properly");
        }
    }
}
