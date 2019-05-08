package TempConversionSlider;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class TempConversionSlider extends Application {

    private static double exact, rough;
    private static Stage window1;
    private static Slider slider;
    private static Label lblTop, sliderTempLabel, celc, cRough, validation;
    private static VBox mainBox, sliderBox, resultBox, valBox;
    private static HBox cResBox, cRoughBox;



    @Override
    public void start(Stage Stage){
        window1 = Stage;
        window1.setTitle("Temperaturkonverter: F => °C");

        Scene mainFrame = createMainframe();

        sliderTempLabel.textProperty().bind(slider.valueProperty().asString("%f F"));

        window1.setScene(mainFrame);
        window1.show();

        /*cToF.setOnAction(e -> converter('c', celcIn.getText(), 1.8));
        fToC.setOnAction(e -> converter('f', fahrIn.getText(), 1.8));
        fCR.setOnAction(e -> converter('f', fahrIn.getText(), 2));
        reset.setOnAction(e -> resetMainFrame());*/


    }

    /*static void converter(char inSystem, String inString, double factor){
        double calc;
        DecimalFormat df2 = new DecimalFormat("###.##");
        if ((!restriction)||(counter < 3)) {
            try {
                double inValue = Double.parseDouble(inString);

                if (inSystem == 'c') {
                    validation.setText("");
                    calc = inValue * factor + 32;
                    result = new Label(Double.valueOf(df2.format(calc)) + " F");
                    fieldSwitch(inSystem);
                    counter++;
                    counted.setText("Bisher getätigte Umrechnungen: " + counter);
                } else {
                    validation.setText("");
                    calc = (inValue - 32) / factor;
                    result = new Label(Double.valueOf(df2.format(calc)) + " °C");
                    fieldSwitch(inSystem);
                    counter++;
                    counted.setText("Bisher getätigte Umrechnungen: " + counter);
                }
            } catch (Exception e) {
                validation.setTextFill(Color.web("#ce0a0a"));
                validation.setText("Eingabe ungültig! \nBitte nur Zahlen eingeben. (Bsp. 23.5)");
                inString = null;
                celcIn.clear();
                fahrIn.clear();
            }
        }
        else {
            AlertHandler.handleAlert(window1);
        }

    }*/

    /*static void fieldSwitch(char inSystem){
        if (inSystem == 'c'){
            mainBox.getChildren().remove(buttonRow);
            fFields.getChildren().remove(fahrIn);
            fFields.getChildren().add(result);
        }
        else {
            mainBox.getChildren().remove(buttonRow);
            cFields.getChildren().remove(celcIn);
            cFields.getChildren().add(result);
        }
    }

    static void resetMainFrame(){
        if((!restriction)||(counter < 3)) {
            window1.setScene(createMainframe());
        }
        else{
            AlertHandler.handleAlert(window1);
        }
    }*/

    static Scene createMainframe(){
        mainBox = new VBox(10);
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setSpacing(10);
        mainBox.setPadding(new Insets(15, 15, 15, 15));
        mainBox.setStyle("-fx-background-color: lightblue");

        Scene mainFrame = new Scene(mainBox, 450, 320);

        //Label at top of window
        lblTop = new Label("Stellen Sie die Temperatur in Fahrenheit mit dem Slider ein.\n"
                +"Das Programm rechnet die Werte automtisch um.");

        // Creating slider box with label and styles
        slider = new Slider(-30, 90, 0);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(9);
        slider.setOrientation(Orientation.HORIZONTAL);
        //slider.setStyle();
        sliderTempLabel = new Label();
        sliderBox = new VBox();
        sliderBox.getChildren().addAll(sliderTempLabel, slider);

        // not here
        /*celc = new Label("Genaue Umrechnung: ");
        cRough = new Label("Grobe Umrechnung: ");
        validation = new Label("Verlässlichkeit grobe Umrechnung:");

        cResBox = new HBox();
        cResBox.getChildren().addAll(celc);

        cRoughBox = new HBox();*/


        //Buildung structure for correct styling and alignment of input fields
        /*cFields.getChildren().addAll(celc, celcIn);
        cFields.setAlignment(Pos.CENTER);
        fFields.getChildren().addAll(cRough, fahrIn);
        fFields.setAlignment(Pos.CENTER);
        inFields.getChildren().addAll(cFields, fFields);
        inFields.setAlignment(Pos.CENTER);*/


        // Building row of converter buttons
        /*buttonRow = new HBox(5);
        buttonRow.getChildren().addAll(cToF, fToC, fCR);
        buttonRow.setAlignment(Pos.CENTER);*/

        // Building the complete Layout of the main frame
        mainBox.getChildren().addAll(lblTop, sliderBox);
        return mainFrame;
    }

    public static void main(String[] args) {
        launch();
    }
}
