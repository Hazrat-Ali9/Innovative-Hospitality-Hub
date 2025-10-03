package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Customer_Dashboard implements Initializable {

    @FXML
    private ImageView logo_image;

    @FXML
    void back_btn(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        Scene scene = new Scene(root);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        currentStage.close();
        newStage.show();
    }

    @FXML
    void book_room_button_action(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("customerScene.fxml"));
        Scene scene = new Scene(root);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        currentStage.close();
        newStage.show();
    }

    @FXML
    void close_btn(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void support_button_action(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Customer_Support.fxml"));
        Scene scene = new Scene(root);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        currentStage.close();
        newStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Image img = new Image(getClass().getResourceAsStream("pic/swimming-pool-beach-luxury-hotel-outdoor-pools-spa-amara-dolce-vita-luxury-hotel-resort-tekirova-kemer-turkey.jpg"));
        logo_image.setImage(img);

    }
}
