package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class dashboardController {

    @FXML
    private Button closeBtn;

    @FXML
    private Button ContactBtn;

    @FXML
    private Button receptionBTN;

    @FXML
    private Button addRoomBTN;

    @FXML
    private Button addEmployeeBTN;

    @FXML
    private Button bookingBTN;
    @FXML
    void ContactBtnAction(ActionEvent event) {

    }

    @FXML
    void ClosebtnAction(ActionEvent event) {
        Stage stage=(Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void addEmployeeAction(ActionEvent event) throws Exception {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("employee.fxml"));
        Stage RegStage = (Stage) addEmployeeBTN.getScene().getWindow();
        RegStage.setScene(new Scene(root,712,405));

    }

    @FXML
    void addRoomAction(ActionEvent event) throws Exception{
        Parent root;
        root = FXMLLoader.load(getClass().getResource("addRoom.fxml"));
        Stage RegStage = (Stage) addRoomBTN.getScene().getWindow();
        RegStage.setScene(new Scene(root,800,505));
    }

    @FXML
    void receptionAction(ActionEvent event) throws Exception{
        Parent root;
        root = FXMLLoader.load(getClass().getResource("reception.fxml"));
        Stage RegStage = (Stage) receptionBTN.getScene().getWindow();
        RegStage.setScene(new Scene(root,800,500));
    }

    @FXML
    void bookingAction(ActionEvent event)throws Exception{
        Parent root;
        root = FXMLLoader.load(getClass().getResource("requestInfo.fxml"));
        Stage RegStage = (Stage) bookingBTN.getScene().getWindow();
        RegStage.setScene(new Scene(root,750,450));
    }

    @FXML
    void customer_mail_view(ActionEvent event)throws Exception{
        Stage currentStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Admin_mail.fxml"));
        Scene scene = new Scene(root);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        currentStage.close();
        newStage.show();
    }

}
