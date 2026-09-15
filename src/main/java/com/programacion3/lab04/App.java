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
        content.setAlignment(Pos.TOP_CENTER);
        
        root.setPadding(new Insets(10));
        
        List<Label> labels = new ArrayList();
        
        labels.add(new Label("number of days on the trip"));
        labels.add(new Label("food expenses, per day"));
        labels.add(new Label("Amount of airfare, if any"));
        labels.add(new Label("Amount of car rental fees, if any"));
        labels.add(new Label("Number of miles driven, if a private vehicle was used"));
        labels.add(new Label("Amount of parking fees, if any"));
        labels.add(new Label("parking fees, if any"));
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
        content.add(calculateButt, 1, amountElements);
        GridPane bottom = new GridPane();
        List<Double> numInput = new ArrayList();
        
        calculateButt.setOnAction(e -> {
            numInput.clear();
            bottom.getChildren().clear();
                    
            for (TextField text: input) {
                String str = text.getCharacters().toString();
                 
                if (str.isEmpty()) {
                    numInput.add(0.0);
                } else {
                    try {
                        numInput.add(Double.parseDouble(str));
                    } catch (NumberFormatException p){
                        bottom.add(new Label("Invalid Input!"), 0 , 0);
                        return;
                    }
                }
            }
            
            double totalExpense = ExpenseCalculator.calculateTotalExpenses(numInput.get(0), numInput.get(1), numInput.get(2), numInput.get(3)
                    , numInput.get(4), numInput.get(5), numInput.get(6), numInput.get(7), numInput.get(8), numInput.get(9));
            
            boolean usedATaxi = numInput.get(7) == 0 ? false: true;
            
            double totalReimbursable = ExpenseCalculator.calculateTotalReimbursable(numInput.get(0), numInput.get(2), numInput.get(4),
                    numInput.get(5), numInput.get(6), usedATaxi, numInput.get(8));
            
            double balance = totalReimbursable - totalExpense;
            
            bottom.add(new Label("Total expenses: "), 0, 1);
            bottom.add(new Label("Allowed:"), 0, 2);
            bottom.add(new Label("Balance:"), 0, 3);
            bottom.add(new Label(String.format("$%.2f", totalExpense)), 1, 1);
            bottom.add(new Label(String.format("$%.2f", totalReimbursable)), 1, 2);
            bottom.add(new Label(String.format("$%.2f", balance)), 1, 3);
            
            
        });
        
        bottom.setVgap(10);
        bottom.setHgap(10);
        bottom.setAlignment(Pos.CENTER);
            
        root.setBottom(bottom);
        root.setCenter(content);
        
        Scene scene = new Scene(root, 680, 630);
       scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}