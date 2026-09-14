package com.programacion3.lab04;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        GridPane content = new GridPane();
        
        content.setVgap(10);
        content.setHgap(10);
        content.setAlignment(Pos.CENTER);
        
        root.setPadding(new Insets(10));
        
        List<Label> labels = new ArrayList();
        
        labels.add(new Label("number of days on the trip"));
        labels.add(new Label("food expenses, per day"));
        labels.add(new Label("Amount of airfare, if any"));
        labels.add(new Label("Amount of car rental fees, if any"));
        labels.add(new Label("Number of miles driven, if a private vehicle was used"));
        labels.add(new Label("Amount of parking fees, if any"));
        labels.add(new Label("Amount of taxi charges, if any"));
        labels.add(new Label("Conference or seminar registration fees, if any"));
        labels.add(new Label("Lodging charges, per night"));
        
        List<TextField> input = new ArrayList();
        
        int amountElements = labels.size();
        
        for (Label label: labels) {
            input.add(new TextField());
        }    
        
        for (int i = 0; i < amountElements; i++) {
            content.add(labels.get(i), 0, i);
            content.add(input.get(i), 1, i);
        }
        
        Button calculateButt = new Button("Calculate");
        Label output = new Label("");
        
        GridPane bottom = new GridPane();
        bottom.add(calculateButt, 0, 0);
        bottom.add(output, 1, 0);
        
        bottom.setVgap(10);
        bottom.setHgap(10);
        bottom.setAlignment(Pos.CENTER);
        
        root.setCenter(content);
        root.setBottom(bottom);
        var scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}