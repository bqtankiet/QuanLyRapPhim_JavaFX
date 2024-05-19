package utils;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class AlertDialog{

	public static boolean showConfirmAlert(String message) {
		 // Create a confirmation alert
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Thông báo");
        confirmAlert.setHeaderText(message);

        // Show the alert and wait for user response
        Optional<ButtonType> result = confirmAlert.showAndWait();

        // Handle the user response
        if (result.isPresent() && result.get() == ButtonType.OK) {
        	return true;
        } else {
        	return false;
        }
	}
	
}
