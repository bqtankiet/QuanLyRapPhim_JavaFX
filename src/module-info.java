module TestJavaFX {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens controllers to javafx.fxml;
	opens application to javafx.graphics, javafx.fxml;
    opens models to javafx.base;
}