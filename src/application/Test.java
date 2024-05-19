package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test extends Application {

    private GridPane gridPane;

    @Override
    public void start(Stage primaryStage) {
        // Create UI elements
        Label rowsLabel = new Label("Rows:");
        TextField rowsField = new TextField();
        rowsField.setPromptText("Enter number of rows");

        Label columnsLabel = new Label("Columns:");
        TextField columnsField = new TextField();
        columnsField.setPromptText("Enter number of columns");

        Button okButton = new Button("OK");
        
        // Set up the grid pane for seats
        gridPane = new GridPane();
        gridPane.setHgap(8);
        gridPane.setVgap(8);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: red");

        // Set up the main layout
        VBox vbox = new VBox(10, rowsLabel, rowsField, columnsLabel, columnsField, okButton, gridPane);
        vbox.setPadding(new Insets(10));
        vbox.setAlignment(Pos.TOP_CENTER);

        // Set button action
        okButton.setOnAction(event -> {
            int rows = Integer.parseInt(rowsField.getText());
            int columns = Integer.parseInt(columnsField.getText());
            generateSeatingChart(rows, columns);
        });

        // Create the scene and set the stage
        Scene scene = new Scene(vbox, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cinema Seating Chart");
        primaryStage.show();
    }

    // Method to generate seating chart
    private void generateSeatingChart(int rows, int columns) {
        gridPane.getChildren().clear(); // Clear existing buttons

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                Button seatButton = new Button();
                seatButton.setMinSize(40, 40); // Ensure buttons are square
                seatButton.setMaxSize(40, 40); // Allow buttons to expand

                // Set button text to row letter and column number
                String seatLabel = (char) ('A' + row) + String.valueOf(col + 1);
                seatButton.setText(seatLabel);

                // Optional: Add event handler for button clicks
                seatButton.setOnAction(event -> {
                    System.out.println("Seat " + seatButton.getText() + " clicked");
                });

                // Add button to gridPane
                gridPane.add(seatButton, col, row);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}


