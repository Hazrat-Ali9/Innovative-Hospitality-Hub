package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class CheckOut implements Initializable {
    PreparedStatement pst=null;
    PreparedStatement pst1=null;

    ObservableList<String> guestList = FXCollections.observableArrayList();


    @FXML
    private ComboBox<String> custCombo;

    @FXML
    private TextField room;

    @FXML
    private Button ok;

    @FXML
    private Button checkOut;

    @FXML
    private Button back;

    @FXML
    private Label msglabel;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            DatabaseConnection connectNow= new DatabaseConnection();
            Connection connectDB=connectNow.getConnection();
            String query = "SELECT * FROM customer ORDER BY number ASC";
            pst=connectDB.prepareStatement(query);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                guestList.add(rs.getString("number"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        custCombo.setItems(guestList);

    }

    @FXML
    void funcOK(ActionEvent event) {
        String s1 = custCombo.getValue();
        try{
            DatabaseConnection connectNow= new DatabaseConnection();
            Connection connectDB=connectNow.getConnection();
            String query1 = "SELECT * from customer where number="+s1;
            pst1=connectDB.prepareStatement(query1);
            ResultSet rs1=pst1.executeQuery();
            while(rs1.next()){
                room.setText(rs1.getString("room_number"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        ok.setDisable(true);

    }

    @FXML
    void funcCheckOut(ActionEvent event) {
        String s1 = custCombo.getValue();
        String s2 = room.getText();
        try{
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String deleteSQL = "Delete from customer where number = "+s1;
            String q2 = "update room set availability = 'Available' where room_number = "+s2;
            try {
                Statement statement = connectDB.createStatement();
                statement.executeUpdate(deleteSQL);
                statement.executeUpdate(q2);
                msglabel.setText("checkout successfull");
                checkOut.setDisable(true);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }catch (Exception ee){
            ee.printStackTrace();
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
    void funcCustCombo(ActionEvent event) {

    }



}
