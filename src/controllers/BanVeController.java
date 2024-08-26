package controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

    @FXML private Button chapNhanBtn;
    @FXML private DatePicker ngayChieuDatepicker;
    @FXML private ChoiceBox<Rap> rapChoicebox;
    @FXML private AnchorPane rootPane;
    @FXML private AnchorPane scrollAnchorPane;
    @FXML private ScrollPane scrollpane;
    @FXML private Button themSuatChieuBtn;
    @FXML private FlowPane cardLayout;

    @Override
    public void initView() {
        instance = this;
        initDatePicker();
        initRapChoiceBox();
    }

    @Override
    public void eventHandling() {
        handleChapNhanBtnAction();
        chapNhanBtn.fire();
    }

    // Load available movie cards
    private void loadAvailablePhimCards() {
        cardLayout.getChildren().clear();
        LichChieu lichChieu = new LichChieu(getSelectedRap(), getSelectedNgayChieu());
        Set<SuatChieu> suatChieuList = StorageSuatChieu.data.getOrDefault(lichChieu, new HashSet<>());

        Set<Phim> phimSet = suatChieuList.stream()
        					.map(SuatChieu::getPhim)
        					.collect(Collectors.toSet());

        if (!phimSet.isEmpty()) {
            addPhimCards(phimSet);
        }
    }

    // Add movie cards to the card layout
    private void addPhimCards(Set<Phim> phimSet) {
        cardLayout.getChildren().clear();
        for (Phim phim : phimSet) {
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

    // Get the selected cinema
    public Rap getSelectedRap() {
        return rapChoicebox.getSelectionModel().getSelectedItem();
    }

    // Get the selected screening date as a formatted string
    public String getSelectedNgayChieu() {
        LocalDate selectedDate = ngayChieuDatepicker.getValue();
        return selectedDate != null ? selectedDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "";
    }

    // Initialize the date picker with the current date
    private void initDatePicker() {
        ngayChieuDatepicker.setValue(LocalDate.now());
    }

    // Initialize the cinema choice box
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

    // Handle the "Accept" button action
    private void handleChapNhanBtnAction() {
        chapNhanBtn.setOnAction(event -> loadAvailablePhimCards());
    }
}
