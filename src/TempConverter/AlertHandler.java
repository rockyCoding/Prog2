package TempConverter;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

//Credit to https://github.com/buckyroberts/ and his JavaFX tutorials, this code ist partially copied from his tutorial repo. Great guy, great work :)

public class AlertHandler {

    public static void handleAlert(Stage window){
        Stage alert = new Stage();

        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setTitle("Begrenzungswarnung Temperaturkonverter");
        alert.setMinWidth(250);

        Label label = new Label("Sie haben die maximale Anzahl an Umrechnungen erreicht.");
        label.setTextFill(Color.web("#ce0a0a"));
        Button closeButton = new Button("OK");
        closeButton.setOnAction(e -> {
            window.setScene(finalScene());
            alert.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10, 10, 10, 10));

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        alert.setScene(scene);
        alert.showAndWait();

    }

    static Scene finalScene(){
        VBox box = new VBox();
        Scene finalScene = new Scene(box, 400, 320);

        box.setAlignment(Pos.CENTER);

        Label label = new Label("Sollten Sie weitere Umrechnungen machen wollen, \nstarten Sie das Programm bitte erneut.\n\n Vielen Dank fürs Nutzen dieses Temperaturkonverters.");
        box.getChildren().add(label);

        return finalScene;
    }
}
