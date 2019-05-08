package TempConversionSlider;

import javafx.application.Application;
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

import java.text.DecimalFormat;

import static java.lang.Math.abs;


public class TempConversionSlider extends Application {

    private static Stage window1;
    private static Slider slider;
    private static Label lblTop, sliderTempLabel, celc, cRough, validation, legend, diff;
    private static VBox mainBox, sliderBox, resultBox;
    private static HBox subBox, vCBox;
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

        slider.valueProperty().addListener((v, oldValue, newValue) -> {
            double delta = abs((slider.getValue() - 32)/1.8) - abs((slider.getValue() - 32)/2);
            DecimalFormat df2 = new DecimalFormat("###.##");
            diff.setText("Diffrenz:\n" + df2.format(delta));
            if (delta <= 1){
                valCircle.setFill(Color.LIME);
            }
            else if (delta > 1 && delta <= 2){
                valCircle.setFill(Color.YELLOW);
            }
            else{
                valCircle.setFill(Color.CRIMSON);
            }
        });
    }

    static Scene createMainframe(){
        mainBox = new VBox(10);
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setSpacing(30);
        mainBox.setPadding(new Insets(15, 15, 15, 15));


        Scene mainFrame = new Scene(mainBox, 550, 400);

        //Label at top of window
        lblTop = new Label("Stellen Sie die Temperatur in Fahrenheit mit dem Slider ein.\n"
                +"Das Programm rechnet die Werte automtisch um.");

        // Setting up slider box with label and styles

        //slider styling
        slider = new Slider(-30, 130, 25);
        slider.setMajorTickUnit(20);
        slider.setMinorTickCount(199);
        slider.setShowTickLabels(true);
        slider.setMinHeight(200);
        slider.setOrientation(Orientation.VERTICAL);

        // label with current slider value
        sliderTempLabel = new Label();
        sliderTempLabel.setStyle("-fx-font-size: 20");
        sliderTempLabel.setStyle("-fx-font-weight: 700");

        // slider box with styling
        sliderBox = new VBox();
        sliderBox.getChildren().addAll(sliderTempLabel, slider);
        sliderBox.setAlignment(Pos.CENTER);
        sliderBox.setMinWidth(180);
        sliderBox.setMinHeight(250);

        // Setting up the results box with all labels and styles

        // styling result labels
        celc = new Label("Genaue Berechnung: -.-- °C");
        celc.setStyle("-fx-font-size: 20");
        celc.setStyle("-fx-font-weight: 700");
        cRough = new Label("Grobe Berechnung: -.-- °C");
        cRough.setStyle("-fx-font-size: 20");
        cRough.setStyle("-fx-font-weight: 700");
        validation = new Label("Verlässlichkeit des groben Resultats:");
        validation.setStyle("-fx-font-size: 20");
        validation.setStyle("-fx-font-weight: 700");

        // styling indicator for difference validation
        valCircle = new Circle();
        valCircle.setRadius(15);
        valCircle.setStyle("-fx-stroke: black");
        legend = new Label("Abweichung:\nGrün: < 1°C\nGelb: 1-2°C\nRot: > 2°C");
        legend.setStyle("-fx-font-size: 10");
        diff = new Label();
        diff.setStyle("-fx-font-size: 10");

        // setting up box for validation
        vCBox = new HBox();
        vCBox.setSpacing(20);
        vCBox.getChildren().addAll(valCircle, diff, legend);

        // setting up full result box
        resultBox = new VBox();
        resultBox.getChildren().addAll(celc, cRough, validation, vCBox);
        resultBox.setMinWidth(200);
        resultBox.setSpacing(20);
        resultBox.setPadding(new Insets(15, 0, 0 ,0));

        // Sorting alignment of slider box and result box in HBox subBox
        subBox = new HBox();
        subBox.getChildren().addAll(sliderBox, resultBox);
        subBox.setSpacing(20);
        subBox.setStyle("-fx-background-color: mintcream");


        // Building the complete Layout of the main frame
        mainBox.getChildren().addAll(lblTop, subBox);
        return mainFrame;
    }

    public static void main(String[] args) {
        launch();
    }
}
