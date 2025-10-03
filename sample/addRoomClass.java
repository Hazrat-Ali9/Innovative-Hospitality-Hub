package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class addRoomClass implements Initializable {

    @FXML
    private TextField availabilityTextField;

    @FXML
    private TextField RoomNumberTextField;

    @FXML
    private TextField PriceTextField;

    @FXML
    private Button BackToDashboardBtn;

    @FXML
    private ComboBox<String> cleaningComboBox;
    ObservableList<String> status = FXCollections.observableArrayList("Clean", "Dirty");

    @FXML
    private ComboBox<String> bedTypeComboBox;
    ObservableList<String> bedType = FXCollections.observableArrayList("single", "double");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cleaningComboBox.setItems(status);
        bedTypeComboBox.setItems(bedType);
    }

    @FXML
    void BackToDeshboardAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("deshboard.fxml"));
        Stage RegStage = (Stage) BackToDashboardBtn.getScene().getWindow();
        RegStage.setScene(new Scene(root, 595, 365));
    }

    @FXML
    void saveBtnAction(ActionEvent event) {
        String roomNumber = RoomNumberTextField.getText();
        String availability = availabilityTextField.getText();
        String price = PriceTextField.getText();
        String cleaningStatus = cleaningComboBox.getValue();
        String bedType = bedTypeComboBox.getValue();

        /* Database part */
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        if (!roomNumber.isBlank() && !availability.isBlank() && !price.isBlank() && cleaningStatus != null && bedType != null) {
            String insertFields = "INSERT INTO room(room_number, availability, price, clean_status, bed_type) VALUES('";
            String insertValues = roomNumber + "','" + availability + "','" + price + "','" + cleaningStatus + "','" + bedType + "')";
            String insertToRegister = insertFields + insertValues;

            try {
                Statement statement = connectDB.createStatement();
                statement.executeUpdate(insertToRegister);

                showAlert(AlertType.INFORMATION, "Success", "Room added successfully!");

            } catch (Exception e) {
                e.printStackTrace();
                showAlert(AlertType.ERROR, "Error", "An error occurred while adding the room.");
            }
        } else {
            showAlert(AlertType.WARNING, "Warning", "Please fill in all the fields and select options.");
        }
    }

    // Helper method to show alerts
    private void showAlert(AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
