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

public class Department implements Initializable {
    @FXML
    private TableView<DepartmentTable> departmentInfo;
    @FXML
    private TableColumn<DepartmentTable,String> colDept;
    @FXML
    private TableColumn<DepartmentTable,String> colBudget;

    ObservableList<DepartmentTable> list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();
            ResultSet rs=connectDB.createStatement().executeQuery("SELECT * FROM `department`");
            while(rs.next()){
                list.add(new DepartmentTable(
                        rs.getString("department"),
                        rs.getString("budget")));
            }
        }catch (Exception ex){
            Logger.getLogger(RoomInfo.class.getName()).log(Level.SEVERE,null,ex);

        }

        colDept.setCellValueFactory(new PropertyValueFactory<>("department"));
        colBudget.setCellValueFactory(new PropertyValueFactory<>("budget"));
    }

    @FXML
    private Button load;
    @FXML
    private void funcLoad(){
        departmentInfo.setItems(list);
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

