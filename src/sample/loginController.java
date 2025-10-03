package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class loginController {

    @FXML
    private TextField userTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginbtn;
    @FXML
    private Button regBTN;

    @FXML
    private Button cancelbtn;
    @FXML
    private Label loginbtnlabel;


    @FXML
    void cancelbtnAction(ActionEvent event) {
        Stage stage=(Stage) cancelbtn.getScene().getWindow();
        stage.close();
    }
    @FXML
    void loginbtnAction(ActionEvent event) throws Exception {
        // loginbtnlabel.setText("You tried to login");
        if(userTextField.getText().isBlank()==false && passwordField.getText().isBlank()==false) validateLogin();
        else loginbtnlabel.setText("Please enter username and password");

    }
    @FXML
    void RegBtnAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
        Stage RegStage=(Stage) regBTN.getScene().getWindow();
        RegStage.setScene(new Scene(root,550,570));
    }

  public void validateLogin() {
        DatabaseConnection connectNow= new DatabaseConnection();
        Connection connectDB= connectNow.getConnection();

        String verifyLogin= "Select count(1) From user_account WHERE username= '" + userTextField.getText()+ "'AND password ='"+ passwordField.getText()+ "'";
        try {
            Statement statement=connectDB.createStatement();
            ResultSet queryResult= statement.executeQuery(verifyLogin);
            while (queryResult.next()){
                if (queryResult.getInt(1)==1){
                    Parent root;
                    root = FXMLLoader.load(getClass().getResource("deshboard.fxml"));
                    Stage RegStage=(Stage) loginbtn.getScene().getWindow();
                    RegStage.setScene(new Scene(root,595,365));

                }else {
                    loginbtnlabel.setText("Invalid Password");

                }

            }


        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }


}

