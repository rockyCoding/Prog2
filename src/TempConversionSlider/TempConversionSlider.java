package TempConversionSlider;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class TempConversionSlider extends Application {

    private static SimpleDoubleProperty precise, rough;
    private static Stage window1;
    private static Slider slider;
    private static Label lblTop, sliderTempLabel, celc, cRough, validation;
    private static VBox mainBox, sliderBox, resultBox;
    private static HBox subBox;
    private static Circle valCircle;


    @Override
    public void start(Stage Stage){
        window1 = Stage;
        window1.setTitle("Temperaturkonverter: F => °C");
        window1.setMinWidth(500);
        window1.setMaxHeight(320);

        Scene mainFrame = createMainframe();

        sliderTempLabel.textProperty().bind(slider.valueProperty().asString("%.2f F"));

        window1.setScene(mainFrame);
        window1.show();

        celc.textProperty().bind(slider.valueProperty().subtract(32).divide(1.8).asString("Genaue Berechnung: %.2f °C"));
        cRough.textProperty().bind(slider.valueProperty().subtract(32).divide(2).asString("Grobe Berechnung: %.2f °C"));


    }

    static Scene createMainframe(){
        mainBox = new VBox(10);
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setSpacing(30);
        mainBox.setPadding(new Insets(15, 15, 15, 15));


        Scene mainFrame = new Scene(mainBox, 450, 320);

        //Label at top of window
        lblTop = new Label("Stellen Sie die Temperatur in Fahrenheit mit dem Slider ein.\n"
                +"Das Programm rechnet die Werte automtisch um.");

        // Setting up slider box with label and styles
        slider = new Slider(-30, 90, 0);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(9);
        slider.setOrientation(Orientation.VERTICAL);
        sliderTempLabel = new Label();
        sliderTempLabel.setStyle("-fx-font-size: 20");
        sliderTempLabel.setStyle("-fx-font-weight: 700");
        sliderBox = new VBox();
        sliderBox.getChildren().addAll(sliderTempLabel, slider);
        sliderBox.setAlignment(Pos.CENTER);
        sliderBox.setMinWidth(100);

        // Setting up the results box with all labels and styles
        celc = new Label("Genaue Berechnung: -.-- °C");
        celc.setStyle("-fx-font-size: 20");
        celc.setStyle("-fx-font-weight: 700");
        cRough = new Label("Grobe Berechnung: -.-- °C");
        cRough.setStyle("-fx-font-size: 20");
        cRough.setStyle("-fx-font-weight: 700");
        validation = new Label("Verlässlichkeit des groben Resultats:");
        validation.setStyle("-fx-font-size: 20");
        validation.setStyle("-fx-font-weight: 700");
        valCircle = new Circle();
        valCircle.setRadius(15);
        valCircle.setFill(Color.LIME);

        resultBox = new VBox();
        resultBox.getChildren().addAll(celc, cRough, validation, valCircle);
        resultBox.setMinWidth(250);
        resultBox.setSpacing(20);

        // Sorting alignment of slider box and result box in HBox subBox
        subBox = new HBox();
        subBox.getChildren().addAll(sliderBox, resultBox);
        subBox.setSpacing(20);


        // Building the complete Layout of the main frame
        mainBox.getChildren().addAll(lblTop, subBox);
        return mainFrame;
    }

    public static void main(String[] args) {
        launch();
    }
}
