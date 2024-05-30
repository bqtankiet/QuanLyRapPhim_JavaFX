package models.statePattern;

import java.io.IOException;

import controllers.ChonGheNgoiController;
import controllers.DatVeController;
import controllers.ThongTinVeController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class ChonGheNgoiState implements StateDatVe {
    private DatVeController context;

    public ChonGheNgoiState(DatVeController context) {
        this.context = context;
    }

    @Override
    public void handleStep() {
        updateThongTinVe();
        loadChonGheNgoiView();
    }

    private void updateThongTinVe() {
        ThongTinVeController thongTinVeController = context.getThongTinVeController();
        var veXemPhim = context.getDatVe().getVeXemPhim();
        
        thongTinVeController.getThoiGianLbl().setText(veXemPhim.getThoiGian());
        thongTinVeController.getTenPhongLbl().setText(veXemPhim.getTenPhong());
        thongTinVeController.getPhuDeLbl().setText(veXemPhim.getPhuDe());
    }

    private void loadChonGheNgoiView() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ChonGheNgoiController.FXML));
            VBox chonGheNgoi = fxmlLoader.load();
            context.getStepDatVeArea().getChildren().add(chonGheNgoi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
