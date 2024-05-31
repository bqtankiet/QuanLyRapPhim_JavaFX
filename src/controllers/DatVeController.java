package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import models.DatVe;
import models.UserData;
import models.statePattern.ChonGheNgoiState;
import models.statePattern.ChonSuatChieuState;
import models.statePattern.StateDatVe;
import utils.PaneController;
import utils.SceneController;

public class DatVeController extends AbstractController {
	public static final String FXML = "/views/banve/DatVe.fxml";
	public static DatVeController instance;

	public static DatVeController getInstance() {
		return instance;
	}

	@FXML
	private HBox mainPane;

	@FXML
	private AnchorPane root;

	@FXML
	private StackPane stepDatVeArea;

	@FXML
	private VBox thongTinVeArea;

	private ThongTinVeController thongTinVeController;

	private DatVe datVe;

	private StateDatVe currentState;

	@Override
	public void eventHandling() {
		// TODO Auto-generated method stub
	}

	@Override
	public void initView() {
		instance = this;
		setCurrentState(new ChonSuatChieuState(this));
		currentState.handleStep();
	}

	public void nextStep() {
		if (currentState instanceof ChonSuatChieuState) {
			currentState = new ChonGheNgoiState(this);
		}
		currentState.handleStep();
	}

	public void closeView() {
		SceneController.GetInstance().removePane(root);
	}

	public static void displayView() {
		PaneController.getInstance().addPane(PaneController.getInstance().getRootPane(), DatVeController.FXML);
	}

	public void goBackStep1() {
		stepDatVeArea.getChildren().clear();
		currentState = new ChonSuatChieuState(this);
		currentState.handleStep();
	}

	public HBox getMainPane() {
		return mainPane;
	}

	public AnchorPane getRoot() {
		return root;
	}

	public StackPane getStepDatVeArea() {
		return stepDatVeArea;
	}

	public VBox getThongTinVeArea() {
		return thongTinVeArea;
	}

	public ThongTinVeController getThongTinVeController() {
		return thongTinVeController;
	}

	public DatVe getDatVe() {
		return datVe;
	}

	public StateDatVe getCurrentState() {
		return currentState;
	}

	public static void setInstance(DatVeController instance) {
		DatVeController.instance = instance;
	}

	public void setMainPane(HBox mainPane) {
		this.mainPane = mainPane;
	}

	public void setRoot(AnchorPane root) {
		this.root = root;
	}

	public void setStepDatVeArea(StackPane stepDatVeArea) {
		this.stepDatVeArea = stepDatVeArea;
	}

	public void setThongTinVeArea(VBox thongTinVeArea) {
		this.thongTinVeArea = thongTinVeArea;
	}

	public void setThongTinVeController(ThongTinVeController thongTinVeController) {
		this.thongTinVeController = thongTinVeController;
	}

	public void setDatVe(DatVe datVe) {
		this.datVe = datVe;
	}

	public void setCurrentState(StateDatVe currentState) {
		this.currentState = currentState;
	}

}
