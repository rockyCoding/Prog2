package TempConverter;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LimitationHandler {

    static boolean restricted;

    public static boolean handleLimitation(){
        Stage limitation = new Stage();

        limitation.initModality(Modality.APPLICATION_MODAL);
        limitation.setTitle("Modus Temperaturkonverter");
        limitation.setMinWidth(350);

        Label label = new Label("In welchem Modus soll das Programm gestartet werden?");
        Button unlim = new Button("Unlimitiert");
        Button restr = new Button("Limitiert");

        HBox buttonRow = new HBox(10);
        buttonRow.setAlignment(Pos.CENTER);
        buttonRow.getChildren().addAll(unlim, restr);

        unlim.setOnAction(e -> {
            restricted = false;
            limitation.close();
        });
        restr.setOnAction(e -> {
            restricted = true;
            limitation.close();
        });

        VBox layout = new VBox(30);
        layout.getChildren().addAll(label, buttonRow);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10, 10, 10, 10));

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        limitation.setScene(scene);
        limitation.showAndWait();

        return restricted;
    }
}
