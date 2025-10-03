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

public class ManagerInfo implements Initializable {

    @FXML
    private TableView<ModelTableEmp> tableview;
    @FXML
    private TableColumn<ModelTableEmp,String> colName;
    @FXML
    private TableColumn<ModelTableEmp,String> colAge;
    @FXML
    private TableColumn<ModelTableEmp,String> colGender;
    @FXML
    private TableColumn<ModelTableEmp,String> colJob;
    @FXML
    private TableColumn<ModelTableEmp,String> colSalary;
    @FXML
    private TableColumn<ModelTableEmp,String> colPhone;
    @FXML
    private TableColumn<ModelTableEmp,String> colEmail;

    ObservableList<ModelTableEmp> EmpList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            ResultSet rs=connectDB.createStatement().executeQuery("SELECT * FROM `employee` Where job='Manager'");
            while(rs.next()){
                EmpList.add(new ModelTableEmp(
                        rs.getString("name"),
                        rs.getString("age"),
                        rs.getString("gender"),
                        rs.getString("job"),
                        rs.getString("salary"),
                        rs.getString("phone"),
                        rs.getString("email")));
            }
        }catch (Exception ex){
            Logger.getLogger(EmployeeInfo.class.getName()).log(Level.SEVERE,null,ex);

        }

        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colJob.setCellValueFactory(new PropertyValueFactory<>("job"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }
    @FXML
    private Button loadData;
    @FXML
    private void funcLoadData(){
        tableview.setItems(EmpList);
    }
    @FXML
    private Button back;
    @FXML
    private void funcBack() throws IOException {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("reception.fxml"));
        Stage RegStage=(Stage) back.getScene().getWindow();
        RegStage.setScene(new Scene(root,800,500));
    }


}

