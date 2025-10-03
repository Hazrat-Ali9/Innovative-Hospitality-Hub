package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;

public class AlertBox implements Runnable{
    @FXML
    private TextArea textAreaID;

    @FXML
    private Button YesBtn;

    @FXML
    private Button NoBtn;

    @FXML
    void NoBtnAction(ActionEvent event) {
        System.out.println("No");
    }

    @FXML
    void YesBtnAction(ActionEvent event) {
        System.out.println("Yes");
    }
    String string;
    public AlertBox(String st) {
        this.string=st;
        try {
            Stage primaryStage = new Stage();
            Parent root;
            // root = FXMLLoader.load(getClass().getResource("login.fxml"));
            //root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
            root = FXMLLoader.load(getClass().getResource("newCustomerForm.fxml"));
            primaryStage.initModality(Modality.APPLICATION_MODAL);
            primaryStage.setScene(new Scene(root, 700, 550));
            primaryStage.showAndWait();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void run() {

    }
    public void display(){

    }
}
