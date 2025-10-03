package sample;


import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class addEmployee implements Initializable {
    @FXML
    private TextField nameTextField;

    @FXML
    private TextField ageTextField;

    @FXML
    private TextField salaryTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private RadioButton male;

    @FXML
    private RadioButton female;

    @FXML
    private ComboBox<String> jobComboBox;

    ObservableList<String>list= FXCollections.observableArrayList("Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        jobComboBox.setItems(list);

    }
    @FXML
    private Button BackToDashboardBtn;

    @FXML
    private Button saveBtn;

    @FXML
    private Label confirmLabel;
    @FXML
    private Label confirmLabel1;

    @FXML
    void saveBtnAction(ActionEvent event) {
        String name = nameTextField.getText();
        String age = ageTextField.getText();
        String salary = salaryTextField.getText();
        String phone = phoneTextField.getText();
        String email = emailTextField.getText();
        String gender = null;

        if (male.isSelected()) {
            gender = "male";

        } else if (female.isSelected()) {
            gender = "female";
        }
        System.out.println(name + " " + age + " " + salary + " " + phone + " " + email + " " + gender + " " + jobComboBox.getValue());
        String job= jobComboBox.getValue();

        /*Database part*/
        DatabaseConnection connectNow= new DatabaseConnection();
        Connection connectDB=connectNow.getConnection();
        if (name.isBlank() == false && age.isBlank() == false && salary.isBlank() == false && phone.isBlank() == false && gender.isBlank()==false&& email.isBlank()==false && gender.isBlank()==false) {
            String insertFields = "INSERT INTO employee(name , age,gender,job, salary, phone,email) VALUES('";
            String insertValues = name + "','" + age + "','" + gender + "','" + job + "','" +salary+ "','" +phone+ "','" +email+"')";
            String insertToRegister = insertFields + insertValues;

            try {
                Statement statement = connectDB.createStatement();
                statement.executeUpdate(insertToRegister);
                confirmLabel1.setDisable(true);
                confirmLabel.setText("User has been registered successfully!");
                saveBtn.setDisable(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
           confirmLabel1.setText("Fill all the label properly");
        }
    }
    @FXML
    void BackToDeshboardAction(ActionEvent event) throws Exception{
        Parent root;
        root = FXMLLoader.load(getClass().getResource("deshboard.fxml"));
        Stage RegStage=(Stage) BackToDashboardBtn.getScene().getWindow();
        RegStage.setScene(new Scene(root,595,365));
    }


}

