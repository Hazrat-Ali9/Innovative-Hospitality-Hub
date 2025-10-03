package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Reception {
    @FXML
    private Button newCustomer;
    @FXML
    private void addNewCustomer() throws IOException {

        Parent root;
        root = FXMLLoader.load(getClass().getResource("newCustomerForm.fxml"));
        Stage RegStage=(Stage) newCustomer.getScene().getWindow();
        RegStage.setScene(new Scene(root,800,500));
    }
    @FXML
    private Button room;
    @FXML
    private void funcRoom() throws IOException {

        Parent root;
        root = FXMLLoader.load(getClass().getResource("roomInfo.fxml"));
        Stage RegStage=(Stage) room.getScene().getWindow();
        RegStage.setScene(new Scene(root,900,500));
    }
    @FXML
    private Button dept;
    @FXML
    private void funcDept() throws IOException {

        Parent root;
        root = FXMLLoader.load(getClass().getResource("department.fxml"));
        Stage RegStage=(Stage) dept.getScene().getWindow();
        RegStage.setScene(new Scene(root,800,500));
    }
    @FXML
    private Button empInfo;
    @FXML
    private void funcempInfo() throws IOException {

        Parent root;
        root = FXMLLoader.load(getClass().getResource("employeeInfo.fxml"));
        Stage RegStage=(Stage) empInfo.getScene().getWindow();
        RegStage.setScene(new Scene(root,800,500));
    }
    @FXML
    private Button custInfo;
    @FXML
    private void fucncustInfo() throws IOException {

        Parent root;
        root = FXMLLoader.load(getClass().getResource("customerInfo.fxml"));
        Stage RegStage=(Stage) custInfo.getScene().getWindow();
        RegStage.setScene(new Scene(root,800,500));
    }
    @FXML
    private Button managerInfo;
    @FXML
    private void funcmanagerInfo() throws IOException {

        Parent root;
        root = FXMLLoader.load(getClass().getResource("ManagerInfo.fxml"));
        Stage RegStage=(Stage) managerInfo.getScene().getWindow();
        RegStage.setScene(new Scene(root,800,500));

    }
    @FXML
    private Button checkOut;
    @FXML
    private void funcCheckOut() throws IOException {

        Parent root;
        root = FXMLLoader.load(getClass().getResource("checkOut.fxml"));
        Stage RegStage=(Stage) checkOut.getScene().getWindow();
        RegStage.setScene(new Scene(root,800,500));

    }
    @FXML
    private Button upCheckStatus;
    @FXML
    private void funcupCheckStatus() throws IOException {

        Parent root;
        root = FXMLLoader.load(getClass().getResource("updateCheckStatus.fxml"));
        Stage RegStage=(Stage) upCheckStatus.getScene().getWindow();
        RegStage.setScene(new Scene(root,800,500));


    }
    @FXML
    private Button upRoomStatus;
    @FXML
    private void funcupRoomStatus() throws IOException {

        Parent root;
        root = FXMLLoader.load(getClass().getResource("UpdateRoomStatus.fxml"));
        Stage RegStage=(Stage) upRoomStatus.getScene().getWindow();
        RegStage.setScene(new Scene(root,800,500));

    }
    @FXML
    private Button logOut;
    @FXML
    private void funcLogOut() throws Exception{
        Parent root;
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage RegStage=(Stage) logOut.getScene().getWindow();
        RegStage.setScene(new Scene(root,520,480));
    }
    @FXML
    private Button backBTN;
    @FXML
    private void backAction() throws Exception{
        Parent root;
        root = FXMLLoader.load(getClass().getResource("deshboard.fxml"));
        Stage RegStage=(Stage) backBTN.getScene().getWindow();
        RegStage.setScene(new Scene(root,595,365));
    }
}
