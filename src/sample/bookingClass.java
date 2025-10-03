package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class bookingClass extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root;
        // root = FXMLLoader.load(getClass().getResource("login.fxml"));
        //root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        root = FXMLLoader.load(getClass().getResource("CustRoomBook.fxml"));
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();

    }
}
