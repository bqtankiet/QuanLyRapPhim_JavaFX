package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test extends Application {

    @Override
    public void start(Stage primaryStage) {
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Item 1", "Item 2", "Item 3");

        ContextMenu contextMenu = new ContextMenu();
        for (int i = 0; i < 10; i++) { // Thêm 10 mục vào menu ngữ cảnh để thử nghiệm
            MenuItem menuItem = new MenuItem("Menu Item " + (i + 1));
            contextMenu.getItems().add(menuItem);
        }

        choiceBox.setContextMenu(contextMenu);

        // Thiết lập CSS để chỉ định kích thước cho mục trong menu ngữ cảnh
        String css = ".context-menu-item { -fx-pref-width: 100px; -fx-pref-height: 30px; }";
        contextMenu.getScene().getStylesheets().add("data:text/css," + css);

        VBox root = new VBox(choiceBox);
        Scene scene = new Scene(root, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ChoiceBox Context Menu Height Size");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
