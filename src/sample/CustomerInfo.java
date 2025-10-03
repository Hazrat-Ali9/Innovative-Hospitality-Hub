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


public class CustomerInfo implements Initializable {
    @FXML
    private TableView<ModelTableCust> custInfo;
    @FXML
    private TableColumn<ModelTableCust,String> colID;
    @FXML
    private TableColumn<ModelTableCust,String> colNumber;
    @FXML
    private TableColumn<ModelTableCust,String> colName;
    @FXML
    private TableColumn<ModelTableCust,String> colGender;
    @FXML
    private TableColumn<ModelTableCust,String> colCountry;
    @FXML
    private TableColumn<ModelTableCust,String> colRoom;
    @FXML
    private TableColumn<ModelTableCust,String> colStatus;
    @FXML
    private TableColumn<ModelTableCust,String> colDeposit;

    ObservableList<ModelTableCust> CustList = FXCollections.observableArrayList();

    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            ResultSet rs=connectDB.createStatement().executeQuery("SELECT * FROM `customer` ORDER BY `id` ASC ");
            while(rs.next()){
               CustList.add(new ModelTableCust(
                        rs.getString("id"),
                        rs.getString("number"),
                       rs.getString("name"),
                        rs.getString("gender"),
                        rs.getString("country"),
                        rs.getString("room_number"),
                        rs.getString("status"),
                        rs.getString("deposit")));
            }
        }catch (Exception ex){
            Logger.getLogger(CustomerInfo.class.getName()).log(Level.SEVERE,null,ex);

        }

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colCountry.setCellValueFactory(new PropertyValueFactory<>("country"));
        colRoom.setCellValueFactory(new PropertyValueFactory<>("room_number"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colDeposit.setCellValueFactory(new PropertyValueFactory<>("deposit"));
    }
    @FXML
    private Button load;
    @FXML
    private void funcLoadData(){
        custInfo.setItems(CustList);
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
