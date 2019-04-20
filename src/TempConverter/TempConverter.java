package TempConverter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class TempConverter extends Application {

    static Stage window1;
    static Button cToF, fToC, fCR, reset;
    static Label lblTop, result, celc, fahr, validation, counted;
    static TextField celcIn, fahrIn;
    static HBox inFields, buttonRow;
    static VBox mainBox, cFields, fFields;
    static int counter = 0;
    static boolean restriction;



    @Override
    public void start(Stage primaryStage){
        window1 = primaryStage;
        window1.setTitle("Temperaturkonverter: °C <=> F");

        cToF = new Button("°C zu F");
        fToC = new Button("F zu °C");
        fCR = new Button("grob F zu °C");
        reset = new Button("Zurücksetzen");

        Scene mainFrame = createMainframe();
        window1.setScene(mainFrame);
        window1.show();

        restriction = LimitationHandler.handleLimitation();

        cToF.setOnAction(e -> converter('c', celcIn.getText(), 1.8));
        fToC.setOnAction(e -> converter('f', fahrIn.getText(), 1.8));
        fCR.setOnAction(e -> converter('f', fahrIn.getText(), 2));
        reset.setOnAction(e -> resetMainFrame());


    }

    static void converter(char inSystem, String inString, double factor){
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

    }

    static void fieldSwitch(char inSystem){
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
    }

    static Scene createMainframe(){
        mainBox = new VBox(10);
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setSpacing(10);
        mainBox.setPadding(new Insets(10, 10, 10, 10));

        Scene mainFrame = new Scene(mainBox, 400, 320);

        //Label at top of window
        lblTop = new Label("Geben Sie den Temperaturwert ein,\n den Sie umrechnen möchten:");

        // Creating containers, labels and fields for text input
        inFields = new HBox(10);
        cFields = new VBox(5);
        fFields = new VBox(5);
        celc = new Label("Temp. °C");
        fahr = new Label("Temp. F");
        validation = new Label();
        celcIn = new TextField();
        fahrIn = new TextField();
        counted = new Label("Bisher getätigte Umrechnungen: " + counter);

        //Buildung structure for correct styling and alignment of input fields
        cFields.getChildren().addAll(celc, celcIn);
        cFields.setAlignment(Pos.CENTER);
        fFields.getChildren().addAll(fahr, fahrIn);
        fFields.setAlignment(Pos.CENTER);
        inFields.getChildren().addAll(cFields, fFields);
        inFields.setAlignment(Pos.CENTER);


        // Building row of converter buttons
        buttonRow = new HBox(5);
        buttonRow.getChildren().addAll(cToF, fToC, fCR);
        buttonRow.setAlignment(Pos.CENTER);

        // Building the complete Layout of the main frame
        mainBox.getChildren().addAll(lblTop, inFields, validation, buttonRow, reset, counted);
        return mainFrame;
    }

    public static void main(String[] args) {
        launch();
    }
}
