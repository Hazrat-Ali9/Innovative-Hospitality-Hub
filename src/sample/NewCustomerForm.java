package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class NewCustomerForm implements Initializable {

    PreparedStatement pst=null;
    @FXML
    private ComboBox<String> custIdCombo;
    @FXML
    private ComboBox<String> roomCombo;


    ObservableList<String> custIdlist = FXCollections.observableArrayList("Passport", "National Id", "Driving license");
    ObservableList<String> roomList = FXCollections.observableArrayList();





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
    private Button add;

    @FXML
    private Button back;
    @FXML
    private Label  showlabel;
    @FXML
    private Label showlabel1;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        custIdCombo.setItems(custIdlist);
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
    void funcAdd(ActionEvent event) {
        String id=custIdCombo.getValue();
        String number = numberText.getText();
        String name = custName.getText();
        String country=custCountry.getText();
        String roomNum=roomCombo.getValue();
        String checkIn = custCheckedIn.getText();
        String deposit = custDeposit.getText();
        String gender = null;

        if (male.isSelected()) {
            gender = "male";

        } else if (female.isSelected()) {
            gender = "female";
        }

        //System.out.println(id+" "+number+" "+name + " " + country + " " + checkIn + " " + deposit + " "+ gender);

        /*Database part*/
        DatabaseConnection connectNow= new DatabaseConnection();
        Connection connectDB=connectNow.getConnection();
        if (name.isBlank() == false && number.isBlank() == false && country.isBlank() == false && checkIn.isBlank() == false && gender.isBlank()==false&& deposit.isBlank()==false && gender.isBlank()==false) {
            String insertFields = "INSERT INTO `customer`(`id` ,`number`,`name`,`gender`,`country`,`room_number`,`status`,`deposit`) VALUES('";
            String insertValues = id + "','" + number+ "','" + name + "','" + gender + "','" +country+"','"+roomNum+"','" +checkIn+ "','" +deposit+"')";
            String insertToRegister = insertFields + insertValues;
            String updateRoom = "update `room` set `availability` = 'Occupied' where `room_number` = "+roomNum;

            try {
                Statement statement = connectDB.createStatement();
                statement.executeUpdate(insertToRegister);
                statement.executeUpdate(updateRoom);
                showlabel.setText("User has been registered!");
                add.setDisable(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            showlabel1.setText("Fill all the label properly");
        }

    }

    @FXML
    void funcBack(ActionEvent event) throws IOException {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("reception.fxml"));
        Stage RegStage=(Stage) back.getScene().getWindow();
        RegStage.setScene(new Scene(root,800,500));

    }

    @FXML
    void funcCustIdCombo(ActionEvent event) {

    }

    @FXML
    void funcRoomCombo(ActionEvent event) {

    }



}
