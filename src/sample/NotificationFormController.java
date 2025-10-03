package sample;/*@author:Dilshan Rajika Withanachchi*/

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.util.ResourceBundle;


public class NotificationFormController implements Initializable {
    Image image;
    public void btnNotifcationOnAction(ActionEvent actionEvent) {



        Notifications notifications=Notifications.create();
        notifications.graphic(new ImageView(image));
        notifications.text("Hello World!");
        notifications.title("Success Message");
        notifications.hideAfter(Duration.seconds(4));
        /*notifications.darkStyle();*/
     /*   notifications.position(Pos.BOTTOM_CENTER);*/
        notifications.show();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
