package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RoomInfo implements Initializable {
    @FXML
    private TableView<RoomTable> roomInfo;
    @FXML
    private TableColumn<RoomTable,String> colroomNumber;
    @FXML
    private TableColumn<RoomTable,String> colavailability;
    @FXML
    private TableColumn<RoomTable,String> colcleanStatus;
    @FXML
    private TableColumn<RoomTable,String> colprice;
    @FXML
    private TableColumn<RoomTable,String> colbedType;

    ObservableList<RoomTable> roomList = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            ResultSet rs=connectDB.createStatement().executeQuery("SELECT * FROM `room` ORDER BY `room_number` ASC");
            while(rs.next()){
                roomList.add(new RoomTable(
                        rs.getString("room_number"),
                        rs.getString("availability"),
                        rs.getString("clean_status"),
                        rs.getString("price"),
                        rs.getString("bed_type")));
            }
        }catch (Exception ex){
            Logger.getLogger(RoomInfo.class.getName()).log(Level.SEVERE,null,ex);

        }

        colroomNumber.setCellValueFactory(new PropertyValueFactory<>("room_number"));
        colavailability.setCellValueFactory(new PropertyValueFactory<>("availability"));
        colcleanStatus.setCellValueFactory(new PropertyValueFactory<>("clean_status"));
        colprice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colbedType.setCellValueFactory(new PropertyValueFactory<>("bed_type"));
    }

    @FXML
    private Button loadData;
    @FXML
    private void funcLoadData(){
        roomInfo.setItems(roomList);
    }
    @FXML
    private Button back;
    @FXML
    private void funcBack() throws IOException {
        //System.out.println("B");
        Parent root;
        root = FXMLLoader.load(getClass().getResource("reception.fxml"));
        Stage RegStage=(Stage) back.getScene().getWindow();
        RegStage.setScene(new Scene(root,800,500));
    }

}
