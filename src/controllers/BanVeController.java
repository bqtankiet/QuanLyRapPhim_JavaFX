package controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import models.LichChieu;
import models.Phim;
import models.Rap;
import models.SuatChieu;
import storage.StorageRap;
import storage.StorageSuatChieu;

public class BanVeController extends AbstractController {
    public static final String FXML = "/views/banve/banve.fxml";
    private static BanVeController instance;

    public static BanVeController getInstance() {
        return instance;
    }

    @FXML
    private Button chapNhanBtn;

    @FXML
    private DatePicker ngayChieuDatepicker;

    @FXML
    private ChoiceBox<Rap> rapChoicebox;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private AnchorPane scrollAnchorPane;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private Button themSuatChieuBtn;

    @FXML
    private FlowPane cardLayout;

    @Override
    public void initView() {
        instance = this;
    	loadAvailablePhimCards();
    	initDatePicker();
    	initRapChoiceBox();
    }
    
    @Override
    public void eventHandling() {
    	handleChapNhanBtnAction();
    }

    private void loadAvailablePhimCards() {
        cardLayout.getChildren().clear();

        LichChieu lc = new LichChieu(getSelectedRap(), getSelectedNgayChieu());
        Set<SuatChieu> listSC = StorageSuatChieu.data.getOrDefault(lc, new HashSet<>());

        Set<Phim> setPhim = listSC.stream()
                                  .map(SuatChieu::getPhim)
                                  .collect(Collectors.toSet());

        if (!setPhim.isEmpty()) {
            addPhimCards(setPhim);
        }
    }

    private void addPhimCards(Set<Phim> setPhim) {
        cardLayout.getChildren().clear();

        for (Phim phim : setPhim) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PhimCardController.FXML));
                VBox phimCard = fxmlLoader.load();
                PhimCardController cardController = fxmlLoader.getController();
                cardController.setData(phim);
                cardLayout.getChildren().add(phimCard);
            } catch (IOException e) {
            	e.printStackTrace();
            }
        }
    }

    public Rap getSelectedRap() {
        return rapChoicebox.getSelectionModel().getSelectedItem();
    }

    public String getSelectedNgayChieu() {
        LocalDate selectedDate = ngayChieuDatepicker.getValue();
        return selectedDate != null ? selectedDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "";
    }

    private void initDatePicker() {
        ngayChieuDatepicker.setValue(LocalDate.now());
    }

    private void initRapChoiceBox() {
        rapChoicebox.setItems(FXCollections.observableArrayList(StorageRap.data));

        rapChoicebox.setConverter(new StringConverter<>() {
            @Override
            public String toString(Rap rap) {
                return rap != null ? rap.getTenRap() : "";
            }

            @Override
            public Rap fromString(String string) {
                throw new UnsupportedOperationException("Conversion from String to Rap is not supported");
            }
        });
        rapChoicebox.getSelectionModel().selectFirst();
    }

    private void handleChapNhanBtnAction() {
        chapNhanBtn.setOnAction(event -> loadAvailablePhimCards());
    }
}
