package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.Node;


public class WelcomeClass {
    @FXML
    private Button cancelBTN;

    @FXML
    private Button NextBTN;
    @FXML
    private Button customerBTN;

    @FXML
    void customerBTNAction(ActionEvent event)throws IOException {
       // Parent root;
        //root = FXMLLoader.load(getClass().getResource("customerScene.fxml"));
        //Stage RegStage=(Stage) customerBTN.getScene().getWindow();
        //RegStage.setScene(new Scene(root,700,550));

        Stage currentStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Customer_Dashboard.fxml"));
        Scene scene = new Scene(root);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        currentStage.close();
        newStage.show();

    }

    @FXML
    void NextBtnAction(ActionEvent event) throws IOException {

        Parent root;
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage RegStage=(Stage) NextBTN.getScene().getWindow();
        RegStage.setScene(new Scene(root,520,480));

        /*Stage stage=new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("scene6.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new javafx.scene.Scene(root, 600, 400));
        stage.show();*/

    }
    @FXML
    void CancelBtnAction(ActionEvent event) {
        Stage stage=(Stage) cancelBTN.getScene().getWindow();
        stage.close();


    }
}
