package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("deshboard.fxml"));
        primaryStage.setTitle("Hotel Management");
        primaryStage.setScene(new Scene(root, 750, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        Thread thread=new Thread(new socketCls());
        thread.start();
        launch(args);
    }
}
