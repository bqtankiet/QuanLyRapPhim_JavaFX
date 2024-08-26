package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public abstract class AbstractController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initView();
		eventHandling();
	}

	public abstract void eventHandling();
	
	public abstract void initView();

}
