package sample.fS;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClientSocketClass extends Application {
    @Override
    public void start(Stage primaryStage244) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fS.sample.fxml"));
        primaryStage244.setTitle("Third Client");
        primaryStage244.setScene(new Scene(root, 500, 475));
        primaryStage244.show();
    }
    public static void main(String[] args) {
        launch(args);

    }


}
