package com.example.slider;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 400,500);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);

        Label label = new Label("Slider sin nada ");
        Slider sl1 = new Slider();
        gridPane.add(label,0,0);
        gridPane.add(sl1,1,0);

        Label label2 = new Label("Slider con otros valores\n minimo, maximo e inicial ");
        Slider sl2 = new Slider();

        sl2.setMin(25);
        sl2.setMax(112);
        sl2.setValue(44);
        Label label3 = new Label("Valor actual:" + (int)sl2.getValue());
        sl2.valueProperty().addListener((obs, oldVal, newVal) -> {label3.setText(String.format("Valor actual: " + newVal.intValue()));});


        gridPane.add(label2,0,1);
        gridPane.add(sl2,1,1);
        gridPane.add(label3,1,2);

        Label label4 = new Label("Slider con marcas y con etiquetas");
        Slider sl3 = new Slider(0,100,50);
        sl3.setShowTickMarks(true);
        sl3.setShowTickLabels(true);

        gridPane.add(label4,0,3);
        gridPane.add(sl3,1,3);

        Label label5 = new Label("Lo mismo pero se pega el puntero");
        Slider sl4 = new Slider(0,100,50);
        sl4.setMinorTickCount(0);
        sl4.setShowTickMarks(true);
        sl4.setShowTickLabels(true);
        sl4.setSnapToTicks(true);
        sl4.setBlockIncrement(25);

        gridPane.add(label5,0,4);
        gridPane.add(sl4,1,4);

        Label label6 = new Label("Slider vertical ");
        Slider sl5 = new Slider(0,100,50);
        sl5.setOrientation(Orientation.VERTICAL);

        gridPane.add(label6,0,5);
        gridPane.add(sl5,1,5);

        Label label7 = new Label("Ejemplo de uso: ");
        Slider sl6 = new Slider(0,240,0);
        Rectangle rect =  new Rectangle(100,100, Color.BLACK);

        sl6.valueProperty().addListener((obs, oldVal, newVal) -> {int red = newVal.intValue();
        rect.setFill(Color.rgb(red,0,red));
        });




        gridPane.add(label7,0,6);
        gridPane.add(sl6,1,6);
        gridPane.add(rect,0,7);

        stage.setTitle("Slider");
        stage.setScene(scene);
        stage.show();
    }
}
