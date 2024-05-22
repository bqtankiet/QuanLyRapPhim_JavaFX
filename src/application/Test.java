package application;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test extends Application {
    @Override
    public void start(Stage primaryStage) {
        TableView<Person> tableView = new TableView<>();
        ObservableList<Person> data = FXCollections.observableArrayList(
                new Person("John Doe"),
                new Person("Jane Doe")
        );

        TableColumn<Person, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        tableView.setItems(data);
        tableView.getColumns().add(nameColumn);

        TextField textField = new TextField();
        textField.setPromptText("Enter name");

        // Bind selected item to TextField
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        	if (oldSelection != null) {
                textField.textProperty().unbindBidirectional(oldSelection.nameProperty());
        	}
            if (newSelection != null) {
                textField.textProperty().bindBidirectional(newSelection.nameProperty());
            } else {
            	textField.setText("");
            }
        });

        VBox vbox = new VBox(tableView, textField);
        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public class Person {
        private final SimpleStringProperty name;

        public Person(String name) {
            this.name = new SimpleStringProperty(name);
        }

        public String getName() {
            return name.get();
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public SimpleStringProperty nameProperty() {
            return name;
        }
    }

}
