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
import java.sql.*;
import java.util.ResourceBundle;

public class UpdateRoomStatus implements Initializable {
    PreparedStatement pst=null;
    PreparedStatement pst1=null;
    PreparedStatement pst2=null;

    ObservableList<String> guestList = FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> guestID;

    @FXML
    private TextField roomNumber;

    @FXML
    private TextField availability;

    @FXML
    private TextField cleanStatus;

    @FXML
    private Button check;

    @FXML
    private Button update;

    @FXML
    private Button back;

    @FXML
    private Label showlabel;

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
        guestID.setItems(guestList);

    }

    @FXML
    void funcCheck(ActionEvent event) throws SQLException {
        String s1 = guestID.getValue();
        try{
            DatabaseConnection connectNow= new DatabaseConnection();
            Connection connectDB=connectNow.getConnection();
            String query1 = "SELECT * from customer where number="+s1;
            pst1=connectDB.prepareStatement(query1);
            ResultSet rs1=pst1.executeQuery();
            while(rs1.next()){
                roomNumber.setText(rs1.getString("room_number"));
              }
            }
        catch(Exception e){
            e.printStackTrace();
        }
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String query2 = "SELECT * from room where room_number = " + roomNumber.getText();
            pst2 = connectDB.prepareStatement(query2);
            ResultSet rs2 = pst2.executeQuery();
            while (rs2.next()) {
                availability.setText(rs2.getString("availability"));
                cleanStatus.setText(rs2.getString("clean_status"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }



    @FXML
    void funcUpdate(ActionEvent event) {
        try{
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            String str = "update room set clean_status = '"+cleanStatus.getText()+"' where room_number = "+roomNumber.getText();
            try {
                Statement statement = connectDB.createStatement();
                statement.executeUpdate(str);
                showlabel.setText("Update successfull");
                check.setDisable(true);
                update.setDisable(true);

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
    void guestIDCombo(ActionEvent event) {

    }

}
