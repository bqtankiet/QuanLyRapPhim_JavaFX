module TestJavaFX {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.desktop;
	
	opens controllers to javafx.graphics,javafx.fxml;
	opens application to javafx.graphics, javafx.fxml;
    opens models to javafx.base;
    opens models.tableViewItem to javafx.base;
}